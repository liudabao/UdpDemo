package com.example.lenovo.udpdemo;

import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by lenovo on 2016/7/20.
 */
public class UdpServer implements Runnable {
    private static final int PORT = 6000;
    private byte[] msg = new byte[1024];
    private boolean life = true;

    public boolean isLife() {
        return life;
    }

    public void setLife(boolean life) {
        this.life = life;
    }


    @Override
    public void run() {
        Log.e("receive", "start");
        DatagramSocket socket=null;
        try {
            socket=new DatagramSocket(PORT);
            DatagramPacket packet=new DatagramPacket(msg, msg.length);
            while (life){
                socket.receive(packet);
                Log.e("receive", packet.getData().toString());
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            socket.close();
        }

    }
}
