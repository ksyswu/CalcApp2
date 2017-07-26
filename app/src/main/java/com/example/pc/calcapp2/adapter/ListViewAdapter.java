package com.example.pc.calcapp2.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pc.calcapp2.R;
import com.example.pc.calcapp2.SongDetailActivity;
import com.example.pc.calcapp2.beans.SongDataBean;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    private Context context;
    private List<SongDataBean> list;

    public ListViewAdapter(Context context, List<SongDataBean> list) { //생성자 컨텍스트와 리스트 필요
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() { //그리드와 연결시키는 아답터, 그리드가 몇개인지 출력하는것 - 리스트의 사이즈를 이용하여 총개수출력
        return list.size();
    }

    @Override
    public Object getItem(int position) { //리스트의 데이터 빈을 빼서 넣어줌
        return list.get(position);
    }

    @Override
    public long getItemId(int position) { //포지션값을 그냥 넣음
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater li = (LayoutInflater) //레이아웃을 가져올 수있음
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //레이아웃 가져오고
        convertView = li.inflate(R.layout.lay_album, null); //널이었던 곳에 이미지와 텍스트를 가져와 동적할당 시킴 null 자리는 부모로 나타낼수 있고 없으니까 컨버트뷰로 넣는것

        //데이터를 찾는다
        final SongDataBean song = list.get(position);

        //데이터의 내용을 화면에 표시한다
        // 파인드뷰바이아이디는 찾고자하는 것을 기준으로 해야하기에 위에 앨범에서의 정보를 컨버트뷰에 넣었기에 컨버트뷰기준으로 찾아오기에 convertView.findViewById로 사용함
        ImageView imgPhoto = (ImageView)convertView.findViewById(R.id.imgPhoto);
        TextView txtTitle = (TextView)convertView.findViewById(R.id.txtTitle);
        TextView txtAuthor = (TextView)convertView.findViewById(R.id.txtAuthor);
        TextView txtTime = (TextView)convertView.findViewById(R.id.txtTime);

        imgPhoto.setImageResource( song.getPhoto() );
        txtTitle.setText( song.getTitle() );
        txtAuthor.setText( song.getAuthor() );
        txtTime.setText( song.getTime() );


        //이벤트
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //익명 클래스

                Intent i = new Intent(context, SongDetailActivity.class); //지금있는 나의 위치(CONTEXT),

                i.putExtra("song", song); //final로 안정성을 정의하고 시리어블로 implements를 해야 함

                context.startActivity(i);
            }
        });

        return convertView;
    }
}
