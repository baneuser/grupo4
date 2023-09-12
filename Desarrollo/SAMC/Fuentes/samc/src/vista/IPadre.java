/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JButton;

/**
 *
 * @author Usuario
 */
public interface IPadre {
    void arranca();
    void mostrarPanel(String txt);
    void limpiarTexto();
    void enfocar();
    void seleccionarText();
    void setTitulo(String txt);
    
    static final String JBACEPTAR = "JBACEPTAR";
    static final String JBLIMPIAR = "JBLIMPIAR";
}
