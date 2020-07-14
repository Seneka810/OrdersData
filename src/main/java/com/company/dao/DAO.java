package com.company.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {

    default void saveClients(String name, String city, String phone, Connection conn) throws SQLException {}

    default void saveOrders(int client_id, int product_id, Connection conn) throws SQLException {}

    default void saveProducts(Connection conn) throws SQLException {}

    List<T> getAll();

    int getIdByName(String name, Connection conn) throws SQLException;
}
