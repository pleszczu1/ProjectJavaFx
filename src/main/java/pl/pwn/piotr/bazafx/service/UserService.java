package pl.pwn.piotr.bazafx.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.pwn.piotr.bazafx.model.User;
import pl.pwn.piotr.bazafx.utils.HibernateUtils;

import java.util.List;

public class UserService {

    public List<User> getAllUser(){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<User> users = session.createQuery("SELECT u FROM User u").list();

        transaction.commit();
        session.close();
        return users;
    }

    public void save(User user){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(user);

        transaction.commit();
        session.close();

    }

    public User login(String login, String password){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT u FROM User u WHERE u.login=:login AND u.password=:pass AND active=1");
        query.setString("login", login);
        query.setString("pass", password);
        query.setMaxResults(1);
        User logedUser = (User) query.uniqueResult();

        transaction.commit();
        session.close();
        return logedUser;
    }

    public void delete(long id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("DELETE FROM User WHERE id=:id");
        query.setLong("id",id);
        query.executeUpdate();

        transaction.commit();
        session.close();
    }

    public void update(User user){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(user);

        transaction.commit();
        session.close();
    }


}
