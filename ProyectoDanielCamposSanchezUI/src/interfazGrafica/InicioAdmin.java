package interfazGrafica;

import capaLogica.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class InicioAdmin {

    public Label txtNombreUsuario;
    UsuarioAdministrador adminUser = new UsuarioAdministrador();

    @FXML
    public void initialize(UsuarioAdministrador admin) throws IOException {
        txtNombreUsuario.setText("Hola, "+ admin.getNombre());
        this.adminUser = admin;
    }

    public void salir(ActionEvent actionEvent) {
        ( (Stage) ( ( (Button)actionEvent.getSource() ).getScene().getWindow() ) ).close();
        System.exit(0);
    }

    public void mostrarUsuarios(ActionEvent actionEvent) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminUsuarios.fxml"));
            Parent root = loader.load();
            Stage stageAdminUsuarios = new Stage();
            stageAdminUsuarios.setScene(new Scene(root, 600, 400));
            AdminUsuarios controllerAdminUsuarios = loader.getController();
            controllerAdminUsuarios.initialize(adminUser);
            stageAdminUsuarios.show();

            ( (Stage) ( ( (Button)actionEvent.getSource() ).getScene().getWindow() ) ).close();

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void mostrarProductos(ActionEvent actionEvent) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminProductos.fxml"));
            Parent root = loader.load();
            Stage stageAdminProductos = new Stage();
            stageAdminProductos.setScene(new Scene(root, 600, 400));
            AdminProductos controllerAdminProductos = loader.getController();
            controllerAdminProductos.initialize(adminUser);
            stageAdminProductos.show();

            ( (Stage) ( ( (Button)actionEvent.getSource() ).getScene().getWindow() ) ).close();

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

}
