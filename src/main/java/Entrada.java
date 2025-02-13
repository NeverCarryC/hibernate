import dao.TrabajadorDAO;
import model.Direccion;
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
        TrabajadorDAO trabajadorDAO = new TrabajadorDAO();
        trabajadorDAO.obtenerAlgunCampoLocallidadNamed("Madrid");
    }

}
