/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.interfaces;

//import controlador.JTableController;
import controlador.LoginController;
import java.util.ArrayList;
import utilitarios.Item;

/**
 *
 * @author Usuario
 */
public interface IEspecialidades extends IPadre {
//    void setControlador(LoginController c, JTableController c2);
    void setControlador(LoginController c);
    
    int getIdEspecialidad();
    void actualizarEspecialidad(ArrayList<Item> data);
    void actualizarHorario(ArrayList<String> data);
//    void actualizarTabla(Object[][] data);
//    int getIdSeleccionada();
    
    static final String JBT_CERRAR = "JBT_CERRAR";
    static final String JCB_ESPECIALIDADES = "JCB_ESPECIALIDADES";
}
