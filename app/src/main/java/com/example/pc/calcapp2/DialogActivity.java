package com.example.pc.calcapp2;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.pc.calcapp2.util.DialogUtil;

public class DialogActivity extends CommonActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        findViewById(R.id.btnAlert).setOnClickListener(new View.OnClickListener() { //인터페이스는 뉴가 안되기에 바로 아래에서 구현을하는것 즉 익명클래스,인스턴스생성
            @Override
            public void onClick(View v) {
                //DialogUtil.showAlert(this);//this는 버튼즉 익명클래스의 디스임 따라서 안에서 디스를 쓰려면 다이얼로그 액티비티의 디스를 가져오기위해 아래처럼 사용
                DialogUtil.showAlert(DialogActivity.this, "알럿","밥먹어! \n 라");

            }
        });

        findViewById(R.id.btnConfirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtil.showConfirmDlg(DialogActivity.this, "컨펌", "밥먹었니?", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, "ok 눌렀음", Toast.LENGTH_SHORT).show();
                    } //okay누를 경우
                }, null); //no누를 경우

            }
        });

        findViewById(R.id.btnCustom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtil.showCustom(DialogActivity.this, null);

                DialogUtil.showCustomToast(DialogActivity.this, "CUSTOM Toast입니다");

            }
        });

    }
}
