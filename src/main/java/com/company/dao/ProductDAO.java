package com.company.dao;

import com.company.entities.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements DAO<Product> {
    private List<Product> products = new ArrayList<Product>();

    public ProductDAO() {
        products.add(new Product("Soccer ball", 1854));
        products.add(new Product("Volleyball", 632));
        products.add(new Product("Basketball", 790));
        products.add(new Product("Handball ball", 324));
        products.add(new Product("Tennis ball", 123));
        products.add(new Product("Rugby ball", 1020));
        products.add(new Product("Ball Hockey Balls", 554));
        products.add(new Product("Water polo ball", 498));
        products.add(new Product("Baseball ball", 120));
        products.add(new Product("Cricket ball", 990));
        products.add(new Product("Golf ball", 709));
        products.add(new Product("Plastic ball for table tennis", 40));
    }

    public void saveProducts(Connection conn) throws SQLException {

        try (PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO Products(name, price) VALUES (?, ?)")) {
            for (int i = 0; i < products.size(); i++) {
                ps.setString(1, products.get(i).getName());
                ps.setInt(2, products.get(i).getPrice());

                ps.executeUpdate();
            }
        }
    }

    public List<Product> getAll() {
        return products;
    }

    @Override
    public int getIdByName(String name, Connection conn) {
        return 0;
    }
}
