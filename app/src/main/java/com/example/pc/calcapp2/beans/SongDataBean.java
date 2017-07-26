package com.example.pc.calcapp2.beans;

import java.io.Serializable;

/**
 * Created by pc on 2017-07-06.
 */

public class SongDataBean implements Serializable {

    //자켓앨범이미지
    public  int photo;
    //노래 타이틀
    public  String title;
    //가수
    public  String author;
    //노래제목
    public  String time;
    //노래 ul
    public  String songUrl;

    public String getSongUrl() {
        return songUrl;
    }

    public void setSongUrl(String songUrl) {
        this.songUrl = songUrl;
    }

    //생성자
    public  SongDataBean(int photo, String title, String author, String time){
        this.photo = photo;
        this.title = title;
        this.author = author;
        this.time = time;
    }


    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
