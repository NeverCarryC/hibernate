package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nombre;
    @Column
    private String correo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_habitacion")
    private Habitacion habitacion;

    public Cliente(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }
}
