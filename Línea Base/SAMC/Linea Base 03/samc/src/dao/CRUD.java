/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author Usuario
 * @param <T>
 */
public interface CRUD<T> {
    List<T> listar();
    T leer (int id);
    void registrar(T t);
    void actualizar(T t);
    void eliminar(int id);
}
