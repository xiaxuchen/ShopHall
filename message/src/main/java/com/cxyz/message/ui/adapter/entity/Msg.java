package com.cxyz.message.ui.adapter.entity;

import android.graphics.Bitmap;

public class Msg {
    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SENT = 1;
    private String content;
    private Bitmap bitmap;
    private int type;

    public Msg(String content,int type, Bitmap bitmap){
        this.content = content;
        this.type = type;
        this.bitmap=bitmap;
    }

    public String getContent(){
        return content;
    }
    public int getType(){
        return type;
    }
    public  Bitmap getBitmap(){return  bitmap;}

}
