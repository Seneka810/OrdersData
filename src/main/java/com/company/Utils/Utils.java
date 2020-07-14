package com.company.Utils;

import java.sql.*;
import java.util.Scanner;

public class Utils {
    public static void initDB(Connection conn) throws SQLException {
        try (Statement statement = conn.createStatement()) {
            statement.execute("DROP TABLE IF EXISTS Products");
            statement.execute("CREATE TABLE Products (" +
                    "id         INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    "name       VARCHAR(50) NOT NULL," +
                    "price      INT NOT NULL)");

            statement.execute("CREATE TABLE IF NOT EXISTS Clients(" +
                    "id       INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    "name     VARCHAR(50) NOT NULL," +
                    "city     VARCHAR(50) NOT NULL," +
                    "phone    VARCHAR(50) NOT NULL)");

            statement.execute("DROP TABLE IF EXISTS Orders");
            statement.execute("CREATE TABLE Orders (" +
                    "id                   INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    "number_of_order      VARCHAR(50) NOT NULL," +
                    "id_clients           INT NOT NULL," +
                    "id_products          INT NOT NULL)");
        }
    }

    public static void viewInfo(Scanner scanner, Connection conn) throws SQLException {
        System.out.println("To see all products press Enter: ");
        System.out.println("To see your orders enter 0: ");
        String s = scanner.nextLine();

        if ("0".equals(s)) {
            displayInfo("SELECT * FROM Orders", conn);
        } else if ("".equals(s)) {
            displayInfo("SELECT * FROM Products", conn);
        }
    }



    public static void displayInfo(String query, Connection conn) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            try (ResultSet rs = ps.executeQuery()) {
                ResultSetMetaData md = rs.getMetaData();

                for (int i = 1; i <= md.getColumnCount(); i++) {
                    System.out.print(md.getColumnName(i) + "\t\t");
                }

                System.out.println();

                while (rs.next()) {
                    for (int i = 1; i <= md.getColumnCount(); i++) {
                        System.out.print(rs.getString(i) + "\t\t");
                    }

                    System.out.println();
                }
            }
        }
    }
}
