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
import model.HistorialModel;
import model.PacienteModel;
import model.UsuarioModel;

/**
 *
 * @author Usuario
 */
public class HistorialDAOImpl implements HistorialDAO {

    @Override
    public List<HistorialModel> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public HistorialModel leer(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    }

    @Override
    public void registrar(HistorialModel t) {
     try {
            Conexion.getInstancia().conectar();
            
            String sql = "CALL centromedico.registrarHistorial(?, ?, ?, ?, ?)";
            try (CallableStatement stmt = Conexion.getInstancia().conexion.prepareCall(sql)) {
//                stmt.setInt(1, t.getNumero_historial());
                stmt.setInt(1, t.getIdpaciente());
                stmt.setDate(2, t.getFecha());
                stmt.setString(3, t.getSintomas());
                stmt.setString(4, t.getAnalisis());
                stmt.registerOutParameter(5, Types.INTEGER);
                stmt.execute();
                
                int v_numero_historial = stmt.getInt(5);
                System.out.println("v_numero_historial = " + v_numero_historial);
                t.setNumero_historial(v_numero_historial);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception ->"+ e.getMessage());
        }
        
    }

    @Override
    public void actualizar(HistorialModel t) {
        
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<HistorialModel> getHistorialPacientes(int num_historial) {
        List<HistorialModel> lista=null;
        HistorialModel mHistorial = null;
        try {
            Conexion.getInstancia().conectar();
            // Llamar al procedimiento almacenado
            String sql = "{ CALL centromedico.getHistorialPaciente(?) }";
            PreparedStatement preparedStatement = Conexion.getInstancia().conexion.prepareStatement(sql);
            preparedStatement.setInt(1, num_historial);
//            preparedStatement.execute();
            
            // Recuperar el resultado en un ResultSet
//            ResultSet resultSet = callableStatement.getResultSet();
            ResultSet resultSet = preparedStatement.executeQuery();
//            boolean encontrado = resultSet.first();
            
            lista = new ArrayList<>();
            while (resultSet.next()) {
                mHistorial = new HistorialModel();
                
                mHistorial.setNombre_paciente(resultSet.getString("nombre_paciente"));
                mHistorial.setNumero_historial(resultSet.getInt("numero_historial"));
                mHistorial.setIdpaciente(resultSet.getInt("idpaciente"));
                mHistorial.setFecha(resultSet.getDate("fecha"));
                mHistorial.setSintomas(resultSet.getString("sintomas"));
                mHistorial.setAnalisis(resultSet.getString("analisis"));
                lista.add(mHistorial);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception ->"+ e.getMessage());
        }
        return lista;
    }

    @Override
    public void actualizarHistorialYEstado(HistorialModel t) {
        try {
            Conexion.getInstancia().conectar();
            
            String sql = "CALL actualizarHistorial(?, ?, ?)";
            try (PreparedStatement stmt = Conexion.getInstancia().conexion.prepareStatement(sql)) {
                stmt.setString(1, t.getSintomas());
                stmt.setString(2, t.getAnalisis());
                stmt.setInt(3, t.getNumero_historial());
                stmt.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception ->"+ e.getMessage());
        }
    }

}
