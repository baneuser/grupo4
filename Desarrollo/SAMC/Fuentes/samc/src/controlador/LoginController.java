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
//import vista.interfaces.IPadre;
import vista.interfaces.IPerfil;
import dao.EspecialidadesDAO;
import dao.EspecialidadesDAOImpl;
import dao.RolDAO;
import dao.RolDAOImpl;
import java.sql.Timestamp;
import java.util.List;
import model.EspecialidadesModel;
import model.RolModel;
import vista.interfaces.ICambioPassword;

/**
 *
 * @author Usuario
 */
public class LoginController implements ActionListener {
    
    private ILogin vLogin;
    private IMenu vMenu;
    private IPerfil vPerfil;
    private IEspecialidades vEspecialidades;
    private ICambioPassword vCambioPassword;
    private UsuarioModel mUsuario;
    private RolModel mRol;
    private UsuarioDAO daoUsuario;
    private EspecialidadesDAO daoEspecialidades;
    private RolDAO daoRoles;

    public LoginController(ILogin vista, IMenu vMenu, IPerfil vPerfil, IEspecialidades vEspecialidades, ICambioPassword vCambioPassword, UsuarioModel mUsuario, RolModel mRol) {
        this.vLogin = vista;
        this.vMenu = vMenu;
        this.vPerfil = vPerfil;
        this.vEspecialidades = vEspecialidades;
        this.vCambioPassword = vCambioPassword;
        this.mUsuario = mUsuario;
        this.mRol = mRol;
        daoUsuario = new UsuarioDAOImpl();
        daoEspecialidades = new EspecialidadesDAOImpl();
        daoRoles = new RolDAOImpl();
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
                    mUsuario = daoUsuario.leer(idusuario);
                    if (mUsuario != null) {
                        if (mUsuario.getActivo() == 1) {
                            vLogin.limpiarTexto();
                            mRol = daoRoles.leer(mUsuario.getIdRol());
                            vMenu.setTitulo(IMenu.TITULO_SISTEMA
                                    + "Usuario : " + mUsuario.getUsuario().toUpperCase() + " / "
                                    + "Rol: " + mRol.getSiglas()
                            );

                            vLogin.ocultar();
                            vMenu.arranca();
                        } else if (mUsuario.getActivo() == 0) {
                            vLogin.limpiarTexto(ILogin.JPF_PASSWORD);
                            vLogin.enfocar();
                            vLogin.seleccionarText();
                            vLogin.mostrarPanel(ILogin.USUARIO_INACTIVO);
                        }
                    } else {
                        vLogin.enfocar();
                        vLogin.seleccionarText();
                        vLogin.mostrarPanel(ILogin.ERROR_BD);
                    }
                } else if (idusuario == 0) {
                    vLogin.limpiarTexto(ILogin.JPF_PASSWORD);
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
            cargarCabeceraPerfil();
            vPerfil.setTexto(IPerfil.JTF_USUARIO, mUsuario.getUsuario());
            vPerfil.setTexto(IPerfil.JTF_NOMBRE, mUsuario.getNombre());
            vPerfil.setTexto(IPerfil.JTF_APELLIDO, mUsuario.getApellido());
            vPerfil.setTexto(IPerfil.JTF_EMAIL, mUsuario.getEmail());
            if (mUsuario.getFecha_creacion() != null) {
                vPerfil.setTexto(IPerfil.JTF_FCREACION, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(mUsuario.getFecha_creacion()));
            } else {
                vPerfil.setTexto(IPerfil.JTF_FCREACION, "");
            }
            if (mUsuario.getFecha_modificacion() != null) {
                vPerfil.setTexto(IPerfil.JTF_FMODIFICACION, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(mUsuario.getFecha_modificacion()));
            } else {
                vPerfil.setTexto(IPerfil.JTF_FMODIFICACION, "");
            }
            if (mUsuario.getActivo() == 0) {
                vPerfil.setTexto(IPerfil.JCKB_ACTIVO, "false");
            } else if (mUsuario.getActivo() == 1) {
                vPerfil.setTexto(IPerfil.JCKB_ACTIVO, "true");
            }
            vPerfil.actualizarRoles(getFormatRoles(daoRoles.listar()));
            vPerfil.setTexto(IPerfil.JCB_ROL, String.format("%d", mUsuario.getIdRol() - 1));
//            if (mUsuario.getIdRol() == 1 || mUsuario.getIdRol() == 4) {
//                vPerfil.setHabilitar(IPerfil.JCKB_ACTIVO, true);
//            } else {
                vPerfil.setHabilitar(IPerfil.JCKB_ACTIVO, false);
//            }
//            if (mUsuario.getIdRol() == 4) {
//                vPerfil.setHabilitar(IPerfil.JCB_ROL, true);
//            } else {
                vPerfil.setHabilitar(IPerfil.JCB_ROL, false);
//            }
            vPerfil.arranca();
        } else if (source == vMenu.getObjeto(IMenu.JMI_ESPECIALIDADES)) {
//            List<EspecialidadesModel> lista = daoEspecialidades.listar();
//            Object[][] data = new Object[lista.size()][2];
//            for (int i = 0; i < lista.size(); i++) {
//                data[i][0] = lista.get(i).getIdCategoria();
//                data[i][1] = lista.get(i).getNombre();
//            }
//            vEspecialidades.actualizarTabla(data);
            vEspecialidades.actualizarTabla(getFormatCategorias(daoEspecialidades.listar()));
            vEspecialidades.arranca();
        } else if (source == vEspecialidades.getObjeto(IEspecialidades.JBT_CERRAR)) {
            vEspecialidades.ocultar();
        } else if (source == vMenu.getObjeto(IMenu.JMI_CERRARSESION)) {
            reiniciarVentanas();
            mUsuario = new UsuarioModel();
            vMenu.setTitulo("");
            vLogin.arranca();
            vLogin.enfocar();
        } else if (source == vPerfil.getObjeto(IPerfil.JBT_CAMBIARPASSWORD)) {
            vCambioPassword.limpiarTexto();
            vCambioPassword.arranca();
        } else if (source == vPerfil.getObjeto(IPerfil.JBT_CERRAR)) {
            vPerfil.ocultar();
        } else if (source == vPerfil.getObjeto(IPerfil.JBT_GUARDAR)) {
            String nombre = vPerfil.getTexto(IPerfil.JTF_NOMBRE);
            String apellido = vPerfil.getTexto(IPerfil.JTF_APELLIDO);
            String email = vPerfil.getTexto(IPerfil.JTF_EMAIL);
            if (!nombre.isEmpty() && !apellido.isEmpty()) {
                if (!nombre.equals(mUsuario.getNombre()) || !apellido.equals(mUsuario.getApellido()) || !email.equals(mUsuario.getEmail())) {
                    mUsuario.setNombre(nombre);
                    mUsuario.setApellido(apellido);
                    if (email.equals("")) {
                        mUsuario.setEmail(null);
                    } else {
                        mUsuario.setEmail(email);
                    }
                    mUsuario.setFecha_modificacion(new Timestamp(System.currentTimeMillis()));
                    daoUsuario.actualizar(mUsuario);
                    cargarCabeceraPerfil();
                    vPerfil.mostrarPanel(IPerfil.MSJ_3);
                } else {
                    vPerfil.mostrarPanel(IPerfil.MSJ_2);
                }
            } else {
                vPerfil.mostrarPanel(IPerfil.MSJ_1);
            }
        } else if (source == vCambioPassword.getObjeto(ICambioPassword.JBT_ACEPTAR)) {
            String antiguo = vCambioPassword.getTexto(ICambioPassword.JPF_ACTUAL);
            String nuevo = vCambioPassword.getTexto(ICambioPassword.JPF_NUEVO);
            if (!antiguo.isEmpty() && !nuevo.isEmpty()) {
                if (antiguo.equals(mUsuario.getPassword())) {
                    if (!antiguo.equals(nuevo)) {
                        mUsuario.setPassword(nuevo);
                        daoUsuario.actualizar(mUsuario);
                        vCambioPassword.ocultar();
                        vCambioPassword.mostrarPanel(ICambioPassword.MSJ_3);
                    } else {
                        vCambioPassword.mostrarPanel(ICambioPassword.MSJ_2);
                    }
                } else {
                    vCambioPassword.mostrarPanel(ICambioPassword.MSJ_1);
                }
            } else {
                vCambioPassword.mostrarPanel(ILogin.DATOS_INCOMPLETO);
            }
        }
        
    }
    
    private void reiniciarVentanas() {
        vMenu.ocultar();
        vPerfil.ocultar();
    }
    
    private Object[][] getFormatCategorias(List<EspecialidadesModel> lista) {
        Object[][] data = new Object[lista.size()][2];
        for (int i = 0; i < lista.size(); i++) {
            data[i][0] = lista.get(i).getIdCategoria();
            data[i][1] = lista.get(i).getNombre();
        }
        return data;
    }
    
    private String[] getFormatRoles(List<RolModel> lista) {
        String[] data = new String[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
//            data[i] = lista.get(i).getIdrol();
            data[i] = lista.get(i).getNombre();
//            data[i] = lista.get(i).getSiglas();
        }
        return data;
    }
    
    private void cargarCabeceraPerfil() {
        vPerfil.setTexto(IPerfil.JLB_BIENVENIDA, IPerfil.BIENVENIDA + mUsuario.getNombre().toUpperCase() + " " + mUsuario.getApellido().toUpperCase());
    }
}
