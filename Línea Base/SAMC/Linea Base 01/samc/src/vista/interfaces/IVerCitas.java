/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.interfaces;

import controlador.LoginController;
import java.util.List;
import utilitarios.Item;
import model.CitaModel;

/**
 *
 * @author Usuario
 */
public interface IVerCitas extends IPadre {
    void setControlador(LoginController c);
    void llenarTabla(List<CitaModel> data);
    void buscarTabla(List<CitaModel> data);
    void limpiarBusqueda(List<CitaModel> data);
    void buscarFechaTabla(List<CitaModel> data);
    void mostrarInfoCita(List<CitaModel> data);
    
    static final String JTB_TABLA = "JTB_TABLA";
    static final String JBT_BUSCAR = "JBT_BUSCAR";
    static final String JBT_CERRAR = "JBT_CERRAR";
    static final String JBT_LIMPIAR = "JBT_LIMPIAR";
    static final String JBT_BUSCARPF = "JBT_BUSCARPF";
}
