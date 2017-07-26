package com.example.pc.calcapp2.beans;

/**
 * Created by pc on 2017-07-05.
 */

public class DataBean { //빈클래스를 만들어 데이터 관리
    private  int resImg;
    private  String imgText;

    public  DataBean(int resImg, String imgText){
        this.resImg = resImg;
        this.imgText = imgText;
    }

    public int getResImg() {
        return resImg;
    }

    public void setResImg(int resImg) {
        this.resImg = resImg;
    }

    public String getImgText() {
        return imgText;
    }

    public void setImgText(String imgText) {
        this.imgText = imgText;
    }
}
