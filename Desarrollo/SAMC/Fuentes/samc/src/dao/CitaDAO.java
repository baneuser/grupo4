/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.List;
import model.CitaModel;

/**
 *
 * @author Usuario
 */
public interface CitaDAO extends CRUD<CitaModel>{
    List<CitaModel> getCitasProgramadas();
    int getNumeroCitasPaciente(int idusuario);
}
