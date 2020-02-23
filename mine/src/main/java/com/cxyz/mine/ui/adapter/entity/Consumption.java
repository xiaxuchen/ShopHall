package com.cxyz.mine.ui.adapter.entity;

public class Consumption {
    private String data;
    private String money;

    public Consumption() {
    }

    public Consumption(String data, String money) {
        this.data = data;
        this.money = money;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Consumption{" +
                "data='" + data + '\'' +
                ", money='" + money + '\'' +
                '}';
    }
}
