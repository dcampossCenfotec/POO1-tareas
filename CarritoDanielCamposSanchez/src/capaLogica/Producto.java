package capaLogica;

import java.util.Objects;

public class Producto {
    private String codigo;
    private String nombre;
    private String descripcion;
    private int precio;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Producto(String codigo, String nombre, String descripcion, int precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String toStringDouble() {
        return "Producto {" + '\n' +
                "       codigo='" + codigo + '\n' +
                "       nombre='" + nombre + '\n' +
                "       descripcion='" + descripcion + '\n' +
                "       precio=" + precio + '\n' +
                "   }";
    }

    @Override
    public String toString() {
        return "Producto {" + '\n' +
                "   codigo='" + codigo + '\n' + "'" +
                "   nombre='" + nombre + '\n' + "'" +
                "   descripcion='" + descripcion + '\n' + "'" +
                "   precio=" + precio + '\n' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return getPrecio() == producto.getPrecio() && Objects.equals(getCodigo(), producto.getCodigo()) && Objects.equals(getNombre(), producto.getNombre()) && Objects.equals(getDescripcion(), producto.getDescripcion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigo(), getNombre(), getDescripcion(), getPrecio());
    }
}
