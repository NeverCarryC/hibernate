package dao;

import model.Habitacion;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.HibernateUtils;

import java.util.List;

public class HabitacionDAO {
    private static Session session;

    public Habitacion getHabitacionCapcidad(int capacidad) {
        session = new HibernateUtils().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<Habitacion> query = session.createQuery("FROM Habitacion h WHERE h.capacidad = :capacidad", Habitacion.class);
        query.setParameter("capacidad", capacidad);
        List<Habitacion> habitacionList = query.list();
        session.getTransaction().commit();
        session.close();
        if (!habitacionList.isEmpty()) {
            return habitacionList.getFirst();
        }
        return null;
    }

    public static void main(String[] args) {
        HabitacionDAO habitacionDAO = new HabitacionDAO();
        Habitacion h = habitacionDAO.getHabitacionCapcidad(5);
        System.out.println(h);
    }
}
