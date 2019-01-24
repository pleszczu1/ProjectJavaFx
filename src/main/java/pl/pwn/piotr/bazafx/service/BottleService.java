package pl.pwn.piotr.bazafx.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.pwn.piotr.bazafx.model.Bottle;
import pl.pwn.piotr.bazafx.utils.HibernateUtils;

import java.util.List;

public class BottleService {

    public List<Bottle> getAllBottles() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<Bottle> bottles = session.createQuery("Select b FROM Bottle b").list();

        transaction.commit();
        session.close();
        return bottles;
    }

}
