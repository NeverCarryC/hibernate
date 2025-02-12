package model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity(name = "trabajadores")
public class Trabajador implements Serializable {

    //pk
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String nombre;

    @Column(name = "surename")
    private String apellido;

    @Column
    private String correo;

    @Column(name = "phone")
    private int telefono;

    public Trabajador(int telefono, String correo, String apellido, String nombre) {
        this.telefono = telefono;
        this.correo = correo;
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public Trabajador(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
