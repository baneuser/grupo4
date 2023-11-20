
package dao;

import java.util.List;
import model.HistorialModel;


public interface HistorialDAO extends CRUD<HistorialModel>{
    List<HistorialModel> getHistorialPacientes(int num_historial);
    void actualizarHistorialYEstado(HistorialModel t);
}
