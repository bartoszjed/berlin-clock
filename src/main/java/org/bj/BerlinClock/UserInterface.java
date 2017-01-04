package org.bj.BerlinClock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Bartosz Jedrzejczak on 04/01/2017.
 */
public class UserInterface {

    public void printLine() {
        printLine("");
    }

    public void printLine(String s) {
        System.out.println(s);
    }

    public String readLine() {
        String result = "";
        BufferedReader inBuffer = new BufferedReader(new InputStreamReader(System.in));
        try {
            result = inBuffer.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
