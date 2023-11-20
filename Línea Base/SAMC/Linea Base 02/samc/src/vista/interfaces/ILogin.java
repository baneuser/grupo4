/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.interfaces;

import controlador.LoginController;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author Usuario
 */
public interface ILogin extends IPadre {
    void setControlador(LoginController c);
    
    ArrayList<String> getCredenciales();
    
    static final String DATOS_INCOMPLETO = "Campos vacios";
    static final String USUARIO_NO_EXISTE = "Usuario o contraseña incorrecto";
    static final String USUARIO_INACTIVO = "Usuario inactivo. Solicitar activación de su usuario";
//    static final String USUARIO_EXISTE = "Bienvenido";
    
    static final String JTF_USUARIO = "JTF_USUARIO";
    static final String JPF_PASSWORD = "JPF_PASSWORD";
    static final String JBT_ACEPTAR = "JBT_ACEPTAR";
    static final String JBT_LIMPIAR = "JBT_LIMPIAR";
}
