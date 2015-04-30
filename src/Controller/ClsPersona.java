/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Modell.IdPersona;
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
    
    public ArrayList reportePersona(){        
        return tbpersona;
    }
    
    
}
