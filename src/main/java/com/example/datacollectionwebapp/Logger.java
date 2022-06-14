package com.example.datacollectionwebapp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    public static void log(String str) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("/opt/tomcat/webapps/DataCollectionWebApp/WEB-INF/classes/whatsup.log", true));
        writer.write(str);
        writer.newLine();
        writer.close();
    }

}
