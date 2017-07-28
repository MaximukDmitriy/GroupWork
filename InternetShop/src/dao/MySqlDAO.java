package dao;

import entities.Employee;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utilities.HibernateUtil;

import java.util.List;

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

        empl = (Employee)session.load(Employee.class, id);
        Hibernate.initialize(empl);



        session.getTransaction().commit();


        return  T empl;
    }

    @Override
    public <T> List<T> readByQuery(String query, Parameters params)
    {
        Session session = factory.openSession();

        session.beginTransaction();

        query = " FROM entities.User U name =:name," +
               "surname =:surname," +
               "age =: age," +
               "dateBegin =: dateBegin," +
               "position =: position where id =:id";

       Query query1 = session.createQuery(query);
       List results = query1.list();


        return results;
    }
}
