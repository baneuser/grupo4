/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controlador.LoginController;
import dao.Conexion;
import model.UsuarioModel;
import vista.ILogin;
import vista.JFLogin;

/**
 *
 * @author Usuario
 */
public class Programa {
    public static void main(String[] args) {
        Conexion.getInstancia();
        
        // Modelo
        UsuarioModel mUsuario = new UsuarioModel();
        
        // Vista
        ILogin vLogin = new JFLogin();
        
        // Controladores
        LoginController cLogin = new LoginController(vLogin, mUsuario);
        vLogin.setControlador(cLogin);
        
        // Inicia
        vLogin.arranca();
    }
}
