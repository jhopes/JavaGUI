
import Controller.ClsPersona;
import Controller.ConexionBD;
import frontend.FormPrincipal;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JOEL
 */
public class principal {

    /**
     * @param args the command line arguments
     */
    private static ArrayList<String> ls = new ArrayList<String>();
    public static void main(String[] args) throws SQLException {
        /*FormPrincipal f = new FormPrincipal();
        f.setVisible(true);*/
        ClsPersona p = new ClsPersona();
        ls = p.listaDatos();
        for(int i=0; i<ls.size();i++){
            System.out.println(" "+ls.get(i));
        }
    }
    
}
