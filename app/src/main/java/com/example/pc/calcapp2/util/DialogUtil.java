package com.example.pc.calcapp2.util;

import android.accessibilityservice.GestureDescription;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pc.calcapp2.GridActivity;
import com.example.pc.calcapp2.R;

/**
 * Created by pc on 2017-07-07.
 */

public class DialogUtil {
    //버튼하나 - alert다이얼 로그
    public static void showAlert(Context context, String title, String msg){
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
        alertBuilder.setTitle(title);
        alertBuilder.setMessage(msg);
        alertBuilder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertBuilder.setCancelable(false); //확인을 눌렀을경우에만 사라짐 바깥영역을 클릭해도 사라지지 않음
        alertBuilder.show();
    }

    //yse, no 버튼이 있는 다이얼로그
    public static void showConfirmDlg(Context context, String  title, String msg,
                                      DialogInterface.OnClickListener okClick,
                                      DialogInterface.OnClickListener cancelClick)
    {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
        alertBuilder.setTitle(title);
        alertBuilder.setMessage(msg);
        alertBuilder.setPositiveButton("확인", okClick);
        alertBuilder.setNegativeButton("취소", cancelClick);
        alertBuilder.setCancelable(false);
        alertBuilder.setIcon(R.drawable.img1);
        alertBuilder.show();

    }

    //커스텀 다이얼 로그
    public  static void showCustom(final Context context, View.OnClickListener click){
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.lay_dlg_custom);

        final EditText edtMsg = (EditText)dialog.findViewById(R.id.edtMsg); //실제 메시지가 들어오는곳
        Button btnOk = (Button)dialog.findViewById(R.id.btnOk);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  msg = edtMsg.getText().toString();
                Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public static void showCustomToast(Context context, String msg){

        LayoutInflater li = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View newLay = li.inflate(R.layout.lay_dlg_custom, null);

        EditText edtMsg = (EditText)newLay.findViewById(R.id.edtMsg);
        edtMsg.setText(msg);

        //Toast의 디자인을 바꾼다.
        Toast toast = new Toast(context);
        toast.setGravity(Gravity.BOTTOM,0,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(newLay);
        toast.show();

    }
}
