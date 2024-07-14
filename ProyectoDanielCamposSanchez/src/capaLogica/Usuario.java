package capaLogica;

import java.util.Objects;

public class Usuario {
    public String codigo;
    public String nombre;
    public String contrasena;

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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Usuario() {
    }

    public Usuario(String codigo, String nombre, String contrasena) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(getCodigo(), usuario.getCodigo()) && Objects.equals(getNombre(), usuario.getNombre()) && Objects.equals(getContrasena(), usuario.getContrasena());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigo(), getNombre(), getContrasena());
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }
}
