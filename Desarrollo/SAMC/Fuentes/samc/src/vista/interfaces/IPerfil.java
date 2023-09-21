/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.interfaces;

import controlador.LoginController;
//import controlador.PerfilController;

/**
 *
 * @author Usuario
 */
public interface IPerfil extends IPadre {
    void setControlador(LoginController c);
    
    static final String BIENVENIDA = "HOLA ";
    
    static final String JLB_BIENVENIDA = "JLB_BIENVENIDA";
    static final String JTF_USUARIO = "JTF_USUARIO";
    static final String JTF_NOMBRE = "JTF_NOMBRE";
    static final String JTF_APELLIDO = "JTF_APELLIDO";
    static final String JTF_EMAIL = "JTF_EMAIL";
    static final String JTF_FCREACION = "JTF_FCREACION";
    static final String JCKB_ACTIVO = "JCKB_ACTIVO";
    static final String JCKB_ADMIN = "JCKB_ADMIN";
}
