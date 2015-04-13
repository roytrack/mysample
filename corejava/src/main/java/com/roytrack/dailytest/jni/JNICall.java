package com.roytrack.dailytest.jni;

/**
 * Created by ruanchangming on 2015/4/10.
 */
public class JNICall {

        static {
            System.loadLibrary("MediumDll");
        }
        public native String CallTheDll();

    }

