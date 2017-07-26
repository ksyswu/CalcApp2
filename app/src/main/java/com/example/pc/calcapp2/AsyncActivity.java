package com.example.pc.calcapp2;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class AsyncActivity extends AppCompatActivity {

    private TextView mTextWork;  //멤버변수를 쓸때 멤버를 나타내는 m을 붙여줌
    private ProgressBar mPrbWork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);

        mTextWork = (TextView)findViewById(R.id.txtWork);
        mPrbWork = (ProgressBar)findViewById(R.id.prbWork);
        mPrbWork.setMax(100); //전체값이 100까지임

        new TaskRun1().execute();

    }

    private class TaskRun1 extends AsyncTask<Void, Integer, String> {  //<>는 제네릭이라고 함 generic이란 데이터의 안정성을 보장해주는 기법
        //integer는 int를 객체화 한것으로 wrapper class라고 부름 아무런 값이 없을때 void
        //<  doin / onprogress / onpost  >

        private ProgressDialog prd;
        @Override
        protected void onPreExecute() {
            //스레드가 즉 doinBackGround()가 실행되기전에 실행된다
            prd = new ProgressDialog(AsyncActivity.this);
            prd.setMessage("현재 업데이트 중 ..");
            prd.show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            //업데이트 갱신 부분
            mTextWork.setText(values[0] + "%");
            mPrbWork.setProgress(values[0]);

        }

        @Override
        protected String doInBackground(Void... params) { //...은 파라미터가 생략되거나 무한대로 줄수 있는 것 0~무한대
            for(int i=1; i<=20; i++){
                publishProgress(i*5);
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            return "workding done"; //스레드가 끝날경우
        }

        @Override
        protected void onPostExecute(String str) {
            prd.dismiss(); //업데이트가 끝나면 업데이트중 메시지를 사라지게함

            if(str != null){
                mTextWork.setText(str);
            }
        }

    };



}
