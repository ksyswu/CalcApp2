package com.example.pc.calcapp2;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.pc.calcapp2.adapter.ListViewAdapter;
import com.example.pc.calcapp2.beans.SongDataBean;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends CommonActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ImageView imgJacket = (ImageView)findViewById(R.id.imgJaket);

        ListView listView = (ListView)findViewById(R.id.listView);

        //Notification
        imgJacket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exeNoti();
            }
        });


        //1. 데이터 생성
        SongDataBean song1 = new SongDataBean(R.drawable.img1,"노래제목 1","가수1", "1:30");
        song1.setSongUrl("<iframe width=\"400\" height=\"280\" src=\"https://www.youtube.com/embed/msok__h_3QY\" frameborder=\"0\" allowfullscreen></iframe>");
        SongDataBean song2 = new SongDataBean(R.drawable.img2,"노래제목 2","가수2", "1:30");
        song2.setSongUrl("<iframe width=\"400\" height=\"280\" src=\"https://m.naver.com\" frameborder=\"0\" allowfullscreen></iframe>");
        SongDataBean song3 = new SongDataBean(R.drawable.img3,"노래제목 3","가수3", "1:30");
        song3.setSongUrl("<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/VITVlI80qgs\" frameborder=\"0\" allowfullscreen></iframe>");
        SongDataBean song4 = new SongDataBean(R.drawable.img4,"노래제목 4","가수4", "1:30");
        song4.setSongUrl("<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/fPlciv1KYMs\" frameborder=\"0\" allowfullscreen></iframe>");
        SongDataBean song5 = new SongDataBean(R.mipmap.ic_launcher,"노래제목 5","가수5", "1:30");


        List<SongDataBean> list  = new ArrayList<SongDataBean>();
        list.add(song1);
        list.add(song2);
        list.add(song3);
        list.add(song4);
        list.add(song5);

        //2. 위 만든 데이터를 포함한 Adapter를 생성한다.

        ListViewAdapter adapter = new ListViewAdapter(this, list);

        //3. ListView에 Adapter를 끼운다.
        listView.setAdapter(adapter);
    };//end onCreate()

    //노티를 실행한다.
    public void exeNoti(){
        NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        Notification noti = null;
        Notification.Builder builder = new Notification.Builder(this);

        //노티를 클릭했을때 이동하는 곳을 지정한다.
        Intent intent = new Intent(this, SongDetailActivity.class);//this 액티비티를 의미 즉 가고싶은 해당 액티비티 지정
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP );
               //FLAG_ACTIVITY_CLEAR_TOP 플래그를 줌으로써 새로운 액티비티를 부를때 스택으로 쌓이는데 이때 새로운 액티비티를 호출할때 아래에 쌓여있다면 아래에 있던 것은 사라지고 새롭게 위로 호출하는 것
                //sing_top은 액티비티, 객체가 하나인것 즉 계속해서 같은것이 생성되는데 사라지는것이 아닌 위치가 바뀌는 것

        //펜딩인텐트가 인텐트를 포함함
        //Notification 객체에서 사용하는 Intent가 PendgingIntent이다.
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent,
                                    PendingIntent.FLAG_UPDATE_CURRENT);
        //그림하고 같이 띄우기
        builder.setContentTitle(getString(R.string.noti_title));
        builder.setContentText(getString(R.string.noti_msg));
        builder.setSmallIcon(R.mipmap.ic_launcher_round);
        builder.setTicker("Ticker");
        builder.setContentIntent(pendingIntent); //intent의 경로설정으로 인해 이동이 가능하다////////////?

        //drawable에 있는 이미지를 bitmap 객체로 변경한다.
        Bitmap bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.img1);


        noti = new Notification.BigPictureStyle(builder)
                .bigPicture(bmp1)
                .setBigContentTitle("Big Content Title")
                .setSummaryText("Bing Picture Summary Text")
                .build();
        //진동패턴
        long pattern[] = {500, 500, 500, 500, 500, 500, 500, 500};
        noti.vibrate = pattern;

        //ton
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        if(alarmSound == null){
            alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
        noti.sound = alarmSound;
        //led
        noti.ledARGB = 0xFF000FF; //blue
        noti.flags = Notification.FLAG_SHOW_LIGHTS;
        noti.ledOnMS = 200;
        noti.ledOffMS = 20;
        manager.notify((int)System.currentTimeMillis(), noti);

    }
}//end class

