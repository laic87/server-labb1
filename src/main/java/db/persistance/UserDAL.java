package db.persistance;

import db.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import db.entity.User;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class UserDAL {

    private static final String GET_ALL_USERS = "SELECT u FROM User u.username";
    private static final String FIND_USER_BY_ID = "SELECT u FROM User u WHERE u.id =:" + UserDAL.PARAMETER_ID;
    private static final String FIND_USER_BY_USERNAME = "SELECT u FROM User u WHERE u.username =:" + UserDAL.PARAMETER_USERNAME;
    private static final String FIND_USER_BY_USERNAME_AND_PASSWORD = "SELECT u FROM User u WHERE u.username =:" + UserDAL.PARAMETER_USERNAME + " AND u.password =:" + UserDAL.PARAMETER_PASSWORD;

    private static final String PARAMETER_ID = "id";
    private static final String PARAMETER_USERNAME = "username";
    private static final String PARAMETER_PASSWORD = "password";

    public static boolean loginUser(String username, String password) {
        Session session = HibernateUtil.getUserSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery(FIND_USER_BY_USERNAME_AND_PASSWORD);
            query.setParameter(PARAMETER_USERNAME, username);
            query.setParameter(PARAMETER_PASSWORD, password);
            Object result = query.uniqueResult();
            System.out.println("RESULT: " + result != null);
            //User result = (User) query.uniqueResult();
            transaction.commit();
            return result != null;
        } catch (HibernateException e) {
            System.out.println("EXCEPTIOM");

            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        } finally {
            session.close();
        }
    }

    //Create a user
    public static boolean createUser(User user) {
        Session session = HibernateUtil.getUserSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        } finally {
            session.close();
        }
    }

    //Get a user, by id
    public static User getUser(int id) {
        Session session = HibernateUtil.getUserSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            Query query = session.createQuery(FIND_USER_BY_ID);
            query.setParameter(PARAMETER_ID, id);
            User result = (User) query.uniqueResult();

            transaction.commit();

            return result;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        } finally {
            session.close();
        }
    }

    //Get a user, by username
    public static User getUser(String username) {
        Session session = HibernateUtil.getUserSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            Query query = session.createQuery(FIND_USER_BY_USERNAME);
            query.setParameter(PARAMETER_USERNAME, username);
            User result = (User) query.uniqueResult();

            transaction.commit();

            return result;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        } finally {
            session.close();
        }
    }

    // Get all users
    public static List<User> getAllUsers() {
        Session session = HibernateUtil.getUserSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            Query query = session.createQuery(GET_ALL_USERS);
            List<User> resultList = query.list();

            transaction.commit();

            return resultList;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        } finally {
            session.close();
        }
    }

}
