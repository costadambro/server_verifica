package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try {
            System.out.println("server pronto alla connessione");
            ServerSocket ss = new ServerSocket(3000);
            while(true){
                Socket s =ss.accept();
                ServerThread thread= new ServerThread(s);
                thread.start();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante l'istanza del server");
            System.exit(1);
        }

    }
}