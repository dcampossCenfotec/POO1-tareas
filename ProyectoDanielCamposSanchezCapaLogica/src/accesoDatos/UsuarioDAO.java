package AccesoDatos;

import capaLogica.Configuracion;
import capaLogica.Usuario;

import java.sql.*;
import java.util.ArrayList;

public class UsuarioDAO {

    public void insertarUsuario(Usuario usuario){
        try{
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            String query = "INSERT INTO Usuario (Nombre,Password,EsAdministrador) VALUES(?,?,?,)";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,usuario.getNombre());
            stmt.setString(2,usuario.getPassword());
            stmt.setBoolean(3, usuario.isEsAdministrador());
            stmt.execute();
        }
        catch (SQLException e){
            e.printStackTrace();

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public ArrayList<Usuario> listarUsuarios() {
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
        try {
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            String query = "SELECT * FROM DBO.Usuario";
            Statement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);// el rs almacena la información de la base de datos.

            while (rs.next()) { //rs.next devuelve true si hay más líneas en el result set. por defecto, al iniciar el ciclo, el rs está en la línea 0.
                Usuario usuario = new Usuario();
                usuario.setPK_ID_Usuario(rs.getInt("PK_ID_Usuario"));
                usuario.setNombre (rs.getString("Nombre"));
                usuario.setPassword(rs.getString("Password"));
                usuario.setEsAdministrador(rs.getBoolean("EsAdministrador"));
                listaUsuarios.add(usuario);
            }
            conn.close();
        }
        catch (SQLException e){
            e.printStackTrace();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return listaUsuarios;
    }

    public Usuario listarUsuarioPorID(Usuario tmpUsuario) {
        Usuario usuario = new Usuario();
        try {
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            String query = "SELECT * FROM DBO.Usuario WHERE PK_ID_Usuario = ?";
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, tmpUsuario.getPK_ID_Usuario());
            rs = stmt.executeQuery(query);// el rs almacena la información de la base de datos.

            while (rs.next()) { //rs.next devuelve true si hay más líneas en el result set. por defecto, al iniciar el ciclo, el rs está en la línea 0.
                usuario.setPK_ID_Usuario(rs.getInt("PK_ID_Usuario"));
                usuario.setNombre (rs.getString("Nombre"));
                usuario.setPassword(rs.getString("Password"));
                usuario.setEsAdministrador(rs.getBoolean("EsAdministrador"));
            }
            conn.close();
        }
        catch (SQLException e){
            e.printStackTrace();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return usuario;
    }

    public Usuario listarUsuarioPorIdYPassword(Usuario tmpUsuario){
        Usuario usuario = new Usuario();
        try {
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            String query = "SELECT * FROM DBO.Usuario WHERE PK_ID_Usuario = ? AND Password = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, tmpUsuario.getPK_ID_Usuario());
            stmt.setString(2, tmpUsuario.getPassword());
            rs = stmt.executeQuery();

            while (rs.next()) { //rs.next devuelve true si hay más líneas en el result set. por defecto, al iniciar el ciclo, el rs está en la línea 0.
                usuario.setPK_ID_Usuario(rs.getInt("PK_ID_Usuario"));
                usuario.setNombre(rs.getString("Nombre"));
                usuario.setPassword(rs.getString("Password"));
                usuario.setEsAdministrador(rs.getBoolean("EsAdministrador"));
            }
            conn.close();
        }
        catch (SQLException e){
            e.printStackTrace();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return usuario;

    }

    public void actualizarUsuario(Usuario tmpUsuario){
        try{
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            String query = "UPDATE Usuario SET Nombre = ?, Password = ?, EsAdministrador = ? WHERE PK_ID_Usuario = ?";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,tmpUsuario.getNombre());
            stmt.setString(2, tmpUsuario.getPassword());
            stmt.setBoolean(3,tmpUsuario.isEsAdministrador());
            stmt.setInt(4,tmpUsuario.getPK_ID_Usuario());
            stmt.execute();
        }
        catch (SQLException e){
            e.printStackTrace();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void eliminarUsuario(Usuario tmpUsuario){
        try{
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            String query = "DELETE FROM Usuario WHERE PK_ID_Usuario = ?";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setInt(1,tmpUsuario.getPK_ID_Usuario());
            stmt.execute();
        }
        catch (SQLException e){
            e.printStackTrace();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
