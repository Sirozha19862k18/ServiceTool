package utils;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil(){

    }

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null){
            try{
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Models.Employer.class);
                configuration.addAnnotatedClass(Models.Position.class);
                configuration.addAnnotatedClass(Models.Region.class);
                configuration.addAnnotatedClass(Models.Client.class);
                configuration.addAnnotatedClass(Models.Product.class);
                configuration.addAnnotatedClass(Models.Incident.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (HibernateException e) {
                System.out.println("Исключение" + e);
            }

        }
        return sessionFactory;
    }

}
