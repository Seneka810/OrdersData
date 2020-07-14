package com.company.entities;

public class Order {
    private int id;
    private int number_of_order;
    private int id_clients;
    private int id_products;

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber_of_order() {
        return number_of_order;
    }

    public void setNumber_of_order(int number_of_order) {
        this.number_of_order = number_of_order;
    }

    public int getId_clients() {
        return id_clients;
    }

    public void setId_clients(int id_clients) {
        this.id_clients = id_clients;
    }

    public int getId_products() {
        return id_products;
    }

    public void setId_products(int id_products) {
        this.id_products = id_products;
    }
}
