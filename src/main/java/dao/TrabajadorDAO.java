package dao;

import model.Trabajador;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import utils.HibernateUtils;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class TrabajadorDAO {
    private Session session;

    // CREATE
    public void insertarTrabajador(Trabajador trabajador) throws ConstraintViolationException {
        // crear la session
        session = new HibernateUtils().getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.persist(trabajador);
        transaction.commit();
        session.close();
    }

    // SELECT
    public Trabajador obtenerUsuario(int id){
        session = new HibernateUtils().getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Trabajador trabajador = session.get(Trabajador.class,id);
        transaction.commit();
        session.close();
        return trabajador;
    }

    // UPDATE
    public void actualizarUsuario(int id){
        // UPDATE usuarios SET correo = nuevo@ue.com AND apellidoNuevo WHERE id = id
        session = new HibernateUtils().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        // Buscar el usuario
        Trabajador trabajador = session.get(Trabajador.class,id);
        if(trabajador != null){
            trabajador.setApellido("NuevoApellido");
            trabajador.setCorreo("nuevo@gmail.com");
            session.merge(trabajador);
        }

        session.getTransaction().commit();
        session.close();
    }

    public void actualizarUsuario(Trabajador trabajador){
        session = new HibernateUtils().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.merge(trabajador);
        session.getTransaction().commit();
        session.close();
    }

    // BORRAR
    public void borrarUsuario(int id){
        session = new HibernateUtils().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        // borrar
        Trabajador trabajador = session.get(Trabajador.class,id);

        if (trabajador != null){
            session.remove(trabajador);
        }
        session.getTransaction().commit();
        session.close();
    }

    // QUERY ALL DATOS
    public void obtenerTodosTrabajadores(){
        session = new HibernateUtils().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        // prepareST -> resulset -> while -> rs.getString -> creaObjeto -> List

        Query<Trabajador> query = session.createQuery("FROM Trabajador",Trabajador.class );
        List<Trabajador> lista = query.list();
        for (Trabajador t : lista){
            System.out.println(t);
        }
        session.getTransaction().commit();
        session.close();
    }
    // QUERY ALL DATOS BY NamedQuery
    public void obtenerTodosTrabajadoresNamed(){
        session = new HibernateUtils().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query<Trabajador> query = session.createNamedQuery("Trabajador.findAll", Trabajador.class);
        List<Trabajador> list = query.list();
        for (Trabajador t : list){
            System.out.println(t);
        }
        session.getTransaction().commit();
        session.close();
    }
    // QUERY CON PARAMETRO(FILTRO POR PARAMETRO)
    public void obtenerTrabajadoresLocallidad(String localidad){
        session = new HibernateUtils().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        // String querySTR = "FROM Trabajador t WHERE t.direccion.localidad=:localidad";
        String querySTR = "SELECT t FROM Trabajador t WHERE t.direccion.localidad=:localidad";
        Query<Trabajador> query = session.createQuery(querySTR,Trabajador.class);
        query.setParameter("localidad", localidad);
        List<Trabajador> trabajadors = query.list();

        for (Trabajador t : trabajadors)
        {
            System.out.println(t);
        }
        session.getTransaction().commit();
        session.close();
    }
    // QUERY CON PARAMETRO NamedQuery
    public void obtenerTrabajadoresLocalidadNamed(String localidad){
        session = new HibernateUtils().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        // String querySTR = "FROM Trabajador t WHERE t.direccion.localidad=:localidad";
       //  String querySTR = "SELECT t FROM Trabajador t WHERE t.direccion.localidad=:localidad";
        // Query<Trabajador> query = session.createQuery(querySTR,Trabajador.class);


        Query<Trabajador> query = session.createNamedQuery("Trabajador.findByLocalidad", Trabajador.class);
        query.setParameter("localidad", localidad);
        List<Trabajador> trabajadors = query.list();

        for (Trabajador t : trabajadors)
        {
            System.out.println(t);
        }
        session.getTransaction().commit();
        session.close();
    }


    // QUERY SOME COLUMNS BY PARAMETRO
    public void obtenerAlgunCampoLocallidad(String localidad){
        session = new HibernateUtils().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        String querySTR = "SELECT t.nombre, t.correo FROM Trabajador t  WHERE t.direccion.localidad=:localidad";
        Query<Object[]> query = session.createQuery(querySTR, Object[].class);
        query.setParameter("localidad", localidad);
        List<Object[]> resultados = query.list();

        for (Object[] fila : resultados) {
            System.out.println("Nombre: " + fila[0] + ", Correo: " + fila[1]);
        }

        session.getTransaction().commit();
        session.close();
    }
    // QUERY SOME COLUMNS BY PARAMETRO NamedQuery
    public void obtenerAlgunCampoLocallidadNamed(String localidad){
        session = new HibernateUtils().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        // String querySTR = "SELECT t.nombre, t.correo FROM Trabajador t  WHERE t.direccion.localidad=:localidad";
        Query<Object[]> query = session.createNamedQuery("Trabajador.findNombreCorreo", Object[].class);
        query.setParameter("localidad", localidad);
        List<Object[]> resultados = query.list();

        for (Object[] fila : resultados) {
            System.out.println("Nombre: " + fila[0] + ", Correo: " + fila[1]);
        }

        session.getTransaction().commit();
        session.close();
    }
    // QUERY BY PARAMETRO AND UPDATE
    public void modificarTrabajador(String correoOld, String correoNew){
        session = new HibernateUtils().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        String query = "FROM Trabajador t WHERE t.correo = :correo";
        Query<Trabajador> trabajadorQuery = session.createQuery(query, Trabajador.class);
        trabajadorQuery.setParameter("correo", correoOld);
        List<Trabajador> trabajadorList = trabajadorQuery.list();
        Trabajador trabajador = trabajadorList.get(0);
        trabajador.setCorreo(correoNew);
        session.merge(trabajador);

        session.getTransaction().commit();
        session.close();

    }

}
