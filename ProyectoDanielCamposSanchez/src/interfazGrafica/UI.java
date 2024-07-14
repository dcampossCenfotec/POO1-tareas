package interfazGrafica;

import capaLogica.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class UI {

    static PrintStream out = System.out;
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static CL cl = new CL();

    public static void main(String[] args) throws IOException {
        int opcion = 0;
        do {
            mostrarMenuInicial();
            opcion = seleccionarOpcion();
            procesarOpcion(opcion);
        } while (opcion != 0);
    }
    public static void mostrarAccionesAdministrador() {
        out.println("1. Registrar");
        out.println("2. Buscar");
        out.println("3. Listar");
        out.println("4. Modificar");
        out.println("5. Eliminar");
        out.println("0. Volver");
    }

    public static void mostrarMenuInicial() {
        out.println("1. Iniciar Sesion");
        out.println("2. Registrar Usuarios");
        out.println("0. Salir");
    }
    public static void mostrarMenuUsuarios() {
        out.println("1. Administrador");
        out.println("2. Ordinario");
        out.println("0. Regresar");
    }
    public static void menuAdministradores(Administrador administrador) {
        out.println("Hola, " + administrador.getNombre() + ". Seleccione lo que desee administrar");
        out.println("1. Generos");
        out.println("2. Compositores");
        out.println("3. Artistas");
        out.println("0. Cerrar Sesion");
    }

    public static int seleccionarOpcion() throws IOException {
        int opcion = 0;
        out.println("Digite la opción a ejecutar");
        opcion = Integer.parseInt(in.readLine());
        return opcion;
    }

    public static void iniciarSesion() throws IOException {
        int opcion = 0;
        do {
            mostrarMenuUsuarios();
            opcion = seleccionarOpcion();
            procesarIniciarSesionUsuarios(opcion);
        } while (opcion != 0);
    }

    public static void mostrarMenuAccionesAdministrador(ClasesDeAdministrador clase) throws IOException {
        int opcion = 0;
        do {
            mostrarAccionesAdministrador();
            opcion = seleccionarOpcion();
            procesarAccionesAdministrador(opcion, clase);
        } while (opcion != 0);
    }

    public static void procesarAccionesAdministrador(int opcion, ClasesDeAdministrador clase) throws IOException {
        switch (opcion) {
            case 1:
                if (clase.equals(ClasesDeAdministrador.GENERO)) {
                    registrarGenero();
                } else if (clase.equals(ClasesDeAdministrador.COMPOSITOR)) {
                    registrarCompositor();
                } else if (clase.equals(ClasesDeAdministrador.ARTISTA)) {
                    registrarArtista();
                }
                break;
            case 2:
                if (clase.equals(ClasesDeAdministrador.GENERO)) {
                    buscarGenero();
                } else if (clase.equals(ClasesDeAdministrador.COMPOSITOR)) {
                    buscarCompositor();
                } else if (clase.equals(ClasesDeAdministrador.ARTISTA)) {
                    buscarArtista();
                }
                break;
            case 3:
                if (clase.equals(ClasesDeAdministrador.GENERO)) {
                    listarGenero();
                } else if (clase.equals(ClasesDeAdministrador.COMPOSITOR)) {
                    listarCopositor();
                } else if (clase.equals(ClasesDeAdministrador.ARTISTA)) {
                    listarArtista();
                }
                break;
            case 4:
                if (clase.equals(ClasesDeAdministrador.GENERO)) {
                    modificarGenero();
                } else if (clase.equals(ClasesDeAdministrador.COMPOSITOR)) {
                    modificarCompositor();
                } else if (clase.equals(ClasesDeAdministrador.ARTISTA)) {
                    modificarArtista();
                }
                break;
            case 5:
                if (clase.equals(ClasesDeAdministrador.GENERO)) {
                    eliminarGenero();
                } else if (clase.equals(ClasesDeAdministrador.COMPOSITOR)) {
                    eliminarCompositores();
                } else if (clase.equals(ClasesDeAdministrador.ARTISTA)) {
                    eliminarArtistas();
                }
                break;
            case 0:
                break;
            default:
                out.println("Opción inválida");
                break;
        }
    }

    public static void procesarIniciarSesionUsuarios(int opcion) throws IOException {
        switch (opcion) {
            case 1:
                iniciarSesionAdministrador();
                break;
            case 2:
                //iniciarSesionOrdinario();
                break;
            case 0:
                break;
            default:
                out.println("Opción inválida");
                break;
        }
    }

    public static void procesarOpcion(int opcion) throws IOException {
        switch (opcion) {
            case 1:
                iniciarSesion();
                break;
            case 2:
                RegistrarUsuario();
                break;
            case 0:
                break;
            default:
                out.println("Opción inválida");
                break;
        }
    }

    public static void procesarOpcionUsuarios(int opcion) throws IOException {
        switch (opcion) {
            case 1:
                RegistrarAdministrador();
                break;
            case 2:
                //RegistrarOridinario();
                break;
            case 0:
                break;
            default:
                out.println("Opción inválida");
                break;
        }
    }

    public static void procesarOpcionAdministradores(int opcion) throws IOException {
        switch (opcion) {
            case 1:
                mostrarMenuAccionesAdministrador(ClasesDeAdministrador.GENERO);
                break;
            case 2:
                mostrarMenuAccionesAdministrador(ClasesDeAdministrador.COMPOSITOR);
                break;
            case 3:
                mostrarMenuAccionesAdministrador(ClasesDeAdministrador.ARTISTA);
                break;
            case 0:
                break;
            default:
                out.println("Opción inválida");
                break;
        }
    }

    public static void RegistrarUsuario() throws IOException {
        int opcion = 0;
        do {
            mostrarMenuUsuarios();
            opcion = seleccionarOpcion();
            procesarOpcionUsuarios(opcion);
        } while (opcion != 0);
    }
    public static void mostrarMenuAdministradores(Administrador administrador) throws IOException {
        int opcion = 0;
        do {
            menuAdministradores(administrador);
            opcion = seleccionarOpcion();
            procesarOpcionAdministradores(opcion);
        } while (opcion != 0);
    }

    public static void RegistrarAdministrador() throws IOException {
        out.println("***Ingresar la información del Administrador***");
        out.println("Ingresar el codigo del administrador");
        String codigo = in.readLine();
        out.println("Ingresar el nombre del administrador");
        String nombre = in.readLine();
        out.println("Ingresar la contrasena del administrador");
        String descripcion = in.readLine();
        Administrador administrador = new Administrador(codigo, nombre, descripcion);
        boolean existeAdministrador = cl.registrarAdministrador(administrador);
        if (existeAdministrador) {
            out.println("El administrador con codigo " + administrador.getCodigo() + " ya existe");
        } else {
            out.println("Administrador " + administrador.getNombre() + " registrado");
        }
    }

    public static void iniciarSesionAdministrador() throws IOException {
        out.println("***Inicio de Sesion***");
        out.println("Digite el codigo del usuario");
        String codigo = in.readLine();
        out.println("Digite la contrasena del usuario");
        String contrasena = in.readLine();
        Administrador administrador = cl.inicarSesionAdministradores(codigo, contrasena);
        if (administrador != null) {
            mostrarMenuAdministradores(administrador);
        }else {
            out.println("Codigo o contrasena incorrecta o el Administrador no existe");
        }
    }

    public static void registrarGenero() throws IOException{
        out.println("***Registro de Genero***");
        out.println("Digite el codigo del genero");
        String codigo = in.readLine();
        out.println("Digite el nombre del genero");
        String nombre = in.readLine();
        Genero genero = new Genero(codigo, nombre);
        boolean existeGenero = cl.registrarGenero(genero);
        if (existeGenero){
            out.println("El genero con codigo " + genero.getCodigo() + " ya existe");
        }else {
            out.println("Genero " + genero.getNombre() + " registrado");
        }
    }

    public static void registrarCompositor() throws IOException{
        ArrayList<Genero> generos = cl.listarGeneros();
        ArrayList<Genero> generosAgregados = new ArrayList<Genero>();
        if (!generos.isEmpty()){
            out.println("***Generos Registrados***");
            for (Genero genero : generos){
                out.println(genero.toString());
            }
            out.println("***Registro de Compositor***");
            out.println("Digite el codigo del compositor");
            String codigo = in.readLine();
            out.println("Digite el nombre del compositor");
            String nombre = in.readLine();
            boolean digitaGenero = true;
            do {
                out.println("Digite el codigo del genero que quiere agregar al compositor");
                String codigoGenero = in.readLine();
                Genero generoPorId = cl.buscarGeneroPorId(codigoGenero);
                generosAgregados.add(generoPorId);
                out.println("Genero agregado: " + generoPorId);
                out.println("------------------------------");
                out.println("Quiere otro genero al compositor? S/N");
                if(!in.readLine().toUpperCase().equals("S"))
                    digitaGenero = false;
            } while (digitaGenero);
            Compositor compositor = new Compositor(codigo, nombre, generosAgregados);
            boolean existeCompositor = cl.registrarCompositor(compositor);
            if (existeCompositor){
                out.println("El compositor con codigo " + compositor.getCodigo() + " ya existe");
            }else {
                out.println("Compositor " + compositor.getNombre() + " registrado");
                out.println(compositor.toString());
            }
        }else{
            out.println("Necesita tener minimo un genero registrado");
        }
    }

    public static void registrarArtista() throws IOException{
        ArrayList<Genero> generos = cl.listarGeneros();
        ArrayList<Genero> generosAgregados = new ArrayList<Genero>();
        if (!generos.isEmpty()){
            out.println("***Generos Registrados***");
            for (Genero genero : generos){
                out.println(genero.toString());
            }
            out.println("***Registro de Artista***");
            out.println("Digite el codigo del artista");
            String codigo = in.readLine();
            out.println("Digite el nombre del artista");
            String nombre = in.readLine();
            boolean digitaGenero = true;
            do {
                out.println("Digite el codigo del genero que quiere agregar al artista");
                String codigoGenero = in.readLine();
                Genero generoPorId = cl.buscarGeneroPorId(codigoGenero);
                generosAgregados.add(generoPorId);
                out.println("Genero agregado: " + generoPorId);
                out.println("------------------------------");
                out.println("Quiere otro genero al artista? S/N");
                if(!in.readLine().toUpperCase().equals("S"))
                    digitaGenero = false;
            } while (digitaGenero);
            Artista artista = new Artista(codigo, nombre, generosAgregados);
            boolean existeArtista = cl.registrarArtista(artista);
            if (existeArtista){
                out.println("El compositor con codigo " + artista.getCodigo() + " ya existe");
            }else {
                out.println("Compositor " + artista.getNombre() + " registrado");
                out.println(artista.toString());
            }
        }else{
            out.println("Necesita tener minimo un genero registrado");
        }
    }

    public static void buscarGenero() throws IOException{
        ArrayList<Genero> generos = cl.listarGeneros();
        if (!generos.isEmpty()){
            out.println("***Buscar Generos***");
            out.println("Digite el codigo del genero que quiere buscar");
            String codigo = in.readLine();
            out.println("Resultado:");
            for (Genero genero : generos){
                if (genero.getCodigo().equals(codigo)){
                    out.println(genero.toString());
                }
            }
        }else{
            out.println("Necesita tener minimo un genero registrado");
        }
    }

    public static void buscarCompositor() throws IOException{
        ArrayList<Compositor> compositores = cl.listarCompositores();
        if (!compositores.isEmpty()){
            out.println("***Buscar Compositores***");
            out.println("Digite el codigo del compositor que quiere buscar");
            String codigo = in.readLine();
            out.println("Resultado:");
            for (Compositor compositor : compositores){
                if (compositor.getCodigo().equals(codigo)){
                    out.println(compositor.toString());
                }
            }
        }else{
            out.println("Necesita tener minimo un compositor registrado");
        }
    }

    public static void buscarArtista() throws IOException{
        ArrayList<Artista> artistas = cl.listarArtistas();
        if (!artistas.isEmpty()){
            out.println("***Buscar Artistas***");
            out.println("Digite el codigo del artista que quiere buscar");
            String codigo = in.readLine();
            out.println("Resultado:");
            for (Artista artista : artistas){
                if (artista.getCodigo().equals(codigo)){
                    out.println(artista.toString());
                }
            }
        }else{
            out.println("Necesita tener minimo un artista registrado");
        }
    }

    public static void listarGenero(){
        ArrayList<Genero> generos = cl.listarGeneros();
        if (!generos.isEmpty()){
            for (Genero genero: generos){
                out.println(genero.toString());
            }
        } else {
            out.println("No hay generos por mostrar");
        }
    }

    public static void listarCopositor(){
        ArrayList<Compositor> compositores = cl.listarCompositores();
        if (!compositores.isEmpty()){
            for (Compositor compositor: compositores){
                out.println(compositor.toString());
            }
        } else {
            out.println("No hay compositores por mostrar");
        }
    }

    public static void listarArtista(){
        ArrayList<Artista> artistas = cl.listarArtistas();
        if (!artistas.isEmpty()){
            for (Artista artista: artistas){
                out.println(artista.toString());
            }
        } else {
            out.println("No hay artistas por mostrar");
        }
    }

    public static void modificarGenero() throws IOException {
        Genero genero = new Genero();
        out.println("Digite el codigo de genero");
        genero.setCodigo(in.readLine());
        out.println("Digite el nombre del genero");
        genero.setNombre(in.readLine());
        boolean generoModificado = cl.modificarGenero(genero);
        if (generoModificado){
            out.println("Genero modificado:" + genero.toString());
        }else {
            out.println("Genero no pudo modificarse");
        }
    }

    public static void modificarCompositor() throws IOException {
        Compositor compositor = new Compositor();
        ArrayList<Genero> generosAgregados = new ArrayList<Genero>();
        out.println("Digite el codigo de compositor");
        compositor.setCodigo(in.readLine());
        out.println("Digite el nombre del compositor");
        compositor.setNombre(in.readLine());
        boolean digitaGenero = true;
        do {
            out.println("Digite el codigo del genero que quiere agregar al compositor");
            String codigoGenero = in.readLine();
            Genero generoPorId = cl.buscarGeneroPorId(codigoGenero);
            generosAgregados.add(generoPorId);
            out.println("Genero agregado: " + generoPorId);
            out.println("------------------------------");
            out.println("Quiere otro genero al compositor? S/N");
            if(!in.readLine().toUpperCase().equals("S"))
                digitaGenero = false;
        } while (digitaGenero);
        compositor.setGeneros(generosAgregados);
        boolean compositorModificado = cl.modificarCompositor(compositor);
        if (compositorModificado){
            out.println("Compositor modificado:" + compositor.toString());
        }else {
            out.println("Compositor no pudo modificarse");
        }
    }

    public static void modificarArtista() throws IOException {
        Artista artista = new Artista();
        ArrayList<Genero> generosAgregados = new ArrayList<Genero>();
        out.println("Digite el codigo de artista");
        artista.setCodigo(in.readLine());
        out.println("Digite el nombre del artista");
        artista.setNombre(in.readLine());
        boolean digitaGenero = true;
        do {
            out.println("Digite el codigo del genero que quiere agregar al artista");
            String codigoGenero = in.readLine();
            Genero generoPorId = cl.buscarGeneroPorId(codigoGenero);
            generosAgregados.add(generoPorId);
            out.println("Genero agregado: " + generoPorId);
            out.println("------------------------------");
            out.println("Quiere otro genero al artista? S/N");
            if(!in.readLine().toUpperCase().equals("S"))
                digitaGenero = false;
        } while (digitaGenero);
        artista.setGeneros(generosAgregados);
        boolean artistaModificado = cl.modificarArtista(artista);
        if (artistaModificado){
            out.println("Artista modificado:" + artista.toString());
        }else {
            out.println("Artista no pudo modificarse");
        }
    }

    static void eliminarGenero() throws IOException {

        out.println("Digite el codigo de genero");
        String codigo = in.readLine();

        if (cl.eliminarGenero(codigo))
        {
            out.println("Genero eliminado adecuadamente");
        }else
        {
            out.println("Genero no encontrado");
        }
    }

    static void eliminarCompositores() throws IOException {

        out.println("Digite el codigo de compositor");
        String codigo = in.readLine();

        if (cl.eliminarCompositor(codigo))
        {
            out.println("Compositor eliminado adecuadamente");
        }else
        {
            out.println("Compositor no encontrado");
        }
    }

    static void eliminarArtistas() throws IOException {

        out.println("Digite el codigo de artista");
        String codigo = in.readLine();

        if (cl.eliminarArtista(codigo))
        {
            out.println("Artista eliminado adecuadamente");
        }else
        {
            out.println("Artista no encontrado");
        }
    }

}
