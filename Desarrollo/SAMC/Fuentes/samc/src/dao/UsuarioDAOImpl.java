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
import java.util.List;
import model.UsuarioModel;

/**
 *
 * @author Usuario
 */
public class UsuarioDAOImpl implements UsuarioDAO {

    @Override
    public List<UsuarioModel> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UsuarioModel leer(int id) {
        UsuarioModel mUsuario = null;
        try {
            Conexion.getInstancia().conectar();
            // Llamar al procedimiento almacenado
            String sql = "{ CALL centromedico.getUsuarioPorId(?) }";
            PreparedStatement preparedStatement = Conexion.getInstancia().conexion.prepareStatement(sql);
            preparedStatement.setInt(1, id);
//            preparedStatement.execute();
            
            // Recuperar el resultado en un ResultSet
//            ResultSet resultSet = callableStatement.getResultSet();
            ResultSet resultSet = preparedStatement.executeQuery();
//            boolean encontrado = resultSet.first();
            
            mUsuario = new UsuarioModel();
            // Procesar el resultado
            while (resultSet.next()) {
                mUsuario.setId(resultSet.getInt("idusuario"));
                mUsuario.setNombreusuario(resultSet.getString("nombreusuario"));
                mUsuario.setNombre(resultSet.getString("nombre"));
                mUsuario.setApellido(resultSet.getString("apellido"));
                mUsuario.setEmail(resultSet.getString("email"));
                mUsuario.setFecha_creacion(resultSet.getTimestamp("fecha_creacion"));
//                mUsuario.setPassword(resultSet.getString("password"));
                mUsuario.setEsta_activo(resultSet.getInt("esta_activo"));
                mUsuario.setEs_admin(resultSet.getInt("es_admin"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception ->"+ e.getMessage());
        }
        return mUsuario;
    }

    @Override
    public void registrar(UsuarioModel t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(UsuarioModel t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int validarCredenciales(String usuario, String password) {
        int resultado = -1;
        try {
            Conexion.getInstancia().conectar();
            String sql = "{ ? = call centromedico.validarAcceso(?, ?) }";
            CallableStatement callableStatement = Conexion.getInstancia().conexion.prepareCall(sql);
            
            // Establecer los parámetros de entrada
            callableStatement.setString(2, usuario);
            callableStatement.setString(3, password);
            
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
        System.out.println("El resultado de validarAcceso es: " + resultado);
        
        return resultado;
    }
    
}
