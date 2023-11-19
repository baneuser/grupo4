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
import model.MedicoModel;
import model.PacienteModel;
import model.UsuarioModel;

/**
 *
 * @author Usuario
 */
public class MedicoDAOImpl implements MedicoDAO {

    @Override
    public List<MedicoModel> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public MedicoModel leer(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    }

    @Override
    public void registrar(MedicoModel t) {
    }

    @Override
    public void actualizar(MedicoModel t) {
        
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<MedicoModel> getMedicoxEspecialidad(int id) {
        List<MedicoModel> lista = null;
        MedicoModel modelo = null;
        try {
            Conexion.getInstancia().conectar();
            // Llamar al procedimiento almacenado
            String sql = "{ CALL centromedico.getMedicoxEspecialidad(?) }";
            PreparedStatement preparedStatement = Conexion.getInstancia().conexion.prepareStatement(sql);
            preparedStatement.setInt(1, id);
//            preparedStatement.execute();
            
            // Recuperar el resultado en un ResultSet
//            ResultSet resultSet = callableStatement.getResultSet();
            ResultSet resultSet = preparedStatement.executeQuery();
//            boolean encontrado = resultSet.first();
            
            lista = new ArrayList<>();
            // Procesar el resultado
            while (resultSet.next()) {
                modelo = new MedicoModel();
                modelo.setIdmedico(resultSet.getInt("idmedico"));
                modelo.setNombre(resultSet.getString("nombre"));
                modelo.setApellido(resultSet.getString("apellido"));
                modelo.setDni(resultSet.getString("dni"));
                modelo.setGenero(resultSet.getString("genero"));
                modelo.setFecha_nacimiento(resultSet.getDate("fecha_nacimiento"));
                modelo.setEmail(resultSet.getString("email"));
                modelo.setDireccion(resultSet.getString("direccion"));
                modelo.setTelefono(resultSet.getString("telefono"));
                modelo.setCodigo_colegiatura(resultSet.getString("codigo_colegiatura"));
                modelo.setFecha_creacion(resultSet.getTimestamp("fecha_creacion"));
                modelo.setFecha_modificacion(resultSet.getTimestamp("fecha_modificacion"));
                modelo.setIdespecialidad(resultSet.getInt("idespecialidad"));
                
                lista.add(modelo);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception ->"+ e.getMessage());
        }
        return lista;
    }

}
