package capaLogica;

import java.util.Objects;

public class Genero {
    public String codigo;
    public String nombre;

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

    public Genero() {
    }

    public Genero(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genero genero = (Genero) o;
        return Objects.equals(getCodigo(), genero.getCodigo()) && Objects.equals(getNombre(), genero.getNombre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigo(), getNombre());
    }

    @Override
    public String toString() {
        return "Genero{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
