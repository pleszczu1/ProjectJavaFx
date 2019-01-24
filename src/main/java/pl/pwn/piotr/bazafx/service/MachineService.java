package pl.pwn.piotr.bazafx.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.pwn.piotr.bazafx.model.Bottle;
import pl.pwn.piotr.bazafx.model.Machine;
import pl.pwn.piotr.bazafx.utils.HibernateUtils;

import java.util.List;

public class MachineService {

    public List<Machine> getAllMachines() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<Machine> machines = session.createQuery("Select m FROM Machine m").list();

        transaction.commit();
        session.close();
        return machines;
    }
}
