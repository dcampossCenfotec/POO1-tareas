package capaLogica;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuracion {
    private String claseJDBC;
    private String stringConexion;

    public String getClaseJDBC() {
        return claseJDBC;
    }

    public void setClaseJDBC(String claseJDBC) {
        this.claseJDBC = claseJDBC;
    }

    public String getStringConexion() {
        return stringConexion;
    }

    public void setStringConexion(String stringConexion) {
        this.stringConexion = stringConexion;
    }

    public Configuracion() {
        leerConfiguracion();
    }

    public Configuracion(String claseJDBC, String stringConexion) {
        this.claseJDBC = claseJDBC;
        this.stringConexion = stringConexion;
    }

    public void leerConfiguracion()
    {
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("/Users/danielcampos/Documents/Universidad/POO1/POO1-tareas/CarritoDanielCamposSanchezCapaLogica/src/capaLogica/config.properties");
            properties.load(fileInputStream);
            this.setClaseJDBC(properties.getProperty("claseJDBC"));
            this.setStringConexion(properties.getProperty("StringConexion"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
