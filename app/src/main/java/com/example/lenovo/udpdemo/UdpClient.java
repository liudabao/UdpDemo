package com.example.lenovo.udpdemo;

import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Created by lenovo on 2016/7/20.
 */
public class UdpClient {
    private static final int SERVER_PORT = 6000;
    private String msg;


    public UdpClient(String msg) {
        this.msg = msg;
    }

    public void send(){
        Log.e("send", "start");;
        StringBuilder sb = new StringBuilder();
        InetAddress local = null;
        DatagramSocket socket=null;
        DatagramPacket packet=null;
        try{
            local=InetAddress.getByName("127.0.0.1");
            socket=new DatagramSocket();
            packet=new DatagramPacket(msg.getBytes(), msg.length(), local, SERVER_PORT);
            socket.send(packet);
            Log.e("send", packet.getData().toString());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            socket.close();
        }
    }
}
