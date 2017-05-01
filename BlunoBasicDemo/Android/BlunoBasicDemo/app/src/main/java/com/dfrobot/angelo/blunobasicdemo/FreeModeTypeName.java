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
                startActivity(intent);
            }
        });


        editText.TextChanged += (object sender, Android.Text.TextChangedEventArgs e) => {

            textView.Text = e.Text.ToString ();

        };

        typeName.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

               String name= typeName.getText().toString();

            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

//        typeName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View arg0) {
////调到拨号界面
//                Character uri = Character.getName("af");
//                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
//                startActivity(intent);
//            }
//        });





//        typeName.addTextChangedListener(new TextView.OnEditorActionListener(
//
//        ){});






    }
}
