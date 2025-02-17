package controller;

import dao.HabitacionDAO;
import dao.TrabajadorDAO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import model.Habitacion;
import model.Trabajador;


@NoArgsConstructor
@AllArgsConstructor
public class HotelController {
    // LOGICA DEL NEGOCIO
    private HabitacionDAO habitacionDAO = new HabitacionDAO();
    private TrabajadorDAO trabajadorDAO = new TrabajadorDAO();


    public void asignarTrabajadorHabiatacion(int idTrabajador, int capacidad){
        Habitacion habitacion = habitacionDAO.getHabitacionCapcidad(capacidad);
        if (habitacion != null){
            System.out.println("Perfecto! tenemos habiataciones");
            Trabajador trabajador = trabajadorDAO.obtenerUsuario(idTrabajador);
            if(trabajador != null){
                System.out.println("Perfecto, tenemos trabajador. Vamos a asignar");
                trabajador.setHabitacion(habitacion);
                trabajadorDAO.actualizarUsuario(trabajador);
            }else{
                System.out.println("Mira el id porque no tengo ningun trabajador con ese id");
            }

        } else {
            System.out.println("No hay habitacion con esa capacidad");
        }
    }

    public void despedirTrabajador(int idTrabajador){


        trabajadorDAO.borrarUsuario(idTrabajador);
        // Puedes escribir código para enviar un correo después de eliminar a un trabajador.
        // generar documentacion
    }

    public static void main(String[] args) {

    }
}
