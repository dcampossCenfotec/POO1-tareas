package capaLogica;

public class ProductoComprado {

    private Producto producto;
    private int cantidad;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public ProductoComprado(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "ProductoComprado {" + '\n' +
                "   producto=" + producto.toStringDouble() + '\n' +
                "   cantidad=" + cantidad + '\n' +
                "   }";
    }
}
