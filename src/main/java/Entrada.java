import controller.HotelController;
import dao.HabitacionDAO;
import dao.TrabajadorDAO;
import model.Cliente;
import model.Direccion;
import model.Habitacion;
import model.Trabajador;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.dialect.StructAttributeValues;
import org.hibernate.exception.ConstraintViolationException;
import utils.HibernateUtils;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {


        // CASO: crear un trabajador
        // pedir datos al usuario y guardar el usuario en base de datos,
// pero si hay un fallo de correo, volver a intendarlo
//        Scanner sc = new Scanner(System.in);
//
//        TrabajadorDAO trabajadorDAO = new TrabajadorDAO();
//        String correo;
//        boolean fallo = false;
//        do{
//            try {
//                System.out.println("Introduce correo");
//                correo = sc.next();
//                trabajadorDAO.insertarTrabajador(new Trabajador(123456789,correo,"jack","Jack"));
//                fallo = false;
//            } catch (ConstraintViolationException e) {
//                System.out.println("correo duplicado, por favor intentalo de nuevo");
//                fallo = true;
//            }
//        }while(fallo);
//
//        System.out.println("Agregado correctamente");


        // CASO: buscar un trabajador por id
//        TrabajadorDAO trabajadorDAO = new TrabajadorDAO();
//        trabajadorDAO.obtenerUsuario(1110);

        // CASO: update
//        TrabajadorDAO trabajadorDAO = new TrabajadorDAO();
//       trabajadorDAO.actualizarUsuario(1);

        // CASO: borrar
//        TrabajadorDAO trabajadorDAO = new TrabajadorDAO();
//        trabajadorDAO.borrarUsuario(1);
        // trabajadorDAO.insertarTrabajador(new Trabajador("nico2","Nisd", "ssd",123456,new Direccion("Madrid","Madrid")));

        // CASO: query avanzado--findAll
//        TrabajadorDAO trabajadorDAO = new TrabajadorDAO();
//        trabajadorDAO.obtenerTodosTrabajadores();

        // CASO: query avanzado--anotation findAll
//        TrabajadorDAO trabajadorDAO = new TrabajadorDAO();
//        trabajadorDAO.obtenerTodosTrabajadoresNamed();

        // CASO: query avanzado-- SELECT * FROM trabajadores t WHERE t.localidad = Madrid
        // TrabajadorDAO trabajadorDAO = new TrabajadorDAO();
        // trabajadorDAO.obtenerTrabajadoresLocallidad("Toledo");


        // CASO: query avanzado--anotation SELECT * FROM trabajadores t WHERE t.localidad = Madrid
        // TrabajadorDAO trabajadorDAO = new TrabajadorDAO();
        // trabajadorDAO.obtenerTrabajadoresLocalidadNamed("Toledo");


        // CASO:  query avanzado-- SELECT t.nombre, t.correo FROM trabajadores t WHERE t.localidad = Madrid
        //TrabajadorDAO trabajadorDAO = new TrabajadorDAO();
        //trabajadorDAO.obtenerAlgunCampoLocallidad("Toledo");


        // CASO:  query avanzado--anotation SELECT t.nombre, t.correo FROM trabajadores t WHERE t.localidad = Madrid
        // TrabajadorDAO trabajadorDAO = new TrabajadorDAO();
        //trabajadorDAO.obtenerAlgunCampoLocallidadNamed("Madrid");

        // CASO: OneToOne-unidirecional
//        Session session = new HibernateUtils().getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//        Trabajador trabajador = session.get(Trabajador.class, 4);
//        if (trabajador != null) {
//            System.out.println("Su nombre es " + trabajador.getNombre());
//            System.out.println("Su habitacion es " + trabajador.getHabitacion().getNumero());
//        }
//        session.getTransaction().commit();
//        session.close();

        // CASO: OneToOne-bidireccional
//        Session session = new HibernateUtils().getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//
//        Habitacion habitacion = session.get(Habitacion.class, 3);
//        if (habitacion != null){
//            Trabajador trabajador = habitacion.getTrabajador();
//            System.out.println("El id del habitacion: " + habitacion.getId());
//            System.out.println("El nombre del trabajador: " + trabajador.getNombre());
//        }
//
//        session.getTransaction().commit();
//        session.close();


        // CASO: OneToMany-unidireccional
//        Session session = new HibernateUtils().getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//        Cliente cliente = session.get(Cliente.class,2);
//        if (cliente != null){
//            System.out.println("Cliente Nombre : " + cliente.getNombre());
//            System.out.println("Id Habitacion: " + cliente.getHabitacion().getId());
//        }
//        session.getTransaction().commit();
//        session.close();


        //CASO: OneToMany-bidireccional
//        Session session = new HibernateUtils().getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//
//        Habitacion habitacion = session.get(Habitacion.class,2);
//        System.out.println("Los clientes alojados en esta habitacion son:  ");
//        for (Cliente c : habitacion.getClientes()){
//            System.out.println(c.getNombre());
//
//        }
//        session.getTransaction().commit();
//        session.close();

        // CASO: ManyToMany-unidireccional
//        Session session = new HibernateUtils().getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//        System.out.println("Los trabajadores que han gestionado la reserva del cliente 1 son: ");
//        Cliente cliente = session.get(Cliente.class,1);
//        for (Trabajador trabajador : cliente.getListaTrabajadores()){
//            System.out.println(trabajador.getNombre());
//        }
//        session.getTransaction().commit();
//        session.close();


        // CASO: ManyToMany-bidireccional
//        Session session = new HibernateUtils().getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//
//        Trabajador trabajador = session.get(Trabajador.class,4);
//        System.out.println("Los clientes gestionado por trabajador 4:");
//        if (trabajador!=null){
//                for (Cliente c : trabajador.getListaClientes()){
//                    System.out.println(c.getNombre());
//                }
//        }
//        session.getTransaction().commit();
//        session.close();


        // CASO: ManyToMany-add
//        Session session = new HibernateUtils().getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//
//        Trabajador trabajador = session.get(Trabajador.class, 5);
//        Cliente cliente = session.get(Cliente.class,5);
//        trabajador.getListaClientes().add(cliente);
//        cliente.getListaTrabajadores().add(trabajador);
//        session.merge(cliente);
//        session.merge(trabajador);
//        session.getTransaction().commit();
//        session.close();

        // CASO: modificarTrabajador
//        TrabajadorDAO trabajadorDAO = new TrabajadorDAO();
//        trabajadorDAO.modificarTrabajador("nico@embfood.com","nuevonico@embfood.com");


        // CASO: asociar una habitacion con la capacidad que me digas el usuario a su perfil
        // ¿Cuantos sois?
        // 5
        // -> busca una habitacion de 5
        // -> asigna una habitacion de 5 al trabajador

        // CASO: buscar habiataciones por capacidad y asignarlos a una trabajador
//        HotelController hotelController = new HotelController();
//        System.out.println("De qué capacidad buscas la habitacion");
//        Scanner sc = new Scanner(System.in);
//        int capacidad = sc.nextInt();
//        System.out.println("De que trabajador quiere asignar?");
//        int idTrabajador = sc.nextInt();
//        hotelController.asignarTrabajadorHabiatacion(idTrabajador,capacidad);

        // CASO: Borrar
        System.out.println("De que trabajador quieres despedir");
        Scanner sc = new Scanner(System.in);
        int idBorrar = sc.nextInt();
        HotelController hotelController = new HotelController();
        hotelController.despedirTrabajador(idBorrar);
    }

}
