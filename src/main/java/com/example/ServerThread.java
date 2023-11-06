package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread {
    Socket s;

    public ServerThread(Socket s) {
        this.s = s;
    }

    public void run() {
        try {
            String client;
            String nota="ciao";
            String note="";
            int risposta=0;
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            do {
                client =in.readLine();
                if (client.equals("aggiungi nota")) {
                    nota=in.readLine();
                    nota=nota+", ";
                    note=note+nota;
                } else if (client.equals("lista note")) {
                    out.writeBytes(note+ "\n");
                } else if (client.equals("uscita")) {
                    risposta = 1;
                } 
                System.out.println(note);
            } while (risposta != 1);
        } catch (Exception e) {
            System.out.println(e.toString());
            System.exit(1);
        }
    }
}

 /*Integer.parseInt(in.readLine());*/ 