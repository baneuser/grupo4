/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import model.EspecialidadesModel;
import model.UsuarioModel;

/**
 *
 * @author Usuario
 */
public class EspecialidadesDAOImpl implements EspecialidadesDAO {

    @Override
    public List<EspecialidadesModel> listar() {
        List<EspecialidadesModel> lista = null;
        EspecialidadesModel mEspecialidades = null;
        try {
            Conexion.getInstancia().conectar();
            // Llamar al procedimiento almacenado
            String sql = "{ CALL centromedico.getEspecialidades() }";
            PreparedStatement preparedStatement = Conexion.getInstancia().conexion.prepareStatement(sql);
//            preparedStatement.setInt(1, id);
//            preparedStatement.execute();
            
            // Recuperar el resultado en un ResultSet
//            ResultSet resultSet = callableStatement.getResultSet();
            ResultSet resultSet = preparedStatement.executeQuery();
//            boolean encontrado = resultSet.first();
            
            lista = new ArrayList<>();
            // Procesar el resultado
            while (resultSet.next()) {
                mEspecialidades = new EspecialidadesModel();
                mEspecialidades.setIdCategoria(resultSet.getInt("idespecialidad"));
                mEspecialidades.setNombre(resultSet.getString("nombre"));
                mEspecialidades.setCupos_diarios(resultSet.getInt("cupos_diarios"));
                mEspecialidades.setVeces_semana(resultSet.getInt("veces_semana"));
                lista.add(mEspecialidades);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception ->"+ e.getMessage());
        }
        return lista;
    }

    @Override
    public EspecialidadesModel leer(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registrar(EspecialidadesModel t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(EspecialidadesModel t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
