package org.mnjaay.utils;

import org.mnjaay.model.User;
import org.mnjaay.model.Users;

import java.io.*;

public class SerializableManager {

    public void serializeSingleUser(String userFilename, User user) {
        // - Serialization
        try(FileOutputStream fos = new FileOutputStream(userFilename);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(user);
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public User deserializeSingleUser(String userFilename) {
        // - Deserialization
        try(FileInputStream fis = new FileInputStream(userFilename);
            ObjectInputStream ois = new ObjectInputStream(fis)) {

            return (User) ois.readObject();
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        catch (ClassNotFoundException e) {
            System.out.println("User class not found: " + e.getMessage());
        }

        return null;
    }

    public void serializeUsersList(String usersFilename, Users users)
        throws IOException {
        try(FileOutputStream fos = new FileOutputStream(usersFilename);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){

            oos.writeObject(users);
        }
    }

    public Users deserializeUsersList(String usersFilename)
        throws IOException, ClassNotFoundException{

        try(FileInputStream fis = new FileInputStream(usersFilename);
            ObjectInputStream ois = new ObjectInputStream(fis)) {

            return (Users) ois.readObject();
        }
    }
}
