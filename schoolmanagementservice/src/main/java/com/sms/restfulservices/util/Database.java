package com.sms.restfulservices.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Administrator on 12/10/2015.
 */
public class Database {
    public static Connection getConnection() throws Exception
    {
        try
        {
            String connectionURL = "jdbc:mysql://localhost:3306/second";
            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(connectionURL, "root", "root");
            return connection;
        } catch (Exception e)
        {
            throw e;
        }

    }
}
