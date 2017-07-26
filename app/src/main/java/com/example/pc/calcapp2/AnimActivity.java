package com.example.pc.calcapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class AnimActivity extends AppCompatActivity {

    private Button btnAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);

        btnAnim = (Button)findViewById(R.id.btnAnim);

        final ImageView imgSwing = (ImageView)findViewById(R.id.imgSwing); //축으로 흔들리는것


        Animation animLeft = AnimationUtils.loadAnimation(this, R.anim.left); //켰을때 자동으로 돌아감
        btnAnim.startAnimation(animLeft);

        btnAnim.setOnClickListener(new View.OnClickListener() { //클릭시 버튼이 돌아감
            @Override
            public void onClick(View v) {
                Animation animLeft = AnimationUtils.loadAnimation(AnimActivity.this, R.anim.left);
                animLeft.setAnimationListener(animLison); //  ???
                btnAnim.startAnimation(animLeft);


                //축으로 흔들리는것
                Animation animShake = AnimationUtils.loadAnimation(AnimActivity.this, R.anim.shake);
                imgSwing.startAnimation(animShake);
            }

        });


    }

    private  Animation.AnimationListener animLison = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {
            Toast.makeText(AnimActivity.this, "애님 started..", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            //끝났을때 화면 이동하겠다
            Intent i = new Intent(AnimActivity.this, ListActivity.class);
            startActivity(i);

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };


}
