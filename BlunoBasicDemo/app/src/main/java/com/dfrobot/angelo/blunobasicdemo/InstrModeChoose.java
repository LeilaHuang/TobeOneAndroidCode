package com.dfrobot.angelo.blunobasicdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InstrModeChoose extends BlunoLibrary {

    Button returnBtn;
    Button catBtn;
    Button lionBtn;
    Button rabbitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instr_mode_choose);

        returnBtn= (Button)findViewById(R.id.returnBtn);
        catBtn= (Button)findViewById(R.id.catBtn);
        lionBtn= (Button)findViewById(R.id.lionBtn);
        rabbitBtn= (Button)findViewById(R.id.rabbitBtn);

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(InstrModeChoose.this,MainActivity.class);
                startActivity(intent);
            }
        });

        catBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serialSend("cat");
                Intent intent = new Intent();
                intent.setClass(InstrModeChoose.this,InstrAnimal.class);
                intent.putExtra("name","cat");
                startActivity(intent);
            }
        });

        lionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serialSend("lion");
                Intent intent = new Intent();
                intent.setClass(InstrModeChoose.this,InstrAnimal.class);
                intent.putExtra("name","lion");
                startActivity(intent);
            }
        });

        rabbitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serialSend("rabbit");
                Intent intent = new Intent();
                intent.setClass(InstrModeChoose.this,InstrAnimal.class);
                intent.putExtra("name","rabbit");
                startActivity(intent);
            }
        });

    }


    @Override
    public void onConectionStateChange(connectionStateEnum theconnectionStateEnum) {

    }

    @Override
    public void onSerialReceived(String theString) {

    }
}
