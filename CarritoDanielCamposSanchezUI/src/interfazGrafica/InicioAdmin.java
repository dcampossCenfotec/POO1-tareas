package interfazGrafica;

import capaLogica.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Inicio {

    public Label txtNombreUsuario;
    public Text total;
    CL cl;
    public ObservableList<Producto> productos = FXCollections.observableArrayList();
    @FXML
    private TableView<Producto> tblProductosRegistrados;
    @FXML
    private TableColumn<Producto, String> colCodigo;
    @FXML
    private TableColumn<Producto, String> colNombre;
    @FXML
    private TableColumn<Producto, String> colDescripcion;
    @FXML
    private TableColumn<Producto, Integer> colPrecio;

    public ObservableList<ProductoComprado> productosComprados = FXCollections.observableArrayList();;
    public TableView<ProductoComprado> tblCarrito;
    public TableColumn<ProductoComprado, String> colProductoCompradoCodigo;
    public TableColumn<ProductoComprado, String> colProductoCompradoNombre;
    public TableColumn<ProductoComprado, String> colProductoCompradoDescripcion;
    public TableColumn<ProductoComprado, String> colProductoCompradoPrecio;
    public TableColumn<ProductoComprado, String> colProductoCompradoCantidad;

    public void salir(ActionEvent actionEvent) {
        ( (Stage) ( ( (Button)actionEvent.getSource() ).getScene().getWindow() ) ).close();
        System.exit(0);
    }
    @FXML
    public void initialize(CL cl) throws IOException {
        this.cl = cl;
        txtNombreUsuario.setText("Hola, " + cl.getUsuarioEnSesion().getNombre());
        if (cl.imprimirCarrito() != null){
            total.setText(String.valueOf(cl.imprimirCarrito().getTotal()));
        } else {
            total.setText("0");
        }

        ArrayList<Producto> productosDesdeCL = cl.verProductos();
        if(!productosDesdeCL.isEmpty()){
            for(Producto producto: productosDesdeCL){
                productos.add(producto);
                tblProductosRegistrados.setItems(productos);
                colCodigo.setCellValueFactory(new PropertyValueFactory<Producto, String>("codigo"));
                colDescripcion.setCellValueFactory(new PropertyValueFactory<Producto, String>("descripcion"));
                colNombre.setCellValueFactory(new PropertyValueFactory<Producto, String>("nombre"));
                colPrecio.setCellValueFactory(new PropertyValueFactory<Producto, Integer>("precio"));
            }
        }
       Carrito carrito = cl.imprimirCarrito();
        if (carrito != null){
            ArrayList<ProductoComprado> productosCompradosDesdeCL = carrito.getProductosCompados();
            if (!productosCompradosDesdeCL.isEmpty()) {
                for (ProductoComprado productoComprado : productosCompradosDesdeCL) {
                    productosComprados.add(productoComprado);
                    tblCarrito.setItems(productosComprados);

                    colProductoCompradoCodigo.setCellValueFactory(data -> {
                        ProductoComprado productoCompradoValue = data.getValue();
                        Producto producto = productoCompradoValue.getProducto();
                        String codigo = producto.getCodigo();
                        return new SimpleStringProperty(codigo);
                    });

                    colProductoCompradoNombre.setCellValueFactory(data -> {
                        ProductoComprado productoCompradoValue = data.getValue();
                        Producto producto = productoCompradoValue.getProducto();
                        String nombre = producto.getNombre();
                        return new SimpleStringProperty(nombre);
                    });

                    colProductoCompradoPrecio.setCellValueFactory(data -> {
                        ProductoComprado productoCompradoValue = data.getValue();
                        Producto producto = productoCompradoValue.getProducto();
                        Integer precio = producto.getPrecio();
                        return new SimpleStringProperty(precio.toString());
                    });
                    colProductoCompradoDescripcion.setCellValueFactory(data -> {
                        ProductoComprado productoCompradoValue = data.getValue();
                        Producto producto = productoCompradoValue.getProducto();
                        String descripcion = producto.getDescripcion();
                        return new SimpleStringProperty(descripcion);
                    });
                    colProductoCompradoCantidad.setCellValueFactory(new PropertyValueFactory<ProductoComprado, String>("cantidad"));
                }
            }
        }


    }
    @FXML
    public void mostrarRegistrarProductosUI(ActionEvent actionEvent) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RegistrarProductos.fxml"));
            Parent root = loader.load();
            Stage stageRegistrarProductos = new Stage();
            stageRegistrarProductos.setScene(new Scene(root, 869, 685));
            RegistrarProductos controllerRegistrarProductos = loader.getController();
            controllerRegistrarProductos.initialize(cl);

            stageRegistrarProductos.show();
            ( (Stage) ( ( (Button)actionEvent.getSource() ).getScene().getWindow() ) ).close();
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    public void mostrarComprarProductosUI(ActionEvent actionEvent) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ComprarProductos.fxml"));
            Parent root = loader.load();
            Stage stageComprarProductos = new Stage();
            stageComprarProductos.setScene(new Scene(root, 869, 685));
            ComprarProductos controllerComprarProductos = loader.getController();
            controllerComprarProductos.initialize(cl);

            stageComprarProductos.show();
            ( (Stage) ( ( (Button)actionEvent.getSource() ).getScene().getWindow() ) ).close();
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

}
