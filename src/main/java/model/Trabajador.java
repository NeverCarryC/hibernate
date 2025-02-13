package model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "trabajadores")

@NamedQueries(
        {
@NamedQuery(name = "Trabajador.findAll", query="FROM Trabajador"),
@NamedQuery(name = "Trabajador.findByLocalidad", query = "From Trabajador WHERE direccion.localidad = :localidad"),
                @NamedQuery(
                        name = "Trabajador.findNombreCorreo",
                        query = "SELECT t.nombre, t.correo FROM Trabajador t WHERE t.direccion.localidad = :localidad"
                )
})

public class Trabajador implements Serializable {

    //pk
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private String correo;

    @Column
    private int telefono;


    @Embedded
    private Direccion direccion;

    public Trabajador(String nombre, String apellido, String correo, int telefono, Direccion dir) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = dir;
    }

    public Trabajador(){}

    @Override
    public String toString() {
        return "Trabajador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono=" + telefono +
                ", direccion=" + direccion +
                '}';
    }

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
