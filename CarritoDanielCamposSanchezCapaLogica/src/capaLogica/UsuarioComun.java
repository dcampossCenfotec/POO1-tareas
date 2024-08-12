package capaLogica;

public class UsuarioAdministrador extends Usuario{
    public UsuarioAdministrador() {
    }

    public UsuarioAdministrador(Integer idUsuario, String codigo, String nombre, String password, Boolean enSesion) {
        super(idUsuario, codigo, nombre, password, enSesion);
    }

    public UsuarioAdministrador(String codigo, String nombre, String password, Boolean enSesion) {
        super(codigo, nombre, password, enSesion);
    }
}
