package dao;

import model.Trabajador;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import utils.HibernateUtils;

import java.sql.SQLIntegrityConstraintViolationException;

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
    public void obtenerUsuario(int id){
        session = new HibernateUtils().getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Trabajador trabajador = session.get(Trabajador.class,id);
        System.out.println(trabajador);
        transaction.commit();
        session.close();
    }

    // UPDATE
    public void actualizarUsuario(int id){
        // UPDATE usuarios SET correo = nuevo@ue.com AND apellidoNuevo WHERE id = id
        session = new HibernateUtils().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        // Buscar el usuario
        Trabajador trabajador = session.get(Trabajador.class,id);
        if&*

        session.getTransaction().commit();
        session.close();
    }

}
