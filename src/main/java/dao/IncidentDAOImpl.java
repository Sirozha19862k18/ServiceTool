package dao;

import Models.Incident;
import Models.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class IncidentDAOImpl implements IncidentDAO {
    @Override
    public List<Incident> showAllIncident() {
         return (List<Incident>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Incident").list();
    }

    @Override
    public List<Product> showAllProduct() {
        return (List<Product>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Product").list();
    }

    @Override
    public void addProduct(Product product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(product);
        tx.commit();
        session.close();
    }

    @Override
    public void deleteProduct(Product product) {
        Session session=HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(product);
        tx.commit();
        session.close();
    }
}
