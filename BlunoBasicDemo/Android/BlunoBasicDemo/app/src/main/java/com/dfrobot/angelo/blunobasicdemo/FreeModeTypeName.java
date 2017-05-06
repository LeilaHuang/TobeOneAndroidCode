package com.dfrobot.angelo.blunobasicdemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FreeModeTypeName extends ActionBarActivity {


    Button returnBtn;
    Button confirmBtn;
    EditText typeName;
    Editable nameEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_mode_type_name);

        returnBtn= (Button)findViewById(R.id.returnBtn);
        confirmBtn= (Button)findViewById(R.id.confirmBtn);
        typeName= (EditText)findViewById(R.id.typeName);


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
                intent.setClass(FreeModeTypeName.this,ObjCompletedPage.class);

                intent.putExtra("Name", String.valueOf(nameEdit));

                startActivity(intent);


            }
        });


        typeName.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus) {

                    nameEdit=typeName.getText(); // 获得焦点

                } else {

                    // 失去焦点
                }

            }

        });





    }
}
