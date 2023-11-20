/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.interfaces;

import controlador.LoginController;
import java.util.List;
import model.HistorialModel;

/**
 *
 * @author Usuario
 */
public interface IAtenderCita extends IPadre {
    void setControlador(LoginController c);
    void ingresarAtenderCita(List<HistorialModel> data);
    int getNumHistorial(List<HistorialModel> data);
    static final String JTA_SINTOMAS = "JTA_SINTOMAS";
    static final String JTA_ANALISIS = "JTA_ANALISIS";
    static final String JBT_GUARDAR = "JBT_GUARDAR";
    static final String JBT_CERRAR = "JBT_CERRAR";
    static final String JLB_NUMERO = "JLB_NUMERO";
}
