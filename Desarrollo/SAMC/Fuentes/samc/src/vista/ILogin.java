/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.LoginController;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author Usuario
 */
public interface ILogin extends IPadre {
    void setControlador(LoginController c);
    JButton getJButton(String obj);
    
    ArrayList<String> getCredenciales();
    
    static final String DATOS_INCOMPLETO = "DATOS INCOMPLETOS";
    static final String USUARIO_NO_EXISTE = "Usuario no existe";
    static final String USUARIO_EXISTE = "Bienvenido";
}
