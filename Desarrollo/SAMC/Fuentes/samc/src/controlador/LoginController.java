package controlador;

// <editor-fold defaultstate="collapsed" desc="import">
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
import dao.PacienteDAO;
import dao.PacienteDAOImpl;
import dao.ProgramacionDAO;
import dao.ProgramacionDAOImpl;
import dao.RolDAO;
import dao.RolDAOImpl;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;
import model.EspecialidadesModel;
import model.PacienteModel;
import model.ProgramacionModel;
import model.RolModel;
import utilitarios.Item;
import vista.interfaces.ICambioPassword;
import vista.interfaces.IRegistrarPaciente;

 import java.text.ParseException;

// </editor-fold>

/**
 *
 * @author Usuario
 */
public class LoginController implements ActionListener, ItemListener {
    
    private ILogin vLogin;
    private IMenu vMenu;
    private IPerfil vPerfil;
    private IEspecialidades vEspecialidades;
    private ICambioPassword vCambioPassword;
    private UsuarioModel mUsuario;
    private PacienteModel mPaciente;
    private RolModel mRol;
    private ProgramacionModel mProgramacion;
    private UsuarioDAO daoUsuario;
    private PacienteDAO daoPaciente;
    private EspecialidadesDAO daoEspecialidades;
    private RolDAO daoRoles;
    private ProgramacionDAO daoProgramacion;
    private IRegistrarPaciente vRegistrarPaciente;

    public LoginController(ILogin vista, IMenu vMenu, IPerfil vPerfil, IEspecialidades vEspecialidades, ICambioPassword vCambioPassword,IRegistrarPaciente vRegistrarPaciente, UsuarioModel mUsuario, RolModel mRol, ProgramacionModel mProgramacion) {
        this.vLogin = vista;
        this.vMenu = vMenu;
        this.vPerfil = vPerfil;
        this.vEspecialidades = vEspecialidades;
        this.vCambioPassword = vCambioPassword;
        this.mUsuario = mUsuario;
        this.mRol = mRol;
        this.mProgramacion = mProgramacion;
        this.vRegistrarPaciente=vRegistrarPaciente;
        daoUsuario = new UsuarioDAOImpl();
        daoEspecialidades = new EspecialidadesDAOImpl();
        daoRoles = new RolDAOImpl();
        daoProgramacion = new ProgramacionDAOImpl();
        daoPaciente=  new PacienteDAOImpl();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == vLogin.getObjeto(ILogin.JBT_ACEPTAR)) {
            validarUsuario();
        } else if (source == vLogin.getObjeto(ILogin.JBT_LIMPIAR)) {
            vLogin.limpiarTexto();
            vLogin.enfocar();
        } else if (source == vMenu.getObjeto(IMenu.JMI_PERFIL)) {
            verPerfil();
        } else if (source == vMenu.getObjeto(IMenu.JMI_HORESP)) {
            ArrayList<Item> dataVista = new ArrayList<>();
            dataVista.add(new Item(0, "Seleccionar"));
            daoEspecialidades.listar().forEach((listaEsp) -> {
                dataVista.add(new Item(listaEsp.getIdCategoria(), listaEsp.getNombre()));
            });
            vEspecialidades.actualizarEspecialidad(dataVista);
            vEspecialidades.arranca();
        } else if (source == vEspecialidades.getObjeto(IEspecialidades.JBT_CERRAR)) {
            vEspecialidades.ocultar();
        } else if (source == vMenu.getObjeto(IMenu.JMI_CERRARSESION)) {
            cerrarSesion();
        } else if (source == vPerfil.getObjeto(IPerfil.JBT_CAMBIARPASSWORD)) {
            vCambioPassword.limpiarTexto();
            vCambioPassword.arranca();
        } else if (source == vPerfil.getObjeto(IPerfil.JBT_CERRAR)) {
            vPerfil.ocultar();
        } else if (source == vPerfil.getObjeto(IPerfil.JBT_GUARDAR)) {
            editarPerfil();
        } else if (source == vCambioPassword.getObjeto(ICambioPassword.JBT_ACEPTAR)) {
            cambiarContrasena();
        } else if(source == vMenu.getObjeto(IMenu.JMI_REGISTRAR)){
            System.out.println("HOLA");
            vRegistrarPaciente.arranca();              
        } else if(source == vRegistrarPaciente.getObjeto(IRegistrarPaciente.JBT_REGISTRAR)){
            registrarUsuarios();
        } 
        
//        else if (source == vRegistrarPaciente.getObjeto(IRegistrarPaciente.JBT_RETROCEDER)){
//            vRegistrarPaciente.ocultar();
//        }        
    }
    
    private void registrarUsuarios() {
    String nombre = vRegistrarPaciente.getTexto(IRegistrarPaciente.JTF_NOMBRE);
    String apellido = vRegistrarPaciente.getTexto(IRegistrarPaciente.JTF_APELLIDO);
    String dni = vRegistrarPaciente.getTexto(IRegistrarPaciente.JFT_DNI);
    String email = vRegistrarPaciente.getTexto(IRegistrarPaciente.JTF_EMAIL);
    String sexo = vRegistrarPaciente.getTexto(IRegistrarPaciente.JCMB_SEXO);
    String direccion = vRegistrarPaciente.getTexto(IRegistrarPaciente.JTF_DIRECCION);
    String telefono = vRegistrarPaciente.getTexto(IRegistrarPaciente.JTF_TELEFONO);
    String codigoAsegurado = vRegistrarPaciente.getTexto(IRegistrarPaciente.JTF_CODIGO_ASEGURADO);
    Date fechaNacimiento = new Date (vRegistrarPaciente.getFechaNacimiento().getTime()); 
    
        System.out.println(fechaNacimiento); 
    
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fechaNacimientoValidar = dateFormat.format(fechaNacimiento);
    
    if (nombre.isEmpty()) {
           vPerfil.mostrarPanel(IRegistrarPaciente.MSJ_CAMPO_VACIO_NOMBRE);
    } else if (!nombre.matches("^[a-zA-Z]+$")) {
           vPerfil.mostrarPanel(IRegistrarPaciente.MSJ_3);
       } else if (apellido.isEmpty()) {
           vPerfil.mostrarPanel(IRegistrarPaciente.MSJ_CAMPO_VACIO_APELLIDO);
       } else if (!apellido.matches("^[a-zA-Z]+$")) {
           vPerfil.mostrarPanel(IRegistrarPaciente.MSJ_4);
        }  else if (dni.isEmpty()) {
           vPerfil.mostrarPanel(IRegistrarPaciente.MSJ_CAMPO_VACIO_DNI);
       } else if (!dni.matches("^[0-9]{8}$")) {
            vPerfil.mostrarPanel(IRegistrarPaciente.MSJ_5);
       } else if (fechaNacimientoValidar.isEmpty()) {
           vPerfil.mostrarPanel(IRegistrarPaciente.MSJ_CAMPO_VACIO_FECHA_NACIMIENTO);
       } else if (!validarFechaNacimiento(fechaNacimientoValidar)) {
             vPerfil.mostrarPanel(IRegistrarPaciente.MSJ_6);
        }else if (email.isEmpty()) {
           vPerfil.mostrarPanel(IRegistrarPaciente.MSJ_CAMPO_VACIO_EMAIL);
       }   else if (!validarCorreoElectronico(email)) {
              vPerfil.mostrarPanel(IRegistrarPaciente.MSJ_7);
       } else if (direccion.isEmpty()) {
           vPerfil.mostrarPanel(IRegistrarPaciente.MSJ_CAMPO_VACIO_DIRECCION);
       } else if (telefono.isEmpty()) {
           vPerfil.mostrarPanel(IRegistrarPaciente.MSJ_CAMPO_VACIO_TELEFONO);
       } else if (!telefono.matches("^9\\d{8}$")) {
             vPerfil.mostrarPanel(IRegistrarPaciente.MSJ_8);
       }  else if (codigoAsegurado.isEmpty()) {
           vPerfil.mostrarPanel(IRegistrarPaciente.MSJ_CAMPO_VACIO_CODIGO_ASEGURADO);
       }  else if (!codigoAsegurado.matches("^[0-9]{10}$")) {
            vPerfil.mostrarPanel(IRegistrarPaciente.MSJ_9);
       } else {
        
           mPaciente = new PacienteModel();
           
       mPaciente.setNombre(nombre);
       mPaciente.setApellido(apellido); 
       mPaciente.setDni(dni);
       mPaciente.setGenero(sexo);
       mPaciente.setFecha_nacimiento(fechaNacimiento);
       mPaciente.setEmail(email);
       mPaciente.setDireccion(direccion);
       mPaciente.setTelefono(telefono);
       mPaciente.setCodigo_asegurado(codigoAsegurado);
       mPaciente.setFecha_creacion(new Timestamp(System.currentTimeMillis()));
       mPaciente.setFecha_modificacion(null); 
       
        System.out.println(nombre);
        System.out.println(apellido);
        System.out.println(dni);
        System.out.println(sexo);
        System.out.println(fechaNacimiento);
        System.out.println(email);
        System.out.println(direccion);
        System.out.println(telefono);
        System.out.println(codigoAsegurado);
        
        
        daoPaciente.registrar(mPaciente);
       vPerfil.mostrarPanel(IRegistrarPaciente.MENSAJE_EXITOSO);
       vRegistrarPaciente.ocultar();
       }
   
    
    
//   PacienteModel nuevoUsuario = new PacienteModel();
//   nuevoUsuario.setNombre(nombre);
//   nuevoUsuario.setApellido(apellido);
//   nuevoUsuario.setDni(dni);
//   nuevoUsuario.setEmail(email);
//    nuevoUsuario.setGenero(sexo);
//   // nuevoUsuario.setFecha_nacimiento(fechaNacimiento);
//   nuevoUsuario.setDireccion(direccion);
//    nuevoUsuario.setTelefono(telefono);
//   nuevoUsuario.setCodigo_asegurado(codigoAsegurado);
 
       // System.out.println(fechaNacimiento);

        
//    if (daoPaciente.insertar(nuevoUsuario)) {
//        vRegistrarPaciente.mostrarMensaje("Usuario registrado exitosamente.");
//        vRegistrarPaciente.limpiarTexto();
//    } else {
//        vRegistrarPaciente.mostrarMensaje("Error al registrar el usuario. Inténtelo de nuevo.");
//    }

    }
  
    
    
private boolean validarFechaNacimiento(String fechaNacimiento) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    dateFormat.setLenient(false);

    try {
        java.util.Date fecha = dateFormat.parse(fechaNacimiento);

        Calendar calendarioActual = Calendar.getInstance();
        int anioActual = calendarioActual.get(Calendar.YEAR);

        int anioMinimo = 1923;
        int anioMaximo = 2023;

        Calendar calendarioFechaNacimiento = Calendar.getInstance();
        calendarioFechaNacimiento.setTime(fecha);
        int anioNacimiento = calendarioFechaNacimiento.get(Calendar.YEAR);

        return (anioNacimiento >= anioMinimo && anioNacimiento <= anioMaximo);
    } catch (ParseException e) {
        return false; 
    }
}


        private boolean validarCorreoElectronico(String correoElectronico) {
        return correoElectronico.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    
    
    // <editor-fold defaultstate="collapsed" desc="Casos de Uso">
    private void validarUsuario() {
        int idusuario;
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
    }
    
    private void cerrarSesion() {
        reiniciarVentanas();
        mUsuario = new UsuarioModel();
        vMenu.setTitulo("");
        vLogin.arranca();
        vLogin.enfocar();
    }
    
    private void verPerfil() {
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
        vPerfil.setHabilitar(IPerfil.JCKB_ACTIVO, false);
        vPerfil.setHabilitar(IPerfil.JCB_ROL, false);
        vPerfil.arranca();
    }
    
    private void editarPerfil() {
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
    }
    
    private void cambiarContrasena() {
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
    // </editor-fold>
    
    private void reiniciarVentanas() {
        vMenu.ocultar();
        vPerfil.ocultar();
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

    @Override
    public void itemStateChanged(ItemEvent e) {
        Object source = e.getSource();
        if (source == vEspecialidades.getObjeto(IEspecialidades.JCB_ESPECIALIDADES)) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                System.out.println("getIdEspecialidad: " + vEspecialidades.getIdEspecialidad());
                actualizarHorario();
            }
        }
    }
    
    private void actualizarHorario() {
        ArrayList<String> data = new ArrayList<>();
        List<ProgramacionModel> lista = daoProgramacion.listar(vEspecialidades.getIdEspecialidad());
        String estado = "";
        for (ProgramacionModel modelo : lista) {
            if (modelo.getCupos_restantes() == 0) {
                estado = "(Completado)";
            } else if (modelo.getCupos_restantes() > 0) {
                estado = "(Disponible)";
            }
            data.add(obtenerDiaDeSemana(modelo.getFecha()) + ": \t" + modelo.getFecha() + " " + modelo.getHora_inicio() + " - " + modelo.getHora_fin() + " " + estado);
        }
        if (lista.isEmpty()) {
            data.add("[NO PROGRAMADO]");
        }
        vEspecialidades.actualizarHorario(data);
    }
    
    private String obtenerDiaDeSemana(Date fecha) {
        
        // Crear un objeto Calendar y establecer la fecha
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);

        // Obtener el día de la semana como un número (1 = Domingo, 2 = Lunes, ..., 7 = Sábado)
        int diaDeLaSemana = calendar.get(Calendar.DAY_OF_WEEK);

        // Convertir el número a un nombre del día de la semana
        String[] nombresDias = {"Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
        String nombreDia = nombresDias[diaDeLaSemana - 1];
        
        return nombreDia;
    }
}
