package com.roytrack.dailytest.simpleJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by ruanchangming on 2015/1/11.
 */
public class Aconnection {
    private static volatile  Aconnection aconnection;
    private static String url="jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=round&useUnicode=true&characterEncoding=UTF-8";
    private static String username="root";
    private static String password="12qwaszx";
    private Connection conn;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Aconnection(){}

    public Connection getConn(){
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  conn;
    }
    public static Aconnection  getInstance(){
        if(aconnection==null){
            synchronized (Aconnection.class) {
                if (aconnection == null) {
                    aconnection = new Aconnection();
                }
            }
        }
        return aconnection;
    }
}
