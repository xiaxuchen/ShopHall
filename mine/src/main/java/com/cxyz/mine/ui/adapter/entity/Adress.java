package com.cxyz.mine.ui.adapter.entity;

public class Adress {
    //收货人
    private String name;
    //收货人电话
    private String phone;
    //收货人籍贯
    private String hometown;
    //收货人家庭具体地址
    private String home;

    public Adress(String name, String phone, String hometown, String home) {
        this.name = name;
        this.phone = phone;
        this.hometown = hometown;
        this.home = home;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", hometown='" + hometown + '\'' +
                ", home='" + home + '\'' +
                '}';
    }
}
