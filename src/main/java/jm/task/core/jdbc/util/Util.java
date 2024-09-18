package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class Util {

    private static final String URL = "jdbc:mysql://localhost:3306/jdbc";

    private static final String USERNAME = "root";

    private static final String PASSWORD = "root";

    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

    private static final String DIALECT = "org.hibernate.dialect.MySQLDialect";

    private static final String CURRENT_SESSION_CONTEXT_CLASS = "thread";

    private Util() {

    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        Properties properties = new Properties();
        properties.setProperty(Environment.DRIVER, DRIVER_CLASS);
        properties.setProperty(Environment.URL, URL);
        properties.setProperty(Environment.USER, USERNAME);
        properties.setProperty(Environment.PASS, PASSWORD);
        properties.setProperty(Environment.DIALECT, DIALECT);
        properties.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, CURRENT_SESSION_CONTEXT_CLASS);
        Configuration configuration = new Configuration();
        configuration.addProperties(properties).addAnnotatedClass(User.class);
        try {
            return configuration.buildSessionFactory();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
