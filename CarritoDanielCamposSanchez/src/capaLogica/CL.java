package capaLogica;

import java.util.ArrayList;
import java.util.Objects;

import static java.lang.System.out;

public class CL {
    ArrayList<Producto> productos = new ArrayList<Producto>();
    ArrayList<ProductoComprado> productosComprados = new ArrayList<ProductoComprado>();
    Carrito carrito = new Carrito(productosComprados, 0);

    public boolean existeProducto(Producto producto) {
        if (productos.isEmpty()) {
            return false;
        } else
        {
            for (Producto p : productos)
            {
                return p.getCodigo().equals(producto.getCodigo());
            }
        }
        return false;
    }

    public void registrarProducto(Producto producto)
    {
        if (!existeProducto(producto)){
            productos.add(producto);
            out.println("Producto registrado exitosamente: " + producto.toString());
        }else{
            out.println("Producto con codigo "+producto.getCodigo()+" ya existe");
        }
    }

    public void verProductos(){
        for (Producto p : productos){
            out.println(p.toString());
        }
    }

    public void registrarProductosComprados(Producto producto, int cantidad){
        productosComprados.add(new ProductoComprado(producto, cantidad));
    }

    public Producto obtenerProductoPorCodigo(String codigo)
    {
        Producto producto=null;
        for (Producto value : productos) {
            if (Objects.equals(value.getCodigo(), codigo)) {
                producto = value;
                break;
            }
        }
        return producto;
    }

    public void imprimirTodosLosProductos(){
        for (Producto p : productos) {
            out.println(p.toString());
        }
    }

    public void imprimirCarrito(){
        if (!productosComprados.isEmpty()) {
            int total = 0;
            for (ProductoComprado productoComprado : productosComprados) {
                total = total + (productoComprado.getCantidad() * productoComprado.getProducto().getPrecio());
            }
            carrito.setProductosCompados(productosComprados);
            carrito.setTotal(total);
            out.println("----Carrito----");
            out.println(carrito.toString());
        } else {
            out.println("Debe comprar productos para ver el carrito");
        }
    }
}
