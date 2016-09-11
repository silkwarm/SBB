package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractDAO<E> {
    SessionFactory sessions = new Configuration().configure().buildSessionFactory();

    public void add(E object) throws SQLException {
        Session session = sessions.openSession();
        try {
            session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void update(E object) throws SQLException {
        Session session = sessions.openSession();
        try {
            session.beginTransaction();
            session.update(object);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Set<E> getAll(E object) throws SQLException {
        Session session = sessions.openSession();
        Set<E> set = new HashSet<E>();
        try {
            set = (Set<E>) session.createCriteria(object.getClass()).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return set;
    }

    public void delete(E object) throws SQLException {
        Session session = sessions.openSession();
        try {
            session.beginTransaction();
            session.delete(object);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
