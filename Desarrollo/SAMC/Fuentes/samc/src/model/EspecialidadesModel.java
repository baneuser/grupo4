/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Usuario
 */
public class EspecialidadesModel {
    private int idCategoria;
    private String nombre;
    private int cupos_diarios;
    private int veces_semana;

    public int getCupos_diarios() {
        return cupos_diarios;
    }

    public void setCupos_diarios(int cupos_diarios) {
        this.cupos_diarios = cupos_diarios;
    }

    public int getVeces_semana() {
        return veces_semana;
    }

    public void setVeces_semana(int veces_semana) {
        this.veces_semana = veces_semana;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
