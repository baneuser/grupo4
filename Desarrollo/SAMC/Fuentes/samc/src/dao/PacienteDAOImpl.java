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

    
}
