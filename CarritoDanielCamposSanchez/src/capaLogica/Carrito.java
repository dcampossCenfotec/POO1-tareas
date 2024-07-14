package capaLogica;

import java.util.ArrayList;

public class Carrito {

    private ArrayList<ProductoComprado> productosCompados;
    private int total;

    public ArrayList<ProductoComprado> getProductosCompados() {
        return productosCompados;
    }

    public void setProductosCompados(ArrayList<ProductoComprado> productosCompados) {
        this.productosCompados = productosCompados;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Carrito(ArrayList<ProductoComprado> productosCompados, int total) {
        this.productosCompados = productosCompados;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Carrito {" + '\n' +
                "   productosCompados=" + productosCompados.toString() + '\n' +
                "   total=" + total + '\n' +
                '}';
    }
}
