/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.Timestamp;

/**
 *
 * @author Usuario
 */
public class CitaModel {

    private String nombre_estado;
    private String nombre_medico;
    private String nombre_usuario;
    private String nombre_paciente;
    private int idcita;
    private String titulo;
    private String nota;
    private Timestamp fecha;
    private int idmedico;
    private Timestamp fecha_creacion;
    private int idusuario;
    private int idestado;
    private int numero_historial;
    
    public void setIdcita(int idcita) {
        this.idcita = idcita;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public void setIdmedico(int idmedico) {
        this.idmedico = idmedico;
    }

    public void setFecha_creacion(Timestamp fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public void setIdestado(int idestado) {
        this.idestado = idestado;
    }

    public void setNumero_historial(int numero_historial) {
        this.numero_historial = numero_historial;
    }
    
    public int getIdcita() {
        return idcita;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getNota() {
        return nota;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public int getIdmedico() {
        return idmedico;
    }

    public Timestamp getFecha_creacion() {
        return fecha_creacion;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public int getIdestado() {
        return idestado;
    }

    public int getNumero_historial() {
        return numero_historial;
    }
    
    public String getNombre_estado() {
        return nombre_estado;
    }

    public void setNombre_estado(String nombre_estado) {
        this.nombre_estado = nombre_estado;
    }
    
    public String getNombre_medico() {
        return nombre_medico;
    }

    public void setNombre_medico(String nombre_medico) {
        this.nombre_medico = nombre_medico;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }
    
    public String getNombre_paciente() {
        return nombre_paciente;
    }

    public void setNombre_paciente(String nombre_paciente) {
        this.nombre_paciente = nombre_paciente;
    }
}
