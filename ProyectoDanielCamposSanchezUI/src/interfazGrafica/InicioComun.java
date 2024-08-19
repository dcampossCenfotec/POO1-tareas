package interfazGrafica;

import capaLogica.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import utils.CarritoTable;

import java.io.IOException;
import java.util.ArrayList;

public class InicioComun {
    CL cl = new CL();
    Carrito carrito = new Carrito();
    public Label txtNombreUsuario;
    public Label lblTotal;
    UsuarioComun comunUser = new UsuarioComun();
    public ObservableList<CarritoTable> carritoTableOL = FXCollections.observableArrayList();
    public ArrayList<ProductoComprado> productoComprados = new ArrayList<ProductoComprado>();
    public ArrayList<Producto> productos = new ArrayList<Producto>();

    public TableView<CarritoTable> tblCarrito;
    public TableColumn<CarritoTable, Integer> colProductoCompradoId;
    public TableColumn<CarritoTable, String> colProductoCompradoNombre;
    public TableColumn<CarritoTable, String> colProductoCompradoDescripcion;
    public TableColumn<CarritoTable, Integer> colProductoCompradoPrecio;
    public TableColumn<CarritoTable, Integer> colProductoCompradoCantidad;

    @FXML
    public void initialize(UsuarioComun comun) throws IOException {
        this.comunUser = comun;
        for (Carrito tempCarrito: cl.listarCarritos()){
            if (tempCarrito.getIdUsuarioComun() == comun.getIdUsuario()){
                this.carrito = tempCarrito;
            }
        }
        txtNombreUsuario.setText("Hola, "+ comun.getNombre());
        lblTotal.setText("Total: " + carrito.getTotal());

        //For para obtener productos por usuario
        for (ProductoComprado tempProductoComprado: cl.listarProductosComprados()){
            if (tempProductoComprado.getIdCarrito() == carrito.getID()){
                productoComprados.add(tempProductoComprado);
            }
        }

        //For para obtener info de productos comprados
        for (ProductoComprado tempProductoComprado: productoComprados){
            for (Producto producto: cl.listarProductos()){
                if (tempProductoComprado.getIdProducto() == producto.getID()){
                    productos.add(producto);
                    CarritoTable tempCarrito = new CarritoTable(producto.getID(), producto.getNombre(), producto.getDescripcion(), producto.getPrecio(), tempProductoComprado.getCantidad());
                    carritoTableOL.add(tempCarrito);
                    tblCarrito.setItems(carritoTableOL);
                    colProductoCompradoId.setCellValueFactory(new PropertyValueFactory<CarritoTable, Integer>("id"));
                    colProductoCompradoNombre.setCellValueFactory(new PropertyValueFactory<CarritoTable, String>("nombre"));
                    colProductoCompradoDescripcion.setCellValueFactory(new PropertyValueFactory<CarritoTable, String>("descripcion"));
                    colProductoCompradoPrecio.setCellValueFactory(new PropertyValueFactory<CarritoTable, Integer>("precio"));
                    colProductoCompradoCantidad.setCellValueFactory(new PropertyValueFactory<CarritoTable, Integer>("cantidad"));
                }
            }

        }

    }

    public void salir(ActionEvent actionEvent) {
        ( (Stage) ( ( (Button)actionEvent.getSource() ).getScene().getWindow() ) ).close();
        System.exit(0);
    }

    public void comprar(ActionEvent actionEvent) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ComprarProductos.fxml"));
            Parent root = loader.load();
            Stage stageComprarProductos = new Stage();
            stageComprarProductos.setScene(new Scene(root, 600, 400));
            ComprarProductos controllerComprarProductos = loader.getController();
            controllerComprarProductos.initialize(comunUser);
            stageComprarProductos.show();

            ( (Stage) ( ( (Button)actionEvent.getSource() ).getScene().getWindow() ) ).close();

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}
