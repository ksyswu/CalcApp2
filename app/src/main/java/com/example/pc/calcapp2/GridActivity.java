package com.example.pc.calcapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.pc.calcapp2.adapter.GridViewAdapter;
import com.example.pc.calcapp2.beans.DataBean;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends CommonActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid); //화면에 출력하는것

        //그리드뷰를 가져옴
        GridView gridView = (GridView)findViewById(R.id.gridView);

        //그리드뷰에 넘길 데이터
        DataBean db1 = new DataBean(R.drawable.img1, "신화1");
        DataBean db2 = new DataBean(R.drawable.img2, "신화2");
        DataBean db3 = new DataBean(R.drawable.img3, "신화3");
        DataBean db4 = new DataBean(R.drawable.img4, "신화4");

        //데이터를 리스트화시킴
        List<DataBean> list  = new ArrayList<DataBean>();
        list.add(db1);
        list.add(db2);
        list.add(db3);
        list.add(db4);

        //리스트의 개수만큼 어뎁터가 출력
        GridViewAdapter adapter = new GridViewAdapter(this, list);

        //그리드뷰가 사용할 어뎁터를 지정한다.
        gridView.setAdapter(adapter);
    }
}
