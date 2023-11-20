package main;

// <editor-fold defaultstate="collapsed" desc="import">
import controlador.LoginController;
import dao.Conexion;
import dao.EspecialidadesDAOImpl;
import java.util.List;
import model.EspecialidadesModel;
import model.ProgramacionModel;
import model.RolModel;
import model.UsuarioModel;
import model.CitaModel;
import model.HistorialModel;
import model.MedicoModel;
import vista.JFAtenderCita;
import vista.JFCambioPassword;
import vista.JFEspecialidades;
import vista.interfaces.ILogin;
import vista.interfaces.IMenu;
import vista.interfaces.IPerfil;
import vista.JFLogin;
import vista.JFMenu;
import vista.JFPerfil;
import vista.JFRegistrarPaciente;
import vista.JFReservarCita;
import vista.JFVerCitas;
import vista.interfaces.IAtenderCita;
import vista.interfaces.ICambioPassword;
import vista.interfaces.IEspecialidades;
import vista.interfaces.IRegistrarPaciente;
import vista.interfaces.IReservarCita;
import vista.interfaces.IVerCitas;
// </editor-fold>

/**
 *
 * @author Usuario
 */
public class Programa {
    public static void main(String[] args) {
        Conexion.getInstancia();
        
        // Modelo
        UsuarioModel mUsuario = new UsuarioModel();
        RolModel mRol = new RolModel();
        ProgramacionModel mProgramacion = new ProgramacionModel();
        CitaModel mCita = new CitaModel();
        HistorialModel mHistorial = new HistorialModel();
        MedicoModel mMedico = new MedicoModel();
        
        // Vista
        ILogin vLogin = new JFLogin();
        IMenu vMenu = new JFMenu();
        IPerfil vPerfil = new JFPerfil();
        IEspecialidades vEspecialidades = new JFEspecialidades();
        ICambioPassword vCambioPassword = new JFCambioPassword();
        IRegistrarPaciente vIRegistrarPaciente = new JFRegistrarPaciente();
        IVerCitas vVerCitas = new JFVerCitas();
        IAtenderCita vAtenderCita = new JFAtenderCita();
        IReservarCita vReservarCita = new JFReservarCita();
        
        // Controladores
        LoginController cLogin = new LoginController(vLogin, vMenu, vPerfil, vEspecialidades, vCambioPassword,vIRegistrarPaciente, vVerCitas, vAtenderCita, vReservarCita, mUsuario, mRol, mProgramacion, mCita, mHistorial, mMedico);
        vLogin.setControlador(cLogin);
        vMenu.setControlador(cLogin);
        vPerfil.setControlador(cLogin);
        vEspecialidades.setControlador(cLogin);
        vCambioPassword.setControlador(cLogin);
        vIRegistrarPaciente.setControlador(cLogin);
        vVerCitas.setControlador(cLogin);
        vAtenderCita.setControlador(cLogin);
        vReservarCita.setController(cLogin);
        
        // Inicia
        vLogin.arranca();
    }
    
}
