package interfazGrafica;

import capaLogica.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.PrintStream;
import java.util.ArrayList;

public class InicarSesion {
    static CL cl = new CL();
    public TextField txtCodigo;
    public TextField txtPassword;
    public CheckBox checkAdministrador;
    public Label inicioInfoLabel;


    public void salir(ActionEvent actionEvent) {
        ( (Stage) ( ( (Button)actionEvent.getSource() ).getScene().getWindow() ) ).close();
        System.exit(0);
    }

    public void iniciarSesion(ActionEvent actionEvent) {
        if (checkAdministrador.isSelected()) {
            //Admin
            UsuarioAdministrador admin = new UsuarioAdministrador();
            admin.setCodigo(txtCodigo.getText());
            admin.setPassword(txtPassword.getText());
            ArrayList<UsuarioAdministrador> admins = cl.listarAdministradores();
            for (UsuarioAdministrador user : admins) {
                if (user.getCodigo().equals(txtCodigo.getText()) && user.getPassword().equals(txtPassword.getText())) {
                    admin = user;
                    if (cl.iniciaSesionAdmin(admin)){
                        mostrarInicioAdmin(admin, actionEvent);
                        break;
                    }
                }else{
                    inicioInfoLabel.setText("¡Informacion incorrecta!");
                    inicioInfoLabel.setTextFill(Color.RED);
                }
            }
        }else {
            //Comun
            UsuarioComun comun = new UsuarioComun();
            comun.setCodigo(txtCodigo.getText());
            comun.setPassword(txtPassword.getText());
            ArrayList<UsuarioComun> comunes = cl.listarComunes();
            for (UsuarioComun user: comunes){
                if (user.getCodigo().equals(txtCodigo.getText()) && user.getPassword().equals(txtPassword.getText())) {
                    comun = user;
                    if (cl.iniciaSesionComun(comun)){
                        mostrarInicioComun(comun, actionEvent);
                        break;
                    }
                } else{
                    inicioInfoLabel.setText("¡Informacion incorrecta!");
                    inicioInfoLabel.setTextFill(Color.RED);
                }
            }

        }

    }

    public void mostrarInicioAdmin(UsuarioAdministrador admin, ActionEvent actionEvent){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InicioAdmin.fxml"));
            Parent root = loader.load();
            Stage stageInicioAdmin = new Stage();
            stageInicioAdmin.setScene(new Scene(root, 600, 400));
            InicioAdmin controllerInicioAdmin = loader.getController();
            controllerInicioAdmin.initialize(admin);
            stageInicioAdmin.show();

            ( (Stage) ( ( (Button)actionEvent.getSource() ).getScene().getWindow() ) ).close();

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void mostrarInicioComun(UsuarioComun comun, ActionEvent actionEvent){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InicioComun.fxml"));
            Parent root = loader.load();
            Stage stageInicioComun = new Stage();
            stageInicioComun.setScene(new Scene(root, 600, 400));
            InicioComun controllerInicioComun = loader.getController();
            controllerInicioComun.initialize(comun);

            stageInicioComun.show();
            ( (Stage) ( ( (Button)actionEvent.getSource() ).getScene().getWindow() ) ).close();

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}
