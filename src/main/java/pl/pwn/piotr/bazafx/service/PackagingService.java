package pl.pwn.piotr.bazafx.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.pwn.piotr.bazafx.model.Bottle;
import pl.pwn.piotr.bazafx.model.Packaging;
import pl.pwn.piotr.bazafx.utils.HibernateUtils;

import java.util.List;

public class PackagingService {

    public List<Packaging> getAllPAckaging() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<Packaging> packagings = session.createQuery("Select p FROM Packaging p").list();

        transaction.commit();
        session.close();
        return packagings;
    }

}
