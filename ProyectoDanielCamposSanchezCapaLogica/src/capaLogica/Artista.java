package capaLogica;

import java.util.ArrayList;
import java.util.Objects;

public class Artista {
    public String codigo;
    public String nombre;
    public ArrayList<Genero> generos;

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

    public ArrayList<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(ArrayList<Genero> generos) {
        this.generos = generos;
    }

    public Artista() {
    }

    public Artista(String codigo, String nombre, ArrayList<Genero> generos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.generos = generos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artista artista = (Artista) o;
        return Objects.equals(getCodigo(), artista.getCodigo()) && Objects.equals(getNombre(), artista.getNombre()) && Objects.equals(getGeneros(), artista.getGeneros());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigo(), getNombre(), getGeneros());
    }

    @Override
    public String toString() {
        return "Artista{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", generos=" + generos +
                '}';
    }
}
