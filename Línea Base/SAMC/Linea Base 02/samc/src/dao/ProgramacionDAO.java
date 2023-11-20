/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.ProgramacionModel;


/**
 *
 * @author Usuario
 */
public interface ProgramacionDAO extends CRUD<ProgramacionModel>{
    List<ProgramacionModel> listar(int idespecialidad);
    List<ProgramacionModel> listarDisponibles(int idespecialidad);
    int reservaCupo(int idprogramacion);
}
