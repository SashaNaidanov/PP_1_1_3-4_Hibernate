package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    public void createUsersTable() {
        UserDaoJDBCImpl toRun = new UserDaoJDBCImpl();
        toRun.createUsersTable();
    }

    public void dropUsersTable() {
        UserDaoJDBCImpl toRun = new UserDaoJDBCImpl();
        toRun.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        UserDaoJDBCImpl toRun = new UserDaoJDBCImpl();
        toRun.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        UserDaoJDBCImpl toRun = new UserDaoJDBCImpl();
        toRun.removeUserById(id);
    }

    public List<User> getAllUsers() {
        UserDaoJDBCImpl toRun = new UserDaoJDBCImpl();
        return toRun.getAllUsers();
    }

    public void cleanUsersTable() {
        UserDaoJDBCImpl toRun = new UserDaoJDBCImpl();
        toRun.cleanUsersTable();
    }
}
