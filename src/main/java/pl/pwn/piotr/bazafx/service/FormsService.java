package pl.pwn.piotr.bazafx.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.pwn.piotr.bazafx.model.Bottle;
import pl.pwn.piotr.bazafx.model.Forms;
import pl.pwn.piotr.bazafx.utils.HibernateUtils;

import java.util.List;

public class FormsService {

    public List<Forms> getAllForms() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<Forms> forms = session.createQuery("Select f FROM Forms f").list();

        transaction.commit();
        session.close();
        return forms;
    }

}
