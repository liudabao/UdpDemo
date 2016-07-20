package com.example.lenovo.udpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    Button send;
    Button receive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        send=(Button)findViewById(R.id.client);
        receive=(Button)findViewById(R.id.server);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        UdpClient client = new UdpClient("i am data");
                        client.send();
                    }
                }).start();

            }
        });

        receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExecutorService exec = Executors.newCachedThreadPool();
                UdpServer server = new UdpServer();
                exec.execute(server);
            }
        });
    }


}
