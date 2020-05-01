package com.cxyz.mine.ui.adapter.entity;

public class Filter {
    private String name;

    public Filter() {
    }

    public Filter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Filter{" +
                "name='" + name + '\'' +
                '}';
    }
}
