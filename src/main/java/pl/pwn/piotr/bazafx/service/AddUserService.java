package pl.pwn.piotr.bazafx.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.pwn.piotr.bazafx.model.User;
import pl.pwn.piotr.bazafx.utils.HibernateUtils;

public class AddUserService {

    public long save(User user) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        long id = (Long) session.save(user);

        transaction.commit();
        session.close();
        return  id;
    }
}
