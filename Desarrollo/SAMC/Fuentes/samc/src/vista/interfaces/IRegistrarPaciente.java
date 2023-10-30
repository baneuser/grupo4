
package vista.interfaces;

import controlador.LoginController;
import java.util.Date;

public interface IRegistrarPaciente extends IPadre {
    void setControlador(LoginController c);
    
    void actualizarRoles(String[] data);
    Date getFechaNacimiento();
    void setHabilitar(String obj, boolean b);
    
 
    static final String MSJ_3 = "El nombre contiene caracteres no permitidos (incluir solo letras).";
    static final String MSJ_4 = "Los apellidos contienen caracteres no permitidos (incluir solo letras).";
    static final String MSJ_5 = "El DNI no es válido.";
    static final String MSJ_6 = "La fecha de nacimiento no es válida.";
    static final String MSJ_7 = "El correo electrónico no tiene un formato válido.";
    static final String MSJ_8 = "El teléfono no es válido.";
    static final String MSJ_9 = "El código de asegurado no es válido.";
     static final String MENSAJE_ERROR_DNI = "El DNI ya existe";
     static final String MENSAJE_EXITOSO = "Paciente registrado correctamente";
     
     static final String MSJ_CAMPO_VACIO_NOMBRE = "El campo Nombre no puede estar vacío.";
     static final String MSJ_CAMPO_VACIO_APELLIDO = "El campo Apellido no puede estar vacío.";
     static final String MSJ_CAMPO_VACIO_DNI = "El campo DNI no puede estar vacío.";
     static final String MSJ_CAMPO_VACIO_SEXO = "El campo Sexo no puede estar vacío.";
     static final String MSJ_CAMPO_VACIO_FECHA_NACIMIENTO = "El campo Fecha de nacimiento no puede estar vacío.";
     static final String MSJ_CAMPO_VACIO_EMAIL = "El campo Email no puede estar vacío.";
     static final String MSJ_CAMPO_VACIO_DIRECCION = "El campo Dirección no puede estar vacío.";
     static final String MSJ_CAMPO_VACIO_TELEFONO = "El campo Teléfono no puede estar vacío.";
     static final String MSJ_CAMPO_VACIO_CODIGO_ASEGURADO = "El campo Código asegurado no puede estar vacío.";

     
    static final String JFT_DNI = "JFT_DNI";
    static final String JTF_NOMBRE = "JTF_NOMBRE";
    static final String JTF_APELLIDO = "JTF_APELLIDO";
    static final String JTF_EMAIL = "JTF_EMAIL";
    static final String JTF_FECHA_NACIMIENTO = "JTF_FECHA_NACIMIENTO";
    static final String JCMB_SEXO = "JCMB_SEXO";
    static final String JBT_REGISTRAR = "JBT_REGISTRAR";
    static final String JBT_RETROCEDER = "JBT_RETROCEDER";
    static final String JTF_DIRECCION = "JTF_DIRECCION";
    static final String JTF_TELEFONO = "JTF_TELEFONO";
    static final String JTF_CODIGO_ASEGURADO = "JTF_CODIGO_ASEGURADO";
    static final String JTF_FECHA_CREACION = "JTF_FECHA_CREACION";
    static final String JTF_FECHA_MODIFICACION = "JTF_FECHA_MODIFICACION";   
}