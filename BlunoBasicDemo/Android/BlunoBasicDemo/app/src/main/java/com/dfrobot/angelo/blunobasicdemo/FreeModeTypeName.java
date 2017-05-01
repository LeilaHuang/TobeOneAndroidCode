package com.dfrobot.angelo.blunobasicdemo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FreeModeTypeName extends ActionBarActivity {


    Button returnBtn;
    Button confirmBtn;
    TextView typeName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_mode_type_name);

        returnBtn= (Button)findViewById(R.id.returnBtn);
        confirmBtn= (Button)findViewById(R.id.confirmBtn);
        typeName= (TextView)findViewById(R.id.typeName);


        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(FreeModeTypeName.this,FreeModeRecording.class);
                startActivity(intent);
            }
        });

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
              //  intent.setClass(FreeModeTypeName.this,FreeModeRecording.class);
                startActivity(intent);
            }
        });

//        typeName.addTextChangedListener(new TextView.OnEditorActionListener(
//
//        ){});






    }
}
