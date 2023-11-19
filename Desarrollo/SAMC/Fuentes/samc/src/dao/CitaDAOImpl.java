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
import java.util.HashSet;
import java.util.List;
import model.CitaModel;

/**
 *
 * @author Usuario
 */
public class CitaDAOImpl implements CitaDAO{

    @Override
    public List<CitaModel> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CitaModel leer(int id) {
        /*CitaModel mCita = null;
        try {
            Conexion.getInstancia().conectar();
            // Llamar al procedimiento almacenado
            String sql = "{ CALL centromedico.getRolPorId(?) }";
            PreparedStatement preparedStatement = Conexion.getInstancia().conexion.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            mCita = new CitaModel();
            while (resultSet.next()){
                mCita.setNombre(resultSet.getString("nombre"));
                mCita.setIdcita(resultSet.getInt("idcita"));
                mCita.setTitulo(resultSet.getString("titulo"));
                mCita.setNota(resultSet.getString("nota"));
                mCita.setFecha(resultSet.getTimestamp("fecha"));
                mCita.setIdmedico(resultSet.getInt("idmedico"));
                mCita.setFecha_creacion(resultSet.getTimestamp("fecha_creacion"));
                mCita.setIdusuario(resultSet.getInt("idusuario"));
                mCita.setIdestado(resultSet.getInt("idestado"));
                mCita.setNumero_historial(resultSet.getInt("numero_historial"));
            }   
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception ->"+ e.getMessage());
        }
        return mCita;*/
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registrar(CitaModel t) {
        try {
            Conexion.getInstancia().conectar();
            
            String sql = "CALL centromedico.registrarCita(?, ?, ?, ?, ?, ?, ?, ?)";
            try (CallableStatement stmt = Conexion.getInstancia().conexion.prepareCall(sql)) {
                stmt.setString(1, t.getTitulo());
                stmt.setString(2, t.getNota());
                stmt.setTimestamp(3, t.getFecha());
                stmt.setInt(4, t.getIdmedico());
                stmt.setInt(5, t.getIdusuario());
                stmt.setInt(6, t.getIdestado());
                stmt.setInt(7, t.getNumero_historial());
                stmt.registerOutParameter(8, Types.INTEGER);
                stmt.execute();
                
                int v_id_cita = stmt.getInt(8);
                System.out.println("v_id_cita = " + v_id_cita);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception ->"+ e.getMessage());
        }
    }

    @Override
    public void actualizar(CitaModel t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CitaModel> getCitasProgramadas() {
        List<CitaModel> lista=null;
        CitaModel mCita = null;
        try {
            Conexion.getInstancia().conectar();
            // Llamar al procedimiento almacenado
            String sql = "{ CALL centromedico.getCitaMedicaProgramada() }";
            PreparedStatement preparedStatement = Conexion.getInstancia().conexion.prepareStatement(sql);
//            preparedStatement.setInt(1, id);
//            preparedStatement.execute();
            
            // Recuperar el resultado en un ResultSet
//            ResultSet resultSet = callableStatement.getResultSet();
            ResultSet resultSet = preparedStatement.executeQuery();
//            boolean encontrado = resultSet.first();
            
            lista = new ArrayList<>();
            while (resultSet.next()) {
                mCita = new CitaModel();
                
                mCita.setNombre_estado(resultSet.getString("nombre_estado"));
                mCita.setNombre_medico(resultSet.getString("nombre_medico"));
                mCita.setNombre_usuario(resultSet.getString("nombre_usuario"));
                mCita.setNombre_paciente(resultSet.getString("nombre_paciente"));
                mCita.setIdcita(resultSet.getInt("idcita"));
                mCita.setTitulo(resultSet.getString("titulo"));
                mCita.setNota(resultSet.getString("nota"));
                mCita.setFecha(resultSet.getTimestamp("fecha"));
                mCita.setIdmedico(resultSet.getInt("idmedico"));
                mCita.setFecha_creacion(resultSet.getTimestamp("fecha_creacion"));
                mCita.setIdusuario(resultSet.getInt("idusuario"));
                mCita.setIdestado(resultSet.getInt("idestado"));
                mCita.setNumero_historial(resultSet.getInt("numero_historial"));
                lista.add(mCita);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception ->"+ e.getMessage());
        }
        return lista;
    }
}
