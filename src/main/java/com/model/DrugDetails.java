package com.model;

/**
 * Created by kevin on 17-3-6.
 */
public class DrugDetails {
    //{"id":"56","name":"安药 抗病毒口服液","price":"12.0","total":"1"}
    private int id;
    private String name;
    private double price;
    private int total;

    public DrugDetails(int id , String name, double price, int total){
        this.id = id;
        this.name = name;
        this.price = price;
        this.total = total;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }





}
