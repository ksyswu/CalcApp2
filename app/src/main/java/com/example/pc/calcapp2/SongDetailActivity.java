package com.example.pc.calcapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pc.calcapp2.beans.SongDataBean;

public class SongDetailActivity extends CommonActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_detail);

        ImageView imgAlbumJacket = (ImageView) findViewById(R.id.imgAlbumJacket);
        TextView txtSongTitle = (TextView)findViewById(R.id.txtSongTitle);
        TextView txtSinger = (TextView)findViewById(R.id.txtSinger);
        WebView webView = (WebView)findViewById(R.id.wbvYoutube);

//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
//        webView.getSettings().setSupportMultipleWindows(true);
//
        //webView.loadUrl("https://youtu.be/msok__h_3QY");
        webView.getSettings().setJavaScriptEnabled(true);

       // String a ="<iframe width=\"400\" height=\"280\" src=\"https://www.youtube.com/embed/msok__h_3QY\" frameborder=\"0\" allowfullscreen></iframe>";


        SongDataBean song = (SongDataBean)getIntent().getSerializableExtra("song");

        if (song != null){
            imgAlbumJacket.setImageResource(song.getPhoto());
            txtSongTitle.setText(song.getTitle());
            txtSinger.setText(song.getAuthor());
            webView.loadData(song.getSongUrl(), "text/html", "utf-8");
        }

    }
}
