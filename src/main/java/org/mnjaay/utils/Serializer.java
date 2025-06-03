package org.mnjaay.utils;

import org.mnjaay.entities.Users;

import java.io.*;

public class Serializer {
    private final String SERIALIZATION_FILE_NAME = "users.ser";

    public void serializeUsers(Users users)
        throws IOException {
        try(FileOutputStream fos = new FileOutputStream(SERIALIZATION_FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){

            oos.writeObject(users);
        }
    }

    public Users deserializeUsers()
        throws IOException, ClassNotFoundException{

        try(FileInputStream fis = new FileInputStream(SERIALIZATION_FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis)) {

            return (Users) ois.readObject();
        }
    }
}
