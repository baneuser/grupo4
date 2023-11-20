
package dao;

import java.util.List;
import model.MedicoModel;


public interface MedicoDAO extends CRUD<MedicoModel>{
   List<MedicoModel> getMedicoxEspecialidad(int id);
}
