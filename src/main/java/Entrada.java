import model.Trabajador;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtils;

public class Entrada {

    public static void main(String[] args) {
        Trabajador trabajador = new Trabajador(123, "ni", "xx@gmail.com","nico");
        /**
         * session-> permite transaccionar contra la base de datos
         * beginTransaction
         * accion
         * commit
         */

        SessionFactory sessionFactory = new HibernateUtils().getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.persist(trabajador);
        session.getTransaction().commit();
        session.close();

    }

}
