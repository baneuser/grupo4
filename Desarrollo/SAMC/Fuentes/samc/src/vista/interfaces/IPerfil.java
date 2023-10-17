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
    
    void actualizarRoles(String[] data);
    void setHabilitar(String obj, boolean b);
    
    static final String BIENVENIDA = "HOLA ";
    static final String MSJ_1 = "Nombre o apellido no pueden estar vacios";
    static final String MSJ_2 = "Sin Cambios, tiene que editar para que tenga efecto";
    static final String MSJ_3 = "Guardado los cambios";
    
    static final String JLB_BIENVENIDA = "JLB_BIENVENIDA";
    static final String JTF_USUARIO = "JTF_USUARIO";
    static final String JTF_NOMBRE = "JTF_NOMBRE";
    static final String JTF_APELLIDO = "JTF_APELLIDO";
    static final String JTF_EMAIL = "JTF_EMAIL";
    static final String JTF_FCREACION = "JTF_FCREACION";
    static final String JTF_FMODIFICACION = "JTF_FMODIFICACION";
    static final String JCKB_ACTIVO = "JCKB_ACTIVO";
    static final String JCB_ROL = "JCB_ROL";
    static final String JBT_CAMBIARPASSWORD = "JBT_CAMBIARPASSWORD";
    static final String JBT_GUARDAR = "JBT_GUARDAR";
    static final String JBT_CERRAR = "JBT_CERRAR";
}
