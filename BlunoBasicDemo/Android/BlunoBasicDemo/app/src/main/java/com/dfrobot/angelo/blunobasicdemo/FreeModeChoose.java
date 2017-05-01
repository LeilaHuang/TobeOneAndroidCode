package com.dfrobot.angelo.blunobasicdemo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FreeModeChoose extends ActionBarActivity {


    Button returnBtn;
    Button createBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_mode_choose);

        returnBtn= (Button)findViewById(R.id.returnBtn);
        createBtn= (Button)findViewById(R.id.createBtn);


        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(FreeModeChoose.this,MainActivity.class);
                startActivity(intent);
            }
        });

        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(FreeModeChoose.this,FreeModeRecording.class);
                startActivity(intent);
            }
        });
    }
}
