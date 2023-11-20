/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.interfaces;

import controlador.LoginController;
import java.util.ArrayList;
import utilitarios.Item;

/**
 *
 * @author Usuario
 */
public interface IReservarCita extends IPadre {
    void setController(LoginController c);
    void actualizarEspecialidad(ArrayList<Item> data);
    int getIdEspecialidadSeleccionada();
    String getEspecialidadSeleccionada();
    int getIdMedicoSeleccionada();
    void actualizarHorario(ArrayList<Item> data);
    void actualizarMedico(ArrayList<Item> data);
    int getHorario();
    void seleccionarxDefectoOpcionEspecialidad();
    
    static final String JBT_RESERVAR = "JBT_RESERVAR";
    static final String JBT_CERRAR = "JBT_CERRAR";
    static final String JCB_ESPECIALIDADES = "JCB_ESPECIALIDADES";
    static final String JTF_PACIENTE = "JTF_DNI_PACIENTE";
    static final String JTF_NOTA = "JTF_NOTA";
    static final String JTF_SINTOMAS = "JTF_SINTOMAS";
    static final String MSJ_SELECCIONAR = "Por favor seleccionar una opción";
    static final String MSJ_CAMPO_VACIO = "Campo vacío.";
    static final String MSJ_DNI = "El DNI no es válido.";
    static final String MSJ_RESERVA_EXITOSA = "CITA RESERVADA, POR FAVOR VERIFICAR";
}
