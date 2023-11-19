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
import model.ProgramacionModel;
import model.UsuarioModel;

/**
 *
 * @author Usuario
 */
public class ProgramacionDAOImpl implements ProgramacionDAO {

    @Override
    public List<ProgramacionModel> listar(int idespecialidad) {
        List<ProgramacionModel> lista = null;
        ProgramacionModel model = null;
        try {
            Conexion.getInstancia().conectar();
            // Llamar al procedimiento almacenado
            String sql = "{ CALL centromedico.getHorarioxEspecialidad(?) }";
            PreparedStatement preparedStatement = Conexion.getInstancia().conexion.prepareStatement(sql);
            preparedStatement.setInt(1, idespecialidad);
//            preparedStatement.execute();
            
            // Recuperar el resultado en un ResultSet
//            ResultSet resultSet = callableStatement.getResultSet();
            ResultSet resultSet = preparedStatement.executeQuery();
//            boolean encontrado = resultSet.first();
            
            lista = new ArrayList<>();
            // Procesar el resultado
            while (resultSet.next()) {
                model = new ProgramacionModel();
                model.setIdprogramacion(resultSet.getInt("idprogramacion"));
                model.setFecha(resultSet.getDate("fecha"));
                model.setHora_inicio(resultSet.getTime("hora_inicio"));
                model.setHora_fin(resultSet.getTime("hora_fin"));
                model.setCupos_restantes(resultSet.getInt("cupos_restantes"));
                model.setFecha_creacion(resultSet.getTimestamp("fecha_creacion"));
                model.setIdespecialidad(resultSet.getInt("idespecialidad"));
                
                lista.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception ->"+ e.getMessage());
        }
        return lista;
    }
    
    @Override
    public List<ProgramacionModel> listarDisponibles(int idespecialidad) {
        List<ProgramacionModel> lista = null;
        ProgramacionModel model = null;
        try {
            Conexion.getInstancia().conectar();
            // Llamar al procedimiento almacenado
            String sql = "{ CALL centromedico.getHorarioDisponiblesxEspecialidad(?) }";
            PreparedStatement preparedStatement = Conexion.getInstancia().conexion.prepareStatement(sql);
            preparedStatement.setInt(1, idespecialidad);
//            preparedStatement.execute();
            
            // Recuperar el resultado en un ResultSet
//            ResultSet resultSet = callableStatement.getResultSet();
            ResultSet resultSet = preparedStatement.executeQuery();
//            boolean encontrado = resultSet.first();
            
            lista = new ArrayList<>();
            // Procesar el resultado
            while (resultSet.next()) {
                model = new ProgramacionModel();
                model.setIdprogramacion(resultSet.getInt("idprogramacion"));
                model.setFecha(resultSet.getDate("fecha"));
                model.setHora_inicio(resultSet.getTime("hora_inicio"));
                model.setHora_fin(resultSet.getTime("hora_fin"));
                model.setCupos_restantes(resultSet.getInt("cupos_restantes"));
                model.setFecha_creacion(resultSet.getTimestamp("fecha_creacion"));
                model.setIdespecialidad(resultSet.getInt("idespecialidad"));
                
                lista.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception ->"+ e.getMessage());
        }
        return lista;
    }

    @Override
    public List<ProgramacionModel> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProgramacionModel leer(int id) {
        ProgramacionModel model = null;
        try {
            Conexion.getInstancia().conectar();
            // Llamar al procedimiento almacenado
            String sql = "{ CALL centromedico.getProgramacionPorId(?) }";
            PreparedStatement preparedStatement = Conexion.getInstancia().conexion.prepareStatement(sql);
            preparedStatement.setInt(1, id);
//            preparedStatement.execute();
            
            // Recuperar el resultado en un ResultSet
//            ResultSet resultSet = callableStatement.getResultSet();
            ResultSet resultSet = preparedStatement.executeQuery();
//            boolean encontrado = resultSet.first();
            
            // Procesar el resultado
            while (resultSet.next()) {
                model = new ProgramacionModel();
                model.setIdprogramacion(resultSet.getInt("idprogramacion"));
                model.setFecha(resultSet.getDate("fecha"));
                model.setHora_inicio(resultSet.getTime("hora_inicio"));
                model.setHora_fin(resultSet.getTime("hora_fin"));
                model.setCupos_restantes(resultSet.getInt("cupos_restantes"));
                model.setFecha_creacion(resultSet.getTimestamp("fecha_creacion"));
                model.setIdespecialidad(resultSet.getInt("idespecialidad"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception ->"+ e.getMessage());
        }
        return model;
    }

    @Override
    public void registrar(ProgramacionModel t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(ProgramacionModel t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int reservaCupo(int idprogramacion) {
        int resultado = -1;
        try {
            Conexion.getInstancia().conectar();
            String sql = "{ ? = call centromedico.reservarCupo(?) }";
            CallableStatement callableStatement = Conexion.getInstancia().conexion.prepareCall(sql);
            
            // Establecer los parámetros de entrada
            callableStatement.setInt(2, idprogramacion);
            
            // Definir el parámetro de salida
            callableStatement.registerOutParameter(1, Types.INTEGER);
            
            // Ejecutar la función
            callableStatement.execute();
            
            // Obtener el valor de retorno
            resultado = callableStatement.getInt(1);
            
            // Cerrar la conexión
            Conexion.getInstancia().cerrar();
        } catch (Exception e) {
            System.out.println("Exception ->"+ e.getMessage());
        }
        System.out.println("El resultado de reservaCupo es: " + resultado);
        
        return resultado;
    }


}
