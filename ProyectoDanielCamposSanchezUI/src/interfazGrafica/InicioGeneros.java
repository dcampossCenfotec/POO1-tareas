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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;

public class InicioGeneros {
    CL cl = new CL();
    Usuario adminUser = new Usuario();
    public ObservableList<Genero> generosOL = FXCollections.observableArrayList();

    public TableView<Genero> tblGenero;
    public TableColumn<Genero, Integer> colId;
    public TableColumn<Genero, String> colNombre;

    @FXML
    public void initialize(Usuario admin){
        this.adminUser = admin;
        ArrayList<Genero> generosFromDB = cl.listarGeneros();

        if(!generosFromDB.isEmpty()){
            for(Genero tmpGenero : generosFromDB){
                generosOL.add(tmpGenero);
                tblGenero.setItems(generosOL);

                colId.setCellValueFactory(new PropertyValueFactory<Genero, Integer>("PK_ID_Genero"));
                colNombre.setCellValueFactory(new PropertyValueFactory<Genero, String>("Nombre"));
            }
        }
    }

    @FXML
    public void agregar(ActionEvent actionEvent){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AgregarGeneros.fxml"));
            Parent root = loader.load();
            Stage stageAgregarGeneros = new Stage();
            stageAgregarGeneros.setScene(new Scene(root, 600, 400));
            AgregarGeneros controllerAgregarGeneros = loader.getController();
            controllerAgregarGeneros.initialize(adminUser);
            stageAgregarGeneros.show();

            ( (Stage) ( ( (Button)actionEvent.getSource() ).getScene().getWindow() ) ).close();

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    public void modificar(ActionEvent actionEvent){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModificarGeneros.fxml"));
            Parent root = loader.load();
            Stage stageModificarGeneros = new Stage();
            stageModificarGeneros.setScene(new Scene(root, 600, 400));
            ModificarGeneros controllerModificarGeneros = loader.getController();
            controllerModificarGeneros.initialize(adminUser);
            stageModificarGeneros.show();

            ( (Stage) ( ( (Button)actionEvent.getSource() ).getScene().getWindow() ) ).close();

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    public void eliminar(ActionEvent actionEvent){
//        try{
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("EliminarProductosAdmin.fxml"));
//            Parent root = loader.load();
//            Stage stageEliminarProductosAdmin = new Stage();
//            stageEliminarProductosAdmin.setScene(new Scene(root, 600, 400));
//            EliminarProductosAdmin controllerEliminarProductosAdmin = loader.getController();
//            controllerEliminarProductosAdmin.initialize(adminUser);
//            stageEliminarProductosAdmin.show();
//
//            ( (Stage) ( ( (Button)actionEvent.getSource() ).getScene().getWindow() ) ).close();
//
//        } catch (Exception e){
//            e.printStackTrace();
//            e.getCause();
//        }
    }


    @FXML
    public void regresar(ActionEvent actionEvent){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InicioAdmin.fxml"));
            Parent root = loader.load();
            Stage stageInicioAdmin = new Stage();
            stageInicioAdmin.setScene(new Scene(root, 600, 400));
            InicioAdmin controllerInicioAdmin = loader.getController();
            controllerInicioAdmin.initialize(adminUser);
            stageInicioAdmin.show();

            ( (Stage) ( ( (Button)actionEvent.getSource() ).getScene().getWindow() ) ).close();

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}
