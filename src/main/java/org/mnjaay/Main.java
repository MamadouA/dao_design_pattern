package org.mnjaay;

import org.mnjaay.model.User;
import org.mnjaay.model.Users;
import org.mnjaay.testeur.JDBCTesteur;
import org.mnjaay.testeur.ObjectFileTesteur;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        JDBCTesteur jdbcTesteur = new JDBCTesteur();
        Users users = new Users();
//
//          jdbcTesteur.createUser("admin", "passer");
//         jdbcTesteur.createUser("mnjaay", "mamadou");
//        jdbcTesteur.deleteUser(1);
//
//        User user = jdbcTesteur.read(2);
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
//
         users.setUsers(jdbcTesteur.listUsers());

        displayUsers(users.getUsers());

        // -
        ObjectFileTesteur objectFileTesteur = new ObjectFileTesteur();

        //objectFileTesteur.createUsers(users);

        List<Users> usersList = objectFileTesteur.listUsers();

        displayUsers(usersList.getFirst().getUsers());
    }



    public static void displayUsers(List<User> users) {
        for(User user : users) {
            System.out.println("\nIdentificant: " + user.getId() +
                    "\nLogin: " + user.getLogin() +
                    "\nPassword: " + user.getPassword());
        }
    }
}