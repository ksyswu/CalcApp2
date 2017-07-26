package com.example.pc.calcapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends CommonActivity {


    private TextView txtDisp;
    private ArrayList<String> values = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDisp = (TextView)findViewById(R.id.txtDisp);

        //첫번째 키그룹
        LinearLayout layKey1 = (LinearLayout)findViewById(R.id.layKey1); //
        int childCount = layKey1.getChildCount();

        for(int i=0;i<childCount; i++){ //4번임 - layKey1안에 리니얼로 4개로 나누어 지기때문에
            View v = layKey1.getChildAt(i);

            if(v instanceof LinearLayout){
                int btnCount = ((LinearLayout) v).getChildCount(); //v를 리니얼로 강제로 캐스팅하겠다 getChildCount함수를 사용하기 위해서

                for(int k=0;k<btnCount;k++){
                    View btnChild = ((LinearLayout) v).getChildAt(k);
                    if(btnChild instanceof Button){    //layout 안에 다른 layout들이 있으므로 버튼에만 반응하게끔
                        btnChild.setOnClickListener(keyPadClick); //버튼이 눌리면 클릭리스너에 등록하여라
                    }
                }
            }//end if


        }

        //두번째 키그룹
        LinearLayout layKey2 = (LinearLayout)findViewById(R.id.layKey2);
        childCount = layKey2.getChildCount();

        for(int i=0;i<childCount; i++){
            View v = layKey2.getChildAt(i);

            if(v instanceof LinearLayout){
                int btnCount = ((LinearLayout) v).getChildCount();

                for(int k=0;k<btnCount;k++){
                    View btnChild = ((LinearLayout) v).getChildAt(k);
                    if(btnChild instanceof Button){    //layout 안에 다른 layout들이 있으므로 버튼에만 반응하게끔
                        btnChild.setOnClickListener(keyPadClick);
                    }
                }
            }//end if
        }

    }//end OnCreate()

    private View.OnClickListener keyPadClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(v instanceof  Button){
                Button btn = (Button)v; //버튼을 클릭하면 번호를 빼오는것
                String btnText = btn.getText().toString();

                //연산자를 클릭하면 연산이 되도록
                switch (btnText){
                    case "+":
                        values.add( txtDisp.getText().toString() );
                        values.add("+");
                        txtDisp.setText("");
                        break;
                    case "-":
                        values.add( txtDisp.getText().toString() );
                        values.add("-");
                        txtDisp.setText("");
                        break;
                    case "/":
                        values.add( txtDisp.getText().toString() );
                        values.add("/");
                        txtDisp.setText("");
                        break;
                    case "*":
                        values.add( txtDisp.getText().toString() );
                        values.add("*");
                        txtDisp.setText("");
                        break;
                    case "=":
                        values.add( txtDisp.getText().toString() );
                        break;
                    default:
                        txtDisp.setText(  txtDisp.getText() + btnText  );
                }

                if(btnText.equals("=")) {
                    double result = 0;

                    for(int i=0; i<values.size(); i++) {
                        String val = values.get(i);

                        switch (val) {
                            case "+":
                                double p1 = Double.parseDouble( values.get(i+1) );
                                result += p1;
                                break;
                            case "*":
                                break;
                            case "-":
                                break;
                            case "/":
                                break;
                            default:
                                result = Double.parseDouble(val);
                        }//end switch
                    }//end for

                    values.clear();
                    txtDisp.setText( result + "" );

                }//end if

                //txtDisp.setText( txtDisp.getText() + btnText);
               //Toast.makeText(MainActivity.this, "키가 눌러짐", Toast.LENGTH_SHORT).show();
                        // context : 앱/화면에 대한 정보 (activity는 context상속받고있음 cf)getApplicationContext는 앱 전체에 대한 정보)


            }
        }

    };
}
