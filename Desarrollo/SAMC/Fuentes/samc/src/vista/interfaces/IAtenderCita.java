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
public interface IAtenderCita extends IPadre {
    void setControlador(LoginController c);
    static final String JBT_GUARDAR = "JBT_GUARDAR";
    static final String JBT_CERRAR = "JBT_CERRAR";
}
