package db.util;

import com.fasterxml.classmate.AnnotationConfiguration;
import db.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {

        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        } catch(Throwable ex) {
            // Make sure you log the exception, as it might get swallowed
            System.err.println("Initial SessionFactory creation failed " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getUserSession() {
        try {
            SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(User.class).buildSessionFactory();
            return sessionFactory.openSession();
        } catch (HibernateException ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}