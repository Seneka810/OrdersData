package com.company.dao;

import com.company.entities.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO implements DAO<Client> {

    public void saveClients(String name, String city, String phone, Connection conn) throws SQLException {

        try (PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO Clients(name, city, phone) VALUES (?, ?, ?)")) {

            ps.setString(1, name);
            ps.setString(2, city);
            ps.setString(3, phone);

            ps.executeUpdate();

        }
    }

    public int getIdByName(String name, Connection conn) throws SQLException {
        int client_id = 0;

        try (PreparedStatement ps = conn.prepareStatement(
                "SELECT id FROM Clients WHERE name = ?")) {
            ps.setString(1, name);

            try (ResultSet rs = ps.executeQuery()) {
                if(rs.next()) {
                    client_id = rs.getInt(1);
                }
            }

        }
        return client_id;
    }

    public List<Client> getAll() {
        return null;
    }
}
