/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.interfaces;

import controlador.LoginController;
//import controlador.MenuController;

/**
 *
 * @author Usuario
 */
public interface IMenu extends IPadre {
    void setControlador(LoginController c);
    
    static final String TITULO_SISTEMA = "SAMC v1.0 - Plutón SAC / ";
    
    static final String JMI_PERFIL = "JMIPERFIL";
    static final String JMI_HORESP = "JMI_HORESP";
    static final String JMI_CERRARSESION = "JMICERRARSESION";
        static final String JMI_REGISTRAR = "JMI_REGISTRAR";

}
