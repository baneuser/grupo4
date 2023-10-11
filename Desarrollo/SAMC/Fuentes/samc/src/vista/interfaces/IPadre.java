/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.interfaces;

/**
 *
 * @author Usuario
 */
public interface IPadre {
    void arranca();
    void ocultar();
    void mostrarPanel(String txt);
    void limpiarTexto();
    void enfocar();
    void seleccionarText();
    void setTitulo(String txt);
    Object getObjeto(String id);
    void setTexto(String obj, String txt);
    String getTexto(String obj);
    void limpiarTexto(String obj);
    
    //VARIABLES GLOBALES
    static final String ERROR_BD = "Error de Base de datos";
}
