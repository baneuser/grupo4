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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            
            // Hacer algo con el resultado (por ejemplo, mostrarlo)
//            System.out.println("El resultado de validarAcceso es: " + resultado);
            
            // Cerrar la conexión
            Conexion.getInstancia().cerrar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }
    
}
