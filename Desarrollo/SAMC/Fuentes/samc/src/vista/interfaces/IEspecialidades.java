/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.interfaces;

import controlador.LoginController;

/**
 *
 * @author Usuario
 */
public interface IEspecialidades extends IPadre {
    void setControlador(LoginController c);
    
    void actualizarTabla(Object[][] data);
    
    static final String JBT_CERRAR = "JBT_CERRAR";
}
