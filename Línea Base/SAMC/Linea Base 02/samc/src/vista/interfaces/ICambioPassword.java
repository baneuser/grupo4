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
public interface ICambioPassword extends IPadre {
    void setControlador(LoginController c);
    
    static final String JPF_ACTUAL = "JTF_ANTIGUO";
    static final String JPF_NUEVO = "JTF_NUEVO";
    static final String JBT_ACEPTAR = "JBT_ACEPTAR";
    
    static final String MSJ_1 = "Contraseña actual incorrecta";
    static final String MSJ_2 = "Las contraseñas coinciden, debe ser distinta";
    static final String MSJ_3 = "Contraseña Actualizada";
}
