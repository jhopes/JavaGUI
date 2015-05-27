/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author JOEL
 */
public class ConexionBD {
    
   

    static Connection con; // objeto conexión.
    private static ConexionBD INSTANCE = null;
    static Statement st;

    /**Método constructor que ejecuta el método para conectar con la base de datos
     *
     */
    public ConexionBD() {
        performConnection();
    }

    /**Crea una instancia de la base de datos en caso de no estar creada.
     *
     */
    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ConexionBD();
        }
    }

    /**Metodo para retorna una instancia de la conexion. Si no esta creada la crea, y si esta creada la retorna
     * @return retorna una instancia de la conexión a la base de datos
     */
    public static ConexionBD getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }

    /**Método para eliminar la instancia de la conexión
     *
     */
    public static void deleteInstance() {
        INSTANCE = null;
        CloseConexion();
    }

    /**Método que crea la conexión a la base de datos
     *
     */
    public void performConnection() {

        try { // preparamos la conexión            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "venta", "venta");
            st = con.createStatement();
            System.out.println("conexión abierta.");
        } catch (Exception e) {
            System.out.println("Error al abrir la conexión.");
        }
    }

    /**Método para cerrar la conexión con la base de dades
     *
     */
    public static void CloseConexion(){
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexión.");
        }
    }

    
}
