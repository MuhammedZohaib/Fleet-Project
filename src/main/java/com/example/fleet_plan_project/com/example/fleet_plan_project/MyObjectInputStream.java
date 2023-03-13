package com.example.fleet_plan_project;

import java.io.*;

public class MyObjectInputStream extends ObjectInputStream {

    public MyObjectInputStream() throws IOException, SecurityException {
        super();
    }

    public MyObjectInputStream(InputStream in) throws IOException {
        super(in);
    }


    @Override
    public void readStreamHeader() throws IOException, StreamCorruptedException {
    }
}
