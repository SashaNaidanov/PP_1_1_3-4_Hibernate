package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService test = new UserServiceImpl();
        test.createUsersTable();
        test.saveUser("Sasha", "Naidanov", (byte) 22);
        test.saveUser("Sasha", "Naidanov", (byte) 22);
        test.saveUser("Sasha", "Naidanov", (byte) 22);
        test.saveUser("Sasha", "Naidanov", (byte) 22);
        for (User user : test.getAllUsers()) {
            System.out.println(user);
        }
        test.cleanUsersTable();
        test.dropUsersTable();
    }
}
