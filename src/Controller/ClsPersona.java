/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import static Controller.ConexionBD.con;
import static Controller.ConexionBD.st;
import Modell.IdPersona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author JOEL
 */
public class ClsPersona {    
    ArrayList <IdPersona>tbpersona = new ArrayList<IdPersona>(); 
    
    public ClsPersona(IdPersona idp) {
        tbpersona.add(idp);
    }
    public ClsPersona(){
        ConexionBD cx = new ConexionBD();
    }
    
    public ArrayList reportePersona(){        
        return tbpersona;
    }
    public ArrayList<String> listaDatos() throws SQLException {
        String sql = "SELECT id_categoria, descripcion, estado FROM categoria "; //example es el nombre de la tabla
        //PreparedStatement ps = con.prepareStatement(sql);
 
        ArrayList<String> ls = new ArrayList<String>(); //Creamos un arraylist para meter los datos extraídos de la tabla
 
        ResultSet rs = st.executeQuery(sql);
        con.commit();
        while(rs.next()){
            //datos de la tabla
            ls.add(rs.getString("descripcion"));//nombre es el campo de la base de datos
        }
        return ls;
    }
    
}
