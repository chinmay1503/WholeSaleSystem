package com.wholesalesystem.controllers;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * ConnectionController.java - Creates a New Connection */
public class ConnectionController {

    public Connection newConnection() throws Exception {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORACLE12", "chinmay", "chinmay");

            return con;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }
}



