package com.dfrobot.angelo.blunobasicdemo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Timer;

public class ObjCompletedPage extends ActionBarActivity {

    Button returnBtn;
    Button backMainBtn;
    Timer timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obj_completed_page);


        returnBtn= (Button)findViewById(R.id.returnBtn);
        backMainBtn= (Button)findViewById(R.id.backMainBtn);
      //  timer= (Button)findViewById(R.id.timer);


        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(ObjCompletedPage.this,FreeModeTypeName.class);
                startActivity(intent);
            }
        });

        backMainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ObjCompletedPage.this,MainActivity.class);
                startActivity(intent);
            }
        });



    }
}
