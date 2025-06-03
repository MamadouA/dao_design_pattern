package org.mnjaay.runtime;

import org.mnjaay.entities.User;
import org.mnjaay.testeur.Tester;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Tester tester = new Tester();

        tester.createTeacher("Gislain", "Ackinocho");
    }

    public static void displayUsers(List<User> users) {
        for(User user : users) {
            System.out.println("\nIdentificant: " + user.getId() +
                    "\nLogin: " + user.getLogin() +
                    "\nPassword: " + user.getPassword());
        }
    }
}
