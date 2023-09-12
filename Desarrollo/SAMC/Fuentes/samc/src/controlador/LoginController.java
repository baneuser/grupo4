/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.UsuarioModel;
import vista.ILogin;
import vista.IPadre;

/**
 *
 * @author Usuario
 */
public class LoginController implements ActionListener {
    
    private ILogin vLogin;
    private UsuarioModel modelo;
    private UsuarioDAO dao;

    public LoginController(ILogin vista, UsuarioModel modelo) {
        this.vLogin = vista;
        this.modelo = modelo;
        dao = new UsuarioDAOImpl();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == vLogin.getJButton(ILogin.JBACEPTAR)) {
            ArrayList<String> lista = vLogin.getCredenciales();
            if (lista != null) {
//                System.out.println(lista.get(0));
//                System.out.println(lista.get(1));
                if (dao.validarCredenciales(lista.get(0), lista.get(1)) == 1) {
                    vLogin.mostrarPanel(ILogin.USUARIO_EXISTE);
                    vLogin.limpiarTexto();
                    
                } else {
                    vLogin.mostrarPanel(ILogin.USUARIO_NO_EXISTE);
                    vLogin.seleccionarText();
                }
            }
        } else if (source == vLogin.getJButton(IPadre.JBLIMPIAR)) {
            vLogin.limpiarTexto();
        }
        
    }
    
}
