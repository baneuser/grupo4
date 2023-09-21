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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.UsuarioModel;
import vista.interfaces.IEspecialidades;
import vista.interfaces.ILogin;
import vista.interfaces.IMenu;
import vista.interfaces.IPadre;
import vista.interfaces.IPerfil;
import dao.EspecialidadesDAO;
import dao.EspecialidadesDAOImpl;
import java.util.List;
import model.EspecialidadesModel;

/**
 *
 * @author Usuario
 */
public class LoginController implements ActionListener {
    
    private ILogin vLogin;
    private IMenu vMenu;
    private IPerfil vPerfil;
    private IEspecialidades vEspecialidades;
    private UsuarioModel mUsuario;
    private UsuarioDAO daoUsuario;
    private EspecialidadesDAO daoEspecialidades;

    public LoginController(ILogin vista, IMenu vMenu, IPerfil vPerfil, IEspecialidades vEspecialidades, UsuarioModel modelo) {
        this.vLogin = vista;
        this.vMenu = vMenu;
        this.vPerfil = vPerfil;
        this.vEspecialidades = vEspecialidades;
        this.mUsuario = modelo;
        daoUsuario = new UsuarioDAOImpl();
        daoEspecialidades = new EspecialidadesDAOImpl();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        int idusuario;
        if (source == vLogin.getObjeto(ILogin.JBT_ACEPTAR)) {
            ArrayList<String> lista = vLogin.getCredenciales();
            if (lista != null) {
                idusuario = daoUsuario.validarCredenciales(lista.get(0), lista.get(1));
                if (idusuario > 0) {
//                    vLogin.mostrarPanel(ILogin.USUARIO_EXISTE);
                    vLogin.limpiarTexto();
                    mUsuario = daoUsuario.leer(idusuario);
                    if (mUsuario != null) {
                        vMenu.setTitulo(IMenu.TITULO_SISTEMA + mUsuario.getNombre().toUpperCase() + " " + mUsuario.getApellido().toUpperCase());
                        
                        vLogin.ocultar();
                        vMenu.arranca();
                    }
                } else if (idusuario == 0) {
                    vLogin.limpiarTexto(ILogin.JPF_PASSWORD);
                    vLogin.enfocar();
                    vLogin.seleccionarText();
                    vLogin.mostrarPanel(ILogin.USUARIO_NO_EXISTE);
                } else {
                    vLogin.mostrarPanel(ILogin.ERROR_BD);
                    vLogin.seleccionarText();
                }
            } else {
                vLogin.mostrarPanel(ILogin.DATOS_INCOMPLETO);
                vLogin.enfocar();
            }
        } else if (source == vLogin.getObjeto(ILogin.JBT_LIMPIAR)) {
            vLogin.limpiarTexto();
            vLogin.enfocar();
        } else if (source == vMenu.getObjeto(IMenu.JMI_PERFIL)) {
            System.out.println("Nombre y apellido: " + mUsuario.getNombre() + " " + mUsuario.getApellido());
            vPerfil.setTexto(IPerfil.JLB_BIENVENIDA, IPerfil.BIENVENIDA + mUsuario.getNombre().toUpperCase() + " " + mUsuario.getApellido().toUpperCase());
            vPerfil.setTexto(IPerfil.JTF_USUARIO, mUsuario.getNombreusuario());
            vPerfil.setTexto(IPerfil.JTF_NOMBRE, mUsuario.getNombre());
            vPerfil.setTexto(IPerfil.JTF_APELLIDO, mUsuario.getApellido());
            vPerfil.setTexto(IPerfil.JTF_EMAIL, mUsuario.getEmail());
            vPerfil.setTexto(IPerfil.JTF_FCREACION, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(mUsuario.getFecha_creacion()));
            if (mUsuario.getEsta_activo() == 0) {
                vPerfil.setTexto(IPerfil.JCKB_ACTIVO, "false");
            } else if (mUsuario.getEsta_activo() == 1) {
                vPerfil.setTexto(IPerfil.JCKB_ACTIVO, "true");
            }
            if (mUsuario.getEs_admin() == 0) {
                vPerfil.setTexto(IPerfil.JCKB_ADMIN, "false");
            } else if (mUsuario.getEsta_activo() == 1) {
                vPerfil.setTexto(IPerfil.JCKB_ADMIN, "true");
            }
            vPerfil.arranca();
        } else if (source == vMenu.getObjeto(IMenu.JMI_ESPECIALIDADES)) {
            List<EspecialidadesModel> lista = daoEspecialidades.listar();
            Object[][] data = new Object[lista.size()][2];
            for (int i = 0; i < lista.size(); i++) {
                data[i][0] = lista.get(i).getIdCategoria();
                data[i][1] = lista.get(i).getNombre();
            }
            vEspecialidades.actualizarTabla(data);
            vEspecialidades.arranca();
        } else if (source == vEspecialidades.getObjeto(IEspecialidades.JBT_CERRAR)) {
            vEspecialidades.ocultar();
        } else if (source == vMenu.getObjeto(IMenu.JMI_CERRARSESION)) {
            reiniciarVentanas();
            mUsuario = new UsuarioModel();
            vMenu.setTitulo("");
            vLogin.arranca();
            vLogin.enfocar();
        }
        
    }
    
    private void reiniciarVentanas() {
        vMenu.ocultar();
        vPerfil.ocultar();
    }
    
}
