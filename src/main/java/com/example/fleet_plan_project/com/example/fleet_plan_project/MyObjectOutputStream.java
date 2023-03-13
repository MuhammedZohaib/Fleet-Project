package com.example.fleet_plan_project;
import java.io.*;

class MyObjectOutputStream extends ObjectOutputStream {

    MyObjectOutputStream() throws IOException
    {
        super();
    }

    MyObjectOutputStream(OutputStream o) throws IOException
    {
        super(o);
    }

    @Override
    public void writeStreamHeader() throws IOException
    {
    }
}

