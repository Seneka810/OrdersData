package com.company;

import com.company.Utils.DbProperties;
import com.company.Utils.Utils;
import com.company.dao.ClientDAO;
import com.company.dao.DAO;
import com.company.dao.OrderDAO;
import com.company.dao.ProductDAO;
import com.company.entities.Client;
import com.company.entities.Order;
import com.company.entities.Product;

import java.sql.*;
import java.util.Scanner;

public class Main {
    private static Connection conn;

    public static void main(String[] args) {
        DbProperties properties = new DbProperties();
        DAO<Product> products = new ProductDAO();
        DAO<Client> clients = new ClientDAO();
        DAO<Order> orders = new OrderDAO();
        Scanner scanner = new Scanner(System.in);
        String s;

        try {
            conn = DriverManager.getConnection(properties.getUrl(),
                    properties.getUser(),
                    properties.getPassword());

            Utils.initDB(conn);
            products.saveProducts(conn);

            System.out.println("Enter your name: ");
            String name = scanner.nextLine();
            System.out.println("Enter your city: ");
            String city = scanner.nextLine();
            System.out.println("Enter your phone: ");
            String phone = scanner.nextLine();
            clients.saveClients(name, city, phone, conn);

            do {
                Utils.viewInfo(scanner, conn);
                System.out.println();
                System.out.println("To make order enter number of id: ");
                System.out.println("To confirm your order press Enter: ");
                s = scanner.nextLine();
                try {
                    int client_id = clients.getIdByName(name, conn);
                    int product_id = Integer.parseInt(s);
                    orders.saveOrders(client_id, product_id, conn);
                } catch (Exception e) {
                    System.out.println("Orders complete");
                }
            } while (!"".equals(s));

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

