package org.mnjaay.runtime;

import org.mnjaay.model.User;
import org.mnjaay.testeur.Tester;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Tester hibernateTester = new Tester();

//        hibernateTester.createUser("admin", "passer");
//        jdbcTesteur.deleteUser(1);

//        User user = jdbcTsteur.read(2);
//
//        // display and update
//        if(user != null) {
//            System.out.println("Login: " + user.getLogin()
//                    + "\nPassword: " + user.getPassword() + "\n");
//
//            user.setPassword("passer@123");
//
//            jdbcTesteur.updateUser(user);
//        }

        displayUsers(hibernateTester.listUsers());
    }

    public static void displayUsers(List<User> users) {
        for(User user : users) {
            System.out.println("\nIdentificant: " + user.getId() +
                    "\nLogin: " + user.getLogin() +
                    "\nPassword: " + user.getPassword());
        }
    }
}
