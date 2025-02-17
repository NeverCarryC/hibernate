package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries(
        {
                @NamedQuery(name = "Trabajador.findAll", query = "FROM Trabajador"),
                @NamedQuery(name = "Trabajador.findByLocalidad", query = "From Trabajador WHERE direccion.localidad = :localidad"),
                @NamedQuery(
                        name = "Trabajador.findNombreCorreo",
                        query = "SELECT t.nombre, t.correo FROM Trabajador t WHERE t.direccion.localidad = :localidad"
                )
        })


@Entity
@Table(name = "trabajadores")
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


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_habitacion")
    private Habitacion habitacion;


    @ManyToMany(mappedBy = "listaTrabajadores")
    private List<Cliente> listaClientes;

}
