package utils;

public class ArtistaTable {
    public int PK_ID_Artista;
    public String Nombre;
    public boolean esCompositor;
    public String Genero;

    public int getPK_ID_Artista() {
        return PK_ID_Artista;
    }

    public void setPK_ID_Artista(int PK_ID_Artista) {
        this.PK_ID_Artista = PK_ID_Artista;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public boolean isEsCompositor() {
        return esCompositor;
    }

    public void setEsCompositor(boolean esCompositor) {
        this.esCompositor = esCompositor;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public ArtistaTable(int PK_ID_Artista, String nombre, boolean esCompositor, String genero) {
        this.PK_ID_Artista = PK_ID_Artista;
        Nombre = nombre;
        this.esCompositor = esCompositor;
        Genero = genero;
    }
}
