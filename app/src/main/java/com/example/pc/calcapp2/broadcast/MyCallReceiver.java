package com.example.pc.calcapp2.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MyCallReceiver extends BroadcastReceiver {

    //호출하는 것 온리시브로 호출이 들어옴 이 클래스 생성시 매니페스트에 자동으로 리시버 생성
    @Override
    public void onReceive(Context context, Intent intent) { //화면정보가 콘덱스트임 intent는 데이터를 담은 것 따라서 인텐트에 정보를 담아서 넘김
        //전화 왔을 때 콜백함수
        if (intent.getStringExtra(TelephonyManager.EXTRA_STATE)
                .equals(TelephonyManager.EXTRA_STATE_RINGING) // 전화가 울릴때 아래가 실행이됨
        )
        {
            String incomingNum = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
            Toast.makeText(context, "전화 왔어요!  : " + incomingNum, Toast.LENGTH_LONG).show();
        }else if (
              intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_IDLE)
            || intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_OFFHOOK) //전화가 끊겼을때
         ){
            Toast.makeText(context, "전화가 끊겼습니다." , Toast.LENGTH_LONG).show();
        }
    }
}
