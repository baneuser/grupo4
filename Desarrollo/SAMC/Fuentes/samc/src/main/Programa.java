/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controlador.LoginController;
//import controlador.MenuController;
//import controlador.PerfilController;
import dao.Conexion;
import model.UsuarioModel;
import vista.JFEspecialidades;
import vista.interfaces.ILogin;
import vista.interfaces.IMenu;
import vista.interfaces.IPerfil;
import vista.JFLogin;
import vista.JFMenu;
import vista.JFPerfil;
import vista.interfaces.IEspecialidades;

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
        IMenu vMenu = new JFMenu();
        IPerfil vPerfil = new JFPerfil();
        IEspecialidades vEspecialidades = new JFEspecialidades();
        
        // Controladores
        LoginController cLogin = new LoginController(vLogin, vMenu, vPerfil, vEspecialidades, mUsuario);
        vLogin.setControlador(cLogin);
        vMenu.setControlador(cLogin);
        vPerfil.setControlador(cLogin);
        vEspecialidades.setControlador(cLogin);
        
        // Inicia
        vLogin.arranca();
    }
}
