package com.roytrack.dailytest.simplejava;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by roytrack on 2015/2/22.
 */

public class InputStreamDemo {

    public static void main(String[] args) {
        try {
            seeStreamAndReader();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void seeStreamAndReader() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String aa=br.readLine();
        System.out.println(aa);
    }
}
