package com.dfrobot.angelo.blunobasicdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.dfrobot.angelo.blunobasicdemo.BlunoLibrary.connectionStateEnum.isConnected;
import static com.dfrobot.angelo.blunobasicdemo.BlunoLibrary.connectionStateEnum.isConnecting;
//import static com.dfrobot.angelo.blunobasicdemo.R.id.buttonScan;

public class InstrAnimal extends BlunoLibrary{

    Button returnBtn;
    Button discoverBtn;
    String itemName;
    boolean [] bodypartAssembedCheck= new boolean[6];
    TextView textView;
    Button nextBtn;
    Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreateProcess();
        //new Thread(new CheckStage("")).start();
        Intent intent = getIntent();
        serialBegin(115200);

        itemName = intent.getStringExtra("name");
        switch (itemName){
            case "cat":
                setContentView(R.layout.activity_instr_animal);
                serialSend("cat");
                break;
            case "rabbit":
                setContentView(R.layout.activity_instr_animal);// waiting to change
                break;
            case "lion":
                setContentView(R.layout.activity_instr_animal);// waiting to change
                break;
            default:
                break;

        }

        returnBtn= (Button)findViewById(R.id.returnBtn);
        discoverBtn= (Button)findViewById(R.id.discoverBtn);
        nextBtn = (Button) findViewById(R.id.nextBtn);
        textView = (TextView) findViewById(R.id.textView);
        nextBtn.setEnabled(false);


        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(InstrAnimal.this,InstrModeChoose.class);
                startActivity(intent);

            }
        });

        discoverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonScanOnClickProcess();
            }
        });

        Toast.makeText(this, "Hello World", Toast.LENGTH_SHORT).show();


        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
               // checkStage();
                super.handleMessage(msg);
                switch (msg.what) {
                    case 0:
                        //完成主界面更新,拿到数据
                        boolean data = (boolean)msg.obj;
                        checkStage();
                        textView.setText(data+"");
                        nextBtn.setEnabled(data);
                        break;
                    default:
                        break;
                }
            }

        };


    }


    public void finalcheck() {
        int result = 0;
        ArrayList<Integer> incompletedArrayList = new ArrayList<Integer>();
        String[] bodyPartName = {"head", "right Hand", "left Hand", "right foot", "left foot", "tail"};
        for (int i = 0; i < 6; i++) {
            if (bodypartAssembedCheck[i] == true) {
                result++;
            } else {
                incompletedArrayList.add(i);
            }

            if (result == 6) {
                // check all the component are connect or not
                // turn to animal assemble completed page
                Intent intent2 = new Intent();
                intent2.setClass(InstrAnimal.this, AnimalCompleted.class);
                startActivity(intent2);
            } else if (bodypartAssembedCheck[5] == true && result < 5) {
                //give user a reminder that some part are not completed

                AlertDialog.Builder dialog = new AlertDialog.Builder(InstrAnimal.this);
                dialog.setTitle("A kind reminder");//窗口名

                String s = "";
                StringBuilder stringBuilder = new StringBuilder(s);
                for (int j : incompletedArrayList) {
                    stringBuilder.append(bodyPartName[j]);
                    stringBuilder.append(" ");
                }

                dialog.setMessage("you haven't complete the " + stringBuilder.toString());
                dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        //waiting to add turn to the step videos
                    }
                });
                dialog.show();

            } else {

            }
        }//end for loop
    }


   	@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        onActivityResultProcess(requestCode, resultCode, data);					//onActivityResult Process by BlunoLibrary
        super.onActivityResult(requestCode, resultCode, data);
    }
    @Override
    protected void onResume(){
        super.onResume();
        System.out.println("BlUNOActivity onResume");
        onResumeProcess();														//onResume Process by BlunoLibrary
    }
    @Override
    protected void onPause() {
        super.onPause();
        onPauseProcess();														//onPause Process by BlunoLibrary
    }

    protected void onStop() {
        super.onStop();
        onStopProcess();														//onStop Process by BlunoLibrary
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        onDestroyProcess();														//onDestroy Process by BlunoLibrary
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
        // to know which body part is connected
        bodypartAssembedCheck[0] = true;
        theString=theString.trim();
        String output[]=theString.split(",");

        int partArray[]=new int[output.length];
        for(int i=0;i<output.length;i++){
            partArray[i]=Integer.parseInt(output[i]);
        }
        for(int i=0;i<partArray.length;i++){
            switch (partArray[i]){
                case 0:
                    bodypartAssembedCheck[0]=true;
                    break;
                case 1:
                    bodypartAssembedCheck[1]=true;
                    break;
                case 2:
                    bodypartAssembedCheck[2]=true;
                    break;
                case 3:
                    bodypartAssembedCheck[3]=true;
                    break;
                case 4:
                    bodypartAssembedCheck[4]=true;
                    break;
                case 5:
                    bodypartAssembedCheck[5]=true;
                    break;
                default:
                    break;
            }
        }



      }

    private void checkStage() {

        new Thread(new Runnable(){

            @Override
            public void run() {
                Message msg =new Message();
                msg.obj=true;
//                //耗时操作，完成之后发送消息给Handler，完成UI更新；
//                mHandler.sendEmptyMessage(0);
//                int count = 0;
//                Message msg =new Message();
//                while (count < 6) {
//                    //InstrAnimal instrAnimal = new InstrAnimal();
//                    boolean isConnected = bodypartAssembedCheck[count];
//                    if (isConnected) {
//                        count++;
//                        msg.obj = true;//可以是基本类型，可以是对象，可以是List、map等；
//                        mHandler.sendMessage(msg);
//                    }else {
//                        //msg.obj = false;//可以是基本类型，可以是对象，可以是List、map等；
//                        //mHandler.sendMessage(msg);
//                    }
//                }
                //需要数据传递，用下面方法；

            }

        }).start();

    }


}

//class CheckStage implements Runnable {
//
//    String name;
//    public Handler mHandler;
//
//    CheckStage(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public void run() {
//        Looper.prepare();
//        mHandler = new Handler() {
//            public void handleMessage(Message msg) {
//                // process incoming messages here
//                InstrAnimal instrAnimal = new InstrAnimal();
//                instrAnimal.textView.append("Thread Ready");
//
//            }
//        };
//
//        Looper.loop();
//    }




