package pl.pwn.piotr.bazafx.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.pwn.piotr.bazafx.model.RawMaterial;
import pl.pwn.piotr.bazafx.utils.HibernateUtils;

import java.util.List;

public class RawMaterialService {


    public List<RawMaterial> getAllRawMaterials() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<RawMaterial> rawMaterials = session.createQuery("Select rm FROM RawMaterial rm").list();

        transaction.commit();
        session.close();
        return rawMaterials;
    }
}
