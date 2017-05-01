package com.dfrobot.angelo.blunobasicdemo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FreeModeRecording extends ActionBarActivity {

    Button returnBtn;
    Button prevBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_mode_recording);

        returnBtn= (Button)findViewById(R.id.returnBtn);
        prevBtn= (Button)findViewById(R.id.prevBtn);


        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(FreeModeRecording.this,FreeModeChoose.class);
                startActivity(intent);
            }
        });

        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
               // intent.setClass(FreeModeRecording.this,FreeModeRecording.class);
                startActivity(intent);
            }
        });



    }
}
