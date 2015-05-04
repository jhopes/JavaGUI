/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Modell.IdTipoPersona;
import java.util.ArrayList;

/**
 *
 * @author JOEL
 */
public class ClsTipoPersona {
   ArrayList <IdTipoPersona>tbtipopersona = new ArrayList<IdTipoPersona>(); 
    public ClsTipoPersona(IdTipoPersona idtp) {
        tbtipopersona.add(idtp);
    }
    
    public ArrayList reporteTipoPersona(){        
        return tbtipopersona;
    } 
}
