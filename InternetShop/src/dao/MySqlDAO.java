package dao;

import entities.Employee;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utilities.HibernateUtil;

import javax.persistence.Entity;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySqlDAO <T> implements DAO {

    private SessionFactory factory;

    public MySqlDAO() {
        factory = HibernateUtil.getFactory();
    }

    @Override
    public <T> Long create(T entity) {

        Session session = factory.openSession();
        session.beginTransaction();
         Long id = (Long) session.save(entity);
         session.getTransaction().commit();
         session.close();
        return id;
    }

    @Override
    public <T> Boolean update(T entity) {

        Session session = factory.openSession();

        session.beginTransaction();

        session.update(entity);

        session.getTransaction().commit();
        return true;
    }

    @Override
    public <T> Boolean delete(T entity) {

        Session session = factory.openSession();
        session.beginTransaction();

        session.delete(entity);
        session.getTransaction().commit();

        return true;
    }

    @Override
    public <T> T read(Long id) {

        Session session = factory.openSession();

        session.beginTransaction();
        //todo Ми тут використовуємо Generic для того щоб узагальнити тип з яким ми будемо працювати
        //empl = (Employee)session.load(Employee.class, id);
        T empl = session.load((Class<T>)getClass(), id);
        Hibernate.initialize(empl);



        session.getTransaction().commit();


        return  (T) empl;
    }

    @Override
    public <T> List<T> readByQuery(String query, Parameters params) {
        String key = null;
        Object value = null;
        Session session = factory.openSession();

        session.beginTransaction();
        Query q = session.createQuery(query);
        for (Map.Entry<String, Object> e : params.getParameters().entrySet()) {
            q.setParameter(e.getKey(), e.getValue());
        }
        List<T> results = q.list();
        session.getTransaction().commit();
        session.close();


        return results;
    }
}
