package org.mnjaay;

import org.mnjaay.model.User;
import org.mnjaay.testeur.ObjectFileTesteur;

import java.util.List;

public class ObjectFileTesterRuntime {
    public static void main(String[] args) {
        ObjectFileTesteur objectFileTesteur = new ObjectFileTesteur();

        objectFileTesteur.createUser("Ibrahima", "passer@123");
//
//
//        User user = objectFileTesteur.readUser(6);
//        if(user != null)
//            System.out.println("login: " + user.getLogin() + " Password: " + user.getPassword());
//

//        System.out.println("Deleting user 1");
//         objectFileTesteur.deleteUser(1);

        displayUsers(objectFileTesteur.listerUsers());
    }

    public static void displayUsers(List<User> users) {
        for(User user : users) {
            System.out.println("\nIdentificant: " + user.getId() +
                    "\nLogin: " + user.getLogin() +
                    "\nPassword: " + user.getPassword());
        }
    }
}
