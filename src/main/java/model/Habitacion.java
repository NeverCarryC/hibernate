package model;

import dao.HabitacionDAO;
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


@Table(name = "habitaciones")
@Entity
public class Habitacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int planta;


    @Column
    private int numero;
    @Column
    private int capacidad;

    @OneToOne(mappedBy = "habitacion",cascade = CascadeType.ALL)
    private Trabajador trabajador;

    public Habitacion(int planta, int numero, int capacidad) {
        this.planta = planta;
        this.numero = numero;
        this.capacidad = capacidad;
    }

}
