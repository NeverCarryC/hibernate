import dao.TrabajadorDAO;
import model.Trabajador;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

        TrabajadorDAO trabajadorDAO = new TrabajadorDAO();
        trabajadorDAO.obtenerUsuario(1110);

    }

}
