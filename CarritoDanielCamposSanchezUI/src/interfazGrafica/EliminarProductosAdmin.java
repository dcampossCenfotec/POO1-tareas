package interfazGrafica;

import capaLogica.CL;
import capaLogica.Producto;
import capaLogica.UsuarioAdministrador;
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

public class EliminarProductosAdmin {
    CL cl = new CL();
    UsuarioAdministrador adminUser = new UsuarioAdministrador();
    public ObservableList<Producto> productosOL = FXCollections.observableArrayList();

    public TableView<Producto> tblProductos;
    public TableColumn<Producto, Integer> colId;
    public TableColumn<Producto, String> colNombre;
    public TableColumn<Producto, String> colDescripcion;
    public TableColumn<Producto, Integer> colPrecio;

    public TextField txtId;
    public Label lblInfo;

    @FXML
    public void initialize(UsuarioAdministrador admin){
        this.adminUser = admin;
        ArrayList<Producto> productosFromDB = cl.listarProductos();

        if(!productosFromDB.isEmpty()){
            for(Producto tmpProducto : productosFromDB){
                productosOL.add(tmpProducto);
                tblProductos.setItems(productosOL);

                colId.setCellValueFactory(new PropertyValueFactory<Producto, Integer>("ID"));
                colNombre.setCellValueFactory(new PropertyValueFactory<Producto, String>("nombre"));
                colDescripcion.setCellValueFactory(new PropertyValueFactory<Producto, String>("descripcion"));
                colPrecio.setCellValueFactory(new PropertyValueFactory<Producto, Integer>("precio"));
            }
        }
    }

    @FXML
    public void eliminar(){
        Producto producto = new Producto();
        producto.setID(Integer.parseInt(txtId.getText()));
        if (cl.eliminarProducto(producto)){
            lblInfo.setText("Eliminacion exitosa");
            lblInfo.setTextFill(Color.GREEN);
        }else{
            lblInfo.setText("Producto no se pudo eliminado");
            lblInfo.setTextFill(Color.RED);
        }
    }

    @FXML
    public void regresar(ActionEvent actionEvent){
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
