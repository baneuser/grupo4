
package dao;

import model.EspecialidadesModel;
import model.PacienteModel;
import model.UsuarioModel;


public interface PacienteDAO extends CRUD<PacienteModel>{
   PacienteModel getPacientexDNI(String dni);
   PacienteModel getPacientexCodigoAsegurado(String codigo);
}
