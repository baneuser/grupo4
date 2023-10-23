
package vista.interfaces;

import controlador.LoginController;

public interface IRegistrarPaciente extends IPadre {
    void setControlador(LoginController c);
    
    void actualizarRoles(String[] data);
    void setHabilitar(String obj, boolean b);
    
    static final String MSJ_1 = "Nombre o apellido no pueden estar vacios";
    static final String MSJ_2 = "Sin Cambios, tiene que editar para que tenga efecto";
    static final String MSJ_3 = "Guardado los cambios";
     static final String MENSAJE_ERROR_DNI = "El DNI ya existe";
     static final String MENSAJE_EXITOSO = "Paciente registrado con éxito";

    static final String JFT_DNI = "JFT_DNI";
    static final String JLB_BIENVENIDA = "JLB_BIENVENIDA";
    static final String JTF_USUARIO = "JTF_USUARIO";
    static final String JTF_NOMBRE = "JTF_NOMBRE";
    static final String JTF_APELLIDO = "JTF_APELLIDO";
    static final String JTF_EMAIL = "JTF_EMAIL";
    static final String JTF_FECHA_NACIMIENTO = "JTF_FECHA_NACIMIENTO";
    static final String JCMB_SEXO = "JCMB_SEXO";
    static final String JBT_REGISTRAR = "JBT_REGISTRAR";
    static final String JBT_RETROCEDER = "JBT_RETROCEDER";
}