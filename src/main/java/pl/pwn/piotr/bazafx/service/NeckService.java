package pl.pwn.piotr.bazafx.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.pwn.piotr.bazafx.model.Machine;
import pl.pwn.piotr.bazafx.model.Neck;
import pl.pwn.piotr.bazafx.utils.HibernateUtils;

import java.util.List;

public class NeckService {

    public List<Neck> getAllNecks() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<Neck> necks = session.createQuery("Select n FROM Neck n").list();

        transaction.commit();
        session.close();
        return necks;
    }

    public List<String> getNeckForSelect() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction  transaction= session.beginTransaction();

        List<String> necksForSelect = session.createQuery("Select n.neck FROM Neck n ").list();

        transaction.commit();
        session.close();
        return necksForSelect;
    }

}
