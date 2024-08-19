package interfazGrafica;

import capaLogica.CL;
import capaLogica.UsuarioAdministrador;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrarAdministradores {
    static CL cl = new CL();
    public TextField txtCodigoAdmin;
    public TextField txtNombreAdmin;
    public TextField txtPasswordAdmin;
    public Label lblMensajeRegistro;

    public void onRegistrarAdmins(ActionEvent actionEvent) {
        UsuarioAdministrador admin = new UsuarioAdministrador(txtCodigoAdmin.getText(),txtNombreAdmin.getText(), txtPasswordAdmin.getText(), false);
        boolean puedeRegistrar = cl.insertarUsuarioAdministrador(admin);
        if (puedeRegistrar) {
            lblMensajeRegistro.setText("Admin registrado exitosamente");
            lblMensajeRegistro.setTextFill(Color.GREEN);
        }else{
            lblMensajeRegistro.setText("Admin no pudo registarse");
            lblMensajeRegistro.setTextFill(Color.RED);
        }
    }

    public void onIniciarSesion(ActionEvent actionEvent) throws IOException {
        //Iniciar sesion
        FXMLLoader loader = new FXMLLoader(getClass().getResource("IniciarSesion.fxml"));
        Parent root = loader.load();
        Stage stageIniciarSesion = new Stage();
        stageIniciarSesion.setScene(new Scene(root, 869, 685));
        stageIniciarSesion.setTitle("Iniciar Sesion");
        stageIniciarSesion.show();

        ( (Stage) ( ( (Button)actionEvent.getSource() ).getScene().getWindow() ) ).close();
    }
}
