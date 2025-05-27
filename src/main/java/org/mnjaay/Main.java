package org.mnjaay;

import org.mnjaay.database.DBManger;

import javax.swing.*;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        try(Connection connection = DBManger.getConnection()) {
            JOptionPane.showMessageDialog(null, "Connexion à la base OK.");
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}