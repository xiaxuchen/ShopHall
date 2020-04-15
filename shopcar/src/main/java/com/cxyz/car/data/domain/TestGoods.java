package com.cxyz.car.data.domain;

public class TestGoods {
    private String imageSrc;
    private String desc;

    public TestGoods(String imageSrc, String desc) {
        this.imageSrc = imageSrc;
        this.desc = desc;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
