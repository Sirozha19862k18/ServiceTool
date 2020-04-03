package dao;

import Models.Client;
import Models.Position;
import Models.Region;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class clientDAOImpl implements ClientDAO {
    @Override
    public List<Client> showAllClients() {
       return null;

    }

    @Override
    public List<Region> showAllRegions() {
        List<Region> region = (List<Region>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Region").list();
        return region;
    }

    @Override
    public void addNewClient(Client client) {

    }

    @Override
    public void addNewRegion(Region region) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(region);
        tx.commit();
        session.close();
    }

    @Override
    public List<Region> searchRegionByName(String regionName) {
        return null;
    }

    @Override
    public void deleteRegion(Region region) {
        Session session=HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(region);
        tx.commit();
        session.close();

    }

    @Override
    public void deleteClient(Client client) {

    }
}
