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

    public MySqlDAO(SessionFactory factory) {
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

        Object empl = null;
        session.beginTransaction();

        empl = session.load(Employee.class, id);
        Hibernate.initialize(empl);



        session.getTransaction().commit();


        return  (T) empl;
    }

    @Override
    public <T> List<T> readByQuery(String query, Parameters params)
    {
        String key = null ;
        Object value = null ;
        Session session = factory.openSession();

        session.beginTransaction();


         //    Map < String, Object> hashmap = new HashMap<String, Object>((Map<? extends String, ?>) params);

       for (Map.Entry<String , Object> e : params.getParameters().entrySet()) {
           key = e.getKey();
           value = e.getValue();
       }


        List results = session.createQuery(query).setParameter(key,value).list();
       session.close();




        return results;
    }
}
