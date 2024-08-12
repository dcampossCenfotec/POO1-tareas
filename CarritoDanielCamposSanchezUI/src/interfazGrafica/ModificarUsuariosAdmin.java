package interfazGrafica;

import capaLogica.CL;
import capaLogica.UsuarioAdministrador;
import capaLogica.UsuarioComun;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ModificarUsuariosAdmin {
    CL cl = new CL();
    UsuarioAdministrador adminUser = new UsuarioAdministrador();
    public ObservableList<UsuarioAdministrador> adminsOL = FXCollections.observableArrayList();
    public Label lblInfo;

    public TableView<UsuarioAdministrador> tblUsuariosAdmins;
    public TableColumn<UsuarioAdministrador, String> colCodigoAdmin;
    public TableColumn<UsuarioAdministrador, String> colNombreAdmin;
    public TableColumn<UsuarioAdministrador, String> colPasswordAdmin;
    public TableColumn<UsuarioAdministrador, Boolean> colEnSesionAdmin;

    public TextField txtCodigo;
    public TextField txtNombre;
    public TextField txtPassword;

    @FXML
    public void initialize(UsuarioAdministrador admin){
        this.adminUser = admin;
        ArrayList<UsuarioAdministrador> adminsFromDB = cl.listarAdministradores();
        ArrayList<UsuarioComun> comunesFromDB = cl.listarComunes();

        if(!adminsFromDB.isEmpty()){
            for(UsuarioAdministrador tmpAdmin : adminsFromDB){
                adminsOL.add(tmpAdmin);
                tblUsuariosAdmins.setItems(adminsOL);

                colCodigoAdmin.setCellValueFactory(new PropertyValueFactory<UsuarioAdministrador, String>("codigo"));
                colNombreAdmin.setCellValueFactory(new PropertyValueFactory<UsuarioAdministrador, String>("nombre"));
                colPasswordAdmin.setCellValueFactory(new PropertyValueFactory<UsuarioAdministrador, String>("password"));
                colEnSesionAdmin.setCellValueFactory(new PropertyValueFactory<UsuarioAdministrador, Boolean>("enSesion"));
            }
        }
    }

    @FXML
    public void regresar(ActionEvent actionEvent){
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

    @FXML
    public void modificar(){
        UsuarioAdministrador admin = new UsuarioAdministrador(txtCodigo.getText(), txtNombre.getText(), txtPassword.getText(), false);
        if (cl.actualizarAdministrador(admin)){
            lblInfo.setText("Modificacion exitosa");
            lblInfo.setTextFill(Color.GREEN);
        }else{
            lblInfo.setText("No se pudo modificar");
            lblInfo.setTextFill(Color.RED);
        }
    }
}
