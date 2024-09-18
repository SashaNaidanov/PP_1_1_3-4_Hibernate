package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    private static final SessionFactory SESSION_FACTORY = Util.getSessionFactory();

    private static final String CREATE_TABLE = """
            CREATE TABLE IF NOT EXISTS users (
                    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(45) NOT NULL,
                    last_name VARCHAR(45) NOT NULL,
                    age TINYINT NOT NULL);
            """;

    private static final String DROP_TABLE = """
            DROP TABLE IF EXISTS users
            """;

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        try (Session session = SESSION_FACTORY.getCurrentSession()) {
            session.beginTransaction();
            session.createSQLQuery(CREATE_TABLE).executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void dropUsersTable() {
        try (Session session = SESSION_FACTORY.getCurrentSession()) {
            session.beginTransaction();
            session.createSQLQuery(DROP_TABLE).executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = SESSION_FACTORY.getCurrentSession()) {
            session.beginTransaction();
            User newUser = new User(name, lastName, age);
            session.save(newUser);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Session session = SESSION_FACTORY.getCurrentSession()) {
            session.beginTransaction();
            session.remove(session.get(User.class, id));
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = SESSION_FACTORY.getCurrentSession()) {
            session.beginTransaction();
            List<User> resultList = session.createQuery("SELECT i FROM User i").getResultList();
            session.getTransaction().commit();
            return resultList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = SESSION_FACTORY.getCurrentSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM User").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
