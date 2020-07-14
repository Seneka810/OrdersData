package com.company.dao;

import com.company.entities.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class OrderDAO implements DAO<Order> {

    public void saveOrders(int client_id, int product_id, Connection conn) throws SQLException {

        String number = UUID.randomUUID().toString().substring(0, 16);

        try (PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO Orders(number_of_order, id_clients, id_products) VALUES (?, ?, ?)")) {

            ps.setString(1, number);
            ps.setInt(2, client_id);
            ps.setInt(3, product_id);

            ps.executeUpdate();

        }
    }

    public List<Order> getAll() {
        return null;
    }

    @Override
    public int getIdByName(String name, Connection conn) throws SQLException {
        return 0;
    }
}
