package dao;

import Models.Incident;
import Models.Product;
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
}
