package capaLogica;

import java.util.ArrayList;
import java.util.Objects;

import static java.lang.System.out;

public class CL {
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    ArrayList<Genero> generos = new ArrayList<Genero>();
    ArrayList<Compositor> compositores = new ArrayList<Compositor>();
    ArrayList<Artista> artistas = new ArrayList<Artista>();

    public Administrador inicarSesionAdministradores(String codigo, String contrasena){
        ArrayList<Administrador> admins = listarAdministradores();
        Administrador admin = null;
        for (Administrador administrador : admins) {
            if (administrador.getCodigo().equals(codigo) && administrador.getContrasena().equals(contrasena)) {
               admin = administrador;
            }
        }
        return admin;
    }

    public ArrayList<Administrador> listarAdministradores() {
        ArrayList<Administrador> administradores = new ArrayList<>();
        for(Usuario usuario : usuarios)
        {
            if(usuario instanceof Administrador)
            {
                administradores.add((Administrador) usuario);
            }
        }
        return administradores;
    }


    public boolean existeAdministrador(Administrador administrador) {
        ArrayList<Administrador> administradores = this.listarAdministradores();
        boolean existe = false;
        if (administradores!=null) {
            for (Administrador admin : administradores) {
                if (admin.getCodigo().equals(administrador.getCodigo())) {
                    existe = true;
                }
            }
        }
        return existe;
    }

    public boolean registrarAdministrador(Administrador administrador)
    {
        if (!existeAdministrador(administrador)){
            usuarios.add(administrador);
            return false;
        }else{
            return true;
        }
    }

    public ArrayList<Genero> listarGeneros() {
        return generos;
    }

    public boolean existeGenero(Genero genero) {
        boolean existe = false;
        if (generos.isEmpty()){
            existe = false;
        }
        for (Genero generoEnCiclo : generos) {
            if (generoEnCiclo.getCodigo().equals(genero.getCodigo())) {
                existe = true;
            }
        }
        return existe;
    }

    public boolean registrarGenero(Genero genero) {
        if (!existeGenero(genero)){
            generos.add(genero);
            return false;
        }else{
            return true;
        }
    }

    public Genero buscarGeneroPorId(String codigoDelGenero) {
        Genero genero = new Genero();
        for (Genero generoGlobal : generos) {
            if (generoGlobal.getCodigo().equals(codigoDelGenero)) {
                genero = generoGlobal;
            }
        }
        return genero;
    }

    public boolean existeCompositor(Compositor compositor) {
        boolean existe = false;
        if (compositores.isEmpty()){
            existe = false;
        }
        for (Compositor compositorEnCiclo : compositores) {
            if (compositorEnCiclo.getCodigo().equals(compositor.getCodigo())) {
                existe = true;
            }
        }
        return existe;
    }

    public boolean registrarCompositor(Compositor compositor) {
        if (!existeCompositor(compositor)){
            compositores.add(compositor);
            return false;
        }else{
            return true;
        }
    }

    public ArrayList<Compositor> listarCompositores() {
        return compositores;
    }

    public boolean existeArtista(Artista artista) {
        boolean existe = false;
        if (artistas.isEmpty()){
            existe = false;
        }
        for (Artista artistaEnCiclo : artistas) {
            if (artistaEnCiclo.getCodigo().equals(artista.getCodigo())) {
                existe = true;
            }
        }
        return existe;
    }

    public boolean registrarArtista(Artista artista) {
        if (!existeArtista(artista)){
            artistas.add(artista);
            return false;
        }else{
            return true;
        }
    }

    public ArrayList<Artista> listarArtistas() {
        return artistas;
    }

    public boolean modificarGenero(Genero genero) {
        if (existeGenero(genero)){
            for (Genero generoEnCiclo: generos){
                if (generoEnCiclo.getCodigo().equals(genero.getCodigo())){
                    generoEnCiclo.setNombre(genero.getNombre());
                }
            }
            return true;
        }else{
            return false;
        }
    }

    public boolean modificarCompositor(Compositor compositor) {
        if (existeCompositor(compositor)){
            for (Compositor compositorEnCiclo: compositores){
                if (compositorEnCiclo.getCodigo().equals(compositor.getCodigo())){
                    compositorEnCiclo.setNombre(compositor.getNombre());
                    compositorEnCiclo.setGeneros(compositor.getGeneros());
                }
            }
            return true;
        }else{
            return false;
        }
    }

    public boolean modificarArtista(Artista artista) {
        if (existeArtista(artista)){
            for (Artista artistaEnCiclo: artistas){
                if (artistaEnCiclo.getCodigo().equals(artista.getCodigo())){
                    artistaEnCiclo.setNombre(artista.getNombre());
                    artistaEnCiclo.setGeneros(artista.getGeneros());
                }
            }
            return true;
        }else{
            return false;
        }
    }

    public boolean eliminarGenero(String codigo)
    {
        boolean eliminado=false;
        for(Genero genero : generos)
        {
            if(genero.getCodigo().equals(codigo))
            {
                generos.remove(genero);
                eliminado=true;
                break;
            }
        }
        return eliminado;
    }

    public boolean eliminarCompositor(String codigo)
    {
        boolean eliminado=false;
        for(Compositor compositor : compositores)
        {
            if(compositor.getCodigo().equals(codigo))
            {
                compositores.remove(compositor);
                eliminado=true;
                break;
            }
        }
        return eliminado;
    }

    public boolean eliminarArtista(String codigo)
    {
        boolean eliminado=false;
        for(Artista artista : artistas)
        {
            if(artista.getCodigo().equals(codigo))
            {
                artistas.remove(artista);
                eliminado=true;
                break;
            }
        }
        return eliminado;
    }
}
