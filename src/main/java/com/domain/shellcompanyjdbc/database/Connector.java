package com.domain.shellcompanyjdbc.database;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector
{
    public Connector() {}
    
    public static Connection getConnection()
    {
        return connect();
    }
    
    private static void findDriver()
            throws
            ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InstantiationException,
            InvocationTargetException
    {
        Class
                .forName("com.mysql.cj.jdbc.Driver")
                .getDeclaredConstructor()
                .newInstance();
    }
    
    private static Connection connect()
    {
        Connection connection = null;
        try {
            findDriver();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Failed to find driver.");
        }
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/shellcompanydb?serverTimezone=UTC",
                    "root",
                    "");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return connection;
    }
}
