package pl.pwn.piotr.bazafx.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.pwn.piotr.bazafx.model.Neck;
import pl.pwn.piotr.bazafx.model.Squad;
import pl.pwn.piotr.bazafx.utils.HibernateUtils;

import java.util.List;

public class SquadService {

    public List<Squad> getAllSquads() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<Squad> squads = session.createQuery("Select s FROM Squad s").list();

        transaction.commit();
        session.close();
        return squads;
    }
}
