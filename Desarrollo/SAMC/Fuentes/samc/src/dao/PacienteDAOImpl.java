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
import model.PacienteModel;
import model.UsuarioModel;

/**
 *
 * @author Usuario
 */
public class PacienteDAOImpl implements PacienteDAO {

    @Override
    public List<PacienteModel> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PacienteModel leer(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    }

    @Override
    public void registrar(PacienteModel t) {
     try {
            Conexion.getInstancia().conectar();
            
            String sql = "CALL centromedico.registrarPaciente(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = Conexion.getInstancia().conexion.prepareStatement(sql)) {
                stmt.setString(1, t.getNombre());
                stmt.setString(2, t.getApellido());
                stmt.setString(3, t.getDni());
                stmt.setString(4, t.getGenero());
                stmt.setDate(5, t.getFecha_nacimiento());
                stmt.setString(6, t.getEmail());
                stmt.setString(7, t.getDireccion());
                stmt.setString(8, t.getTelefono());
                stmt.setString(9, t.getCodigo_asegurado());
                stmt.setTimestamp(10, t.getFecha_creacion());
                stmt.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception ->"+ e.getMessage());
        }
        
    }

    @Override
    public void actualizar(PacienteModel t) {
        
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PacienteModel getPacientexDNI(String dni) {
        PacienteModel mPaciente = null;
        try {
            Conexion.getInstancia().conectar();
            // Llamar al procedimiento almacenado
            String sql = "{ CALL centromedico.getPacientexDNI(?) }";
            PreparedStatement preparedStatement = Conexion.getInstancia().conexion.prepareStatement(sql);
            preparedStatement.setString(1, dni);
//            preparedStatement.execute();
            
            // Recuperar el resultado en un ResultSet
//            ResultSet resultSet = callableStatement.getResultSet();
            ResultSet resultSet = preparedStatement.executeQuery();
//            boolean encontrado = resultSet.first();
            
            mPaciente = new PacienteModel();
            // Procesar el resultado
            while (resultSet.next()) {
                mPaciente.setIdPaciente(resultSet.getInt("idPaciente"));
                mPaciente.setNombre(resultSet.getString("nombre"));
                mPaciente.setApellido(resultSet.getString("apellido"));
                mPaciente.setDni(resultSet.getString("dni"));
                mPaciente.setGenero(resultSet.getString("genero"));
                mPaciente.setFecha_nacimiento(resultSet.getDate("fecha_nacimiento"));
                mPaciente.setEmail(resultSet.getString("email"));
                mPaciente.setDireccion(resultSet.getString("direccion"));
                mPaciente.setTelefono(resultSet.getString("telefono"));
                mPaciente.setCodigo_asegurado(resultSet.getString("codigo_asegurado"));
                mPaciente.setFecha_creacion(resultSet.getTimestamp("fecha_creacion"));
                mPaciente.setFecha_modificacion(resultSet.getTimestamp("fecha_modificacion"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception ->"+ e.getMessage());
        }
        return mPaciente;
    }

    @Override
    public PacienteModel getPacientexCodigoAsegurado(String codigo) {
        PacienteModel mPaciente = null;
        try {
            Conexion.getInstancia().conectar();
            // Llamar al procedimiento almacenado
            String sql = "{ CALL centromedico.getPacientexCodigo(?) }";
            PreparedStatement preparedStatement = Conexion.getInstancia().conexion.prepareStatement(sql);
            preparedStatement.setString(1, codigo);
//            preparedStatement.execute();
            
            // Recuperar el resultado en un ResultSet
//            ResultSet resultSet = callableStatement.getResultSet();
            ResultSet resultSet = preparedStatement.executeQuery();
//            boolean encontrado = resultSet.first();
            
            mPaciente = new PacienteModel();
            // Procesar el resultado
            while (resultSet.next()) {
                mPaciente.setIdPaciente(resultSet.getInt("idPaciente"));
                mPaciente.setNombre(resultSet.getString("nombre"));
                mPaciente.setApellido(resultSet.getString("apellido"));
                mPaciente.setDni(resultSet.getString("dni"));
                mPaciente.setGenero(resultSet.getString("genero"));
                mPaciente.setFecha_nacimiento(resultSet.getDate("fecha_nacimiento"));
                mPaciente.setEmail(resultSet.getString("email"));
                mPaciente.setDireccion(resultSet.getString("direccion"));
                mPaciente.setTelefono(resultSet.getString("telefono"));
                mPaciente.setCodigo_asegurado(resultSet.getString("codigo_asegurado"));
                mPaciente.setFecha_creacion(resultSet.getTimestamp("fecha_creacion"));
                mPaciente.setFecha_modificacion(resultSet.getTimestamp("fecha_modificacion"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception ->"+ e.getMessage());
        }
        return mPaciente;
    }
}
