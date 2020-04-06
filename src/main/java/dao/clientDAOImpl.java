package dao;

import Models.Client;
import Models.Position;
import Models.Region;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class clientDAOImpl implements ClientDAO {

    //Показать всех клиентов в базе
    @Override
    public List<Client> showAllClients() {
       List<Client> client = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Client").list();
       return client;

    }

    //Показать все области в базе
    @Override
    public List<Region> showAllRegions() {
        List<Region> region = (List<Region>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Region").list();
        return region;
    }

    @Override
    public void addNewClient(Client client) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(client);
        tx.commit();
        session.close();
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
        return (List<Region>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Region WHERE regionName='"+regionName+"'").list();
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
        Session session=HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(client);
        tx.commit();
        session.close();
    }
}
