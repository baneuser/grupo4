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
import model.RolModel;

/**
 *
 * @author Usuario
 */
public class RolDAOImpl implements RolDAO {

    @Override
    public List<RolModel> listar() {
        List<RolModel> lista = null;
        RolModel mRol = null;
        try {
            Conexion.getInstancia().conectar();
            // Llamar al procedimiento almacenado
            String sql = "{ CALL centromedico.getRoles() }";
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
                mRol = new RolModel();
                mRol.setIdrol(resultSet.getInt("idrol"));
                mRol.setNombre(resultSet.getString("nombre"));
                mRol.setSiglas(resultSet.getString("siglas"));
                lista.add(mRol);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception ->"+ e.getMessage());
        }
        return lista;
    }

    @Override
    public RolModel leer(int id) {
        RolModel mRol = null;
        try {
            Conexion.getInstancia().conectar();
            // Llamar al procedimiento almacenado
            String sql = "{ CALL centromedico.getRolPorId(?) }";
            PreparedStatement preparedStatement = Conexion.getInstancia().conexion.prepareStatement(sql);
            preparedStatement.setInt(1, id);
//            preparedStatement.execute();
            
            // Recuperar el resultado en un ResultSet
//            ResultSet resultSet = callableStatement.getResultSet();
            ResultSet resultSet = preparedStatement.executeQuery();
//            boolean encontrado = resultSet.first();
            
            mRol = new RolModel();
            // Procesar el resultado
            while (resultSet.next()) {
                mRol.setIdrol(resultSet.getInt("idrol"));
                mRol.setNombre(resultSet.getString("nombre"));
                mRol.setSiglas(resultSet.getString("siglas"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception ->"+ e.getMessage());
        }
        return mRol;
    }

    @Override
    public void registrar(RolModel t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(RolModel t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
