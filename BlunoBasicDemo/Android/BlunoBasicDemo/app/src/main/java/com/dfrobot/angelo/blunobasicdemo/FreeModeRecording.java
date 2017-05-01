package com.dfrobot.angelo.blunobasicdemo;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FreeModeRecording extends BlunoLibrary {

    Button returnBtn;
    Button prevBtn;
    TextView textView;
    Handler mHandler;
    boolean [] bodypartAssembedCheck= new boolean[6];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_mode_recording);

        returnBtn = (Button) findViewById(R.id.returnBtn);
        prevBtn = (Button) findViewById(R.id.prevBtn);
        textView = (TextView) findViewById(R.id.textView);

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(FreeModeRecording.this, FreeModeChoose.class);
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


//        mHandler = new Handler() {
//            @Override
//            public void handleMessage(Message msg) {
//                // checkStage();
//                super.handleMessage(msg);
//                switch (msg.what) {
//                    case 0:
//                        //完成主界面更新,拿到数据
//                        boolean data = (boolean)msg.obj;
//                      //  checkStage();
//                        textView.setText(data+"");
//                      //  nextBtn.setEnabled(data);
//                        break;
//                    default:
//                        break;
//                }
//            }
//
//        };


    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        onActivityResultProcess(requestCode, resultCode, data);                    //onActivityResult Process by BlunoLibrary
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("BlUNOActivity onResume");
        onResumeProcess();                                                        //onResume Process by BlunoLibrary
    }

    @Override
    protected void onPause() {
        super.onPause();
        onPauseProcess();                                                        //onPause Process by BlunoLibrary
    }

    protected void onStop() {
        super.onStop();
        onStopProcess();                                                        //onStop Process by BlunoLibrary
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onDestroyProcess();                                                        //onDestroy Process by BlunoLibrary
    }

    @Override
    public void onConectionStateChange(connectionStateEnum theConnectionState) {

        switch (theConnectionState) {											//Four connection state
            case isConnected:
                textView.append("connected");
                break;
            case isConnecting:
                textView.append("connecting");
                break;
            case isToScan:
                textView.append("scan");
                break;
            case isScanning:
                textView.append("scanning");
                break;
            case isDisconnecting:
                textView.append("Disconnected");
                break;
            default:
                break;
        }

    }

    @Override
    public void onSerialReceived(String theString) {
      textView.append(theString);
        theString=theString.trim();
        String output[] = theString.split(",");
        int partArray[] = new int[output.length];
        for (int i = 0; i < output.length; i++) {
            partArray[i] = Integer.parseInt(output[i]);
        }
//check which one samll part is connected in Bluno
        for (int i = 0; i < partArray.length; i++) {
            switch (partArray[i]) {
                case 0:
                    bodypartAssembedCheck[0] = true;
                    break;
                case 1:
                    bodypartAssembedCheck[1] = true;
                    break;
                case 2:
                    bodypartAssembedCheck[2] = true;
                    break;
                case 3:
                    bodypartAssembedCheck[3] = true;
                    break;
                case 4:
                    bodypartAssembedCheck[4] = true;
                case 5:
                    bodypartAssembedCheck[5] = true;
                default:
                    break;
            }
        }

        int i=0;

        while(i<6 && bodypartAssembedCheck[i]==true){
            i++;
        }

        Intent intent = new Intent();
        intent.setClass(FreeModeRecording.this, FreeModeTypeName.class);
        startActivity(intent);









    }// end onSerialReceived

}