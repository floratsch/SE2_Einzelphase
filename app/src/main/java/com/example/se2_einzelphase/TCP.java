package com.example.se2_einzelphase;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCP extends Thread {

    String sentence;
    String res;

    @Override
    public void run() {

        try {
            Socket socket = new Socket("se2-isys.aau.at", 53212);

            DataOutputStream toSever = new DataOutputStream(socket.getOutputStream());

            toSever.writeBytes(sentence + '\n');

            BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            res = fromServer.readLine();

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendMessage(String num) {
        this.sentence = num;
    }

    public String getAnswer() {
        return this.res;
    }
}
