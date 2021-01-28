package Controller;

import java.sql.*;


public class SQLCustomerController {
    private static String jbdcSchema = "jdbc:mysql://192.168.0.68:3306/?user=ryan";
    private static String sqlUsrName = "ryan";
    private static String sqlUsrPwd = "";
    private static String databaseName = "DevCustomerDatabase";

    Connection connection = DriverManager.getConnection(jbdcSchema, sqlUsrName, sqlUsrName);

    // Customer object

    // Customer Array

/*
    Statement statement = connection.createStatement();*/

    /**
     * Get the database on the Raspberry Pi
     * @throws SQLException
     */
    public SQLCustomerController() throws SQLException {

    }

}
