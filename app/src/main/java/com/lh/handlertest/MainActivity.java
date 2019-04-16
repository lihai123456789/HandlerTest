package com.lh.handlertest;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

            switch(msg.what){
                case 1:
                    tv.setText("Nice to meet you!");
                    break;
                default:
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);
        tv = findViewById(R.id.tv);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        Message msg = Message.obtain();
                        msg.what = 1;
                        msg.arg1 = 1;
                        handler.sendMessage(msg);

                    }
                }).start();

            }
        });

    }
}
