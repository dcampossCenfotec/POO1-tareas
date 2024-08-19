package interfazGrafica;

import capaLogica.CL;
import capaLogica.Genero;

import capaLogica.Usuario;

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

public class AgregarGeneros {
    CL cl = new CL();
    Usuario adminUser = new Usuario();
    public ObservableList<Genero> generosOL = FXCollections.observableArrayList();

    public TableView<Genero> tblGeneros;
    public TableColumn<Genero, Integer> colId;
    public TableColumn<Genero, String> colNombre;

    public TextField txtNombre;
    public Label lblInfo;

    @FXML
    public void initialize(Usuario admin){
        this.adminUser = admin;
        ArrayList<Genero> generosFromDB = cl.listarGeneros();

        if(!generosFromDB.isEmpty()){
            for(Genero tmpGenero : generosFromDB){
                generosOL.add(tmpGenero);
                tblGeneros.setItems(generosOL);

                colId.setCellValueFactory(new PropertyValueFactory<Genero, Integer>("PK_ID_Genero"));
                colNombre.setCellValueFactory(new PropertyValueFactory<Genero, String>("nombre"));
            }
        }
    }

    @FXML
    public void agregar(){
        Genero genero = new Genero();
        genero.setNombre(txtNombre.getText());
        if (cl.insertarGenero(genero)){
            lblInfo.setText("Registro exitoso");
            lblInfo.setTextFill(Color.GREEN);
        }else{
            lblInfo.setText("Producto no se pudo registrar");
            lblInfo.setTextFill(Color.RED);
        }
    }

    @FXML
    public void regresar(ActionEvent actionEvent){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InicioGeneros.fxml"));
            Parent root = loader.load();
            Stage stageInicioGeneros = new Stage();
            stageInicioGeneros.setScene(new Scene(root, 600, 400));
            InicioGeneros controllerInicioGeneros = loader.getController();
            controllerInicioGeneros.initialize(adminUser);
            stageInicioGeneros.show();

            ( (Stage) ( ( (Button)actionEvent.getSource() ).getScene().getWindow() ) ).close();

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}
