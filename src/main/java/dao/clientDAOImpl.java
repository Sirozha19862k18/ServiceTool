package dao;

import Models.Client;
import Models.Region;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class clientDAOImpl implements ClientDAO {

    //Показать всех клиентов в базе
    @Override
    public List<Client> showAllClients() {
       return null;

    }

    //Показать все области в базе
    @Override
    public List<Region> showAllRegions() {
        List<Region> region = (List<Region>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Region").list();
        return region;
    }

    @Override
    public void addNewClient(Client client) {

    }

    //Добавление области
    @Override
    public void addNewRegion(Region region) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(region);
        tx.commit();
        session.close();
    }

    //Поиск области
    @Override
    public List<Region> searchRegionByName(String regionName) {
        return null;
    }

    //Удаление области
    @Override
    public void deleteRegion(Region region) {
        Session session=HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(region);
        tx.commit();
        session.close();

    }

    //Удаление клиента
    @Override
    public void deleteClient(Client client) {

    }
}
