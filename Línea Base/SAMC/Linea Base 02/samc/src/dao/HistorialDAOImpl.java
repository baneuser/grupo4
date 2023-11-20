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

}
