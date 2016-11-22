package com.example.sean.snaps.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ClientConnectors {
    public static Client CL;

    public ClientConnectors(String host, String port) {
        CL = new Client(host, port);
        try {
            CL.openConnection("Snap 접속요청");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void sendMessage(Object msg) {
        try {
            CL.openConnection(msg);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}