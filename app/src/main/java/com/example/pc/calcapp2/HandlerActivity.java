package com.example.pc.calcapp2;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class HandlerActivity extends AppCompatActivity {

    private TextView mTextWork;  //멤버변수를 쓸때 멤버를 나타내는 m을 붙여줌
    private ProgressBar mPrbWork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        mTextWork = (TextView)findViewById(R.id.txtWork);
        mPrbWork = (ProgressBar)findViewById(R.id.prbWork);
        mPrbWork.setMax(100); //전체값이 100까지임

        new Thread(run1).start(); //실행시킴

    }

    private  Runnable run1 = new Runnable() {
        @Override
        public void run() {
            try{
                for (int i =1; i<=20; i++){
                    //메인스레드 작업을 위해서 호출한다.
                   // handle2.sendEmptyMessage(i*5);
                    //Thread.sleep(1000);
                    //위의 두줄을 하나로 합친것
                    //handle2.sendEmptyMessageDelayed(i*5, 1000);
                    Message msg = Message.obtain(); //메시지를 넣어서 던지는것
                    msg.what = 1; //종류
                    msg.arg1 = i*5; //값
                    handle2.sendMessage(msg);
                    Thread.sleep(1000);
                }
            }catch (Exception e){
               // Toast.makeText(HandlerActivity.this, "화면갱신 실패", Toast.LENGTH_SHORT).show();
                e.printStackTrace();

                //android.view.ViewRootImpl$CalledFromWrongThreadException: Only the original thread that created a view hierarchy can touch its views. 이런 에러가 뜬다는것은 메인스레드에서만 터치가 가능한데 다른데서 터치한 것
            }

            //handle2.sendEmptyMessage(1000);
            handle2.sendEmptyMessage(0); //100까지 올라가면 0을 보내주어서 워킹돈메시지가 뜨도록함

        }
    };

    //핸들러 생성 p440
    private  Handler handle2 = new Handler(){
        @Override
        public void handleMessage(Message msg){

//            int value = msg.what;
//            if(value == 1000){
//                mTextWork.setText("Working Done...");
//            }else{
//                mTextWork.setText(value + "%");
//                // mPrbWork.setProgress(5);//5씩 증가
//                mPrbWork.setProgress(value);
//
//            }
            int value = msg.arg1;

            if(msg.what == 0){
                mTextWork.setText("Working Done...");
            }else{
                mTextWork.setText(value + "%");
                // mPrbWork.setProgress(5);//5씩 증가
                mPrbWork.setProgress(value);

            }

        }
    };

}
