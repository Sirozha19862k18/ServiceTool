package dao;

import Models.Employer;
import Models.Position;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import java.util.List;


public class EmployerDAOImpl implements EmployerDAO {

    @Override
    public List<Employer> showAllEmployers(){
        List<Employer> employers = (List<Employer>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Employer").list();
        return employers;
    }

    @Override
    public List<Position> showAllPosition() {
        List<Position> position = (List<Position>)HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Position").list();
        return position;
    }

    //Добавление новой профессии
    @Override
    public void addNewPosition(Position position) {
       Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
       Transaction tx = session.beginTransaction();
       session.save(position);
       tx.commit();
       session.close();
    }

    //Добавление нового работника
    @Override
    public void addNewEmployer(Employer employer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(employer);
        tx.commit();
        session.close();
    }

    @Override
    public List<Position> searchPositionByName(String positionName) {
        return (List<Position>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Position WHERE position='"+positionName+"'").list();

    }

    /*Удаление профессии*/
    @Override
    public void deletePosition(Position position) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(position);
        tx.commit();
        session.close();

    }

    //Удаление рпботника из базы
    @Override
    public void deleteEmployer(Employer employer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(employer);
        tx.commit();
        session.close();
    }


}
