package com.example.pc.calcapp2.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pc.calcapp2.R;
import com.example.pc.calcapp2.beans.DataBean;

import java.util.List;

/**
 * Created by pc on 2017-07-05.
 */

public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private List<DataBean> dataList;

    public GridViewAdapter(Context context, List<DataBean> dataList) { //생성자
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public int getCount() { //그리드와 연결시키는 아답터, 그리드가 몇개인지 출력하는것 - 리스트의 사이즈를 이용하여 총개수출력
        return dataList.size();
    }

    @Override
    public Object getItem(int position) { //리스트의 데이터 빈을 빼서 넣어줌
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) { //포지션값을 그냥 넣음
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater lf = (LayoutInflater) //레이아웃을 가져올 수있음
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //레이아웃 가져오고
        convertView = lf.inflate(R.layout.lay_img, null); //널이었던 곳에 이미지와 텍스트를 가져와 동적할당 시킴
        //데이터 가져오고
        DataBean bean = dataList.get(position);

        ImageView imgPhoto = (ImageView)convertView.findViewById(R.id.imgphoto);
        TextView txtDesc = (TextView)convertView.findViewById(R.id.txtDesc);

        //데이터 뿌려주고
        imgPhoto.setImageResource( bean.getResImg() );
        txtDesc.setText( bean.getImgText() );

        //이벤트
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "이미지 눌러짐",
                        Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
}
