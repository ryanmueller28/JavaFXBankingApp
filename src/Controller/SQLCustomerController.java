package Controller;

import Model.Customer;

import java.sql.*;


public class SQLCustomerController {
    private static String jbdcSchema = "jdbc:mysql://192.168.0.68:3306/?user=ryan";
    private static String sqlUsrName = "ryan";
    private static String sqlUsrPwd = "";
    private static String databaseName = "DevCustomerDatabase";

    Connection connection = DriverManager.getConnection(jbdcSchema, sqlUsrName, sqlUsrName);
    Statement statement = null;
    // Customer Array

/*
    Statement statement = connection.createStatement();*/

    /**
     * Get the database on the Raspberry Pi
     * @throws SQLException
     */
    public SQLCustomerController() throws SQLException {

    }

    public void createCustomerDB(){
        String createTableCustomer = "CREATE DATABASE BankInfo";
        try{
            statement = connection.createStatement();
            statement.execute(createTableCustomer);
        } catch (SQLException se) {
            se.printStackTrace();;

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                if (statement != null){
                    statement.close();
                }
            }catch (SQLException se2){

            }try{
                if (connection != null){
                    connection.close();
                }
            }catch (SQLException se3){
                se3.printStackTrace();
            }
        }

        createCustomerTable();
    }

    public void createCustomerTable(){
        String SQLCreateCustomerTable = "CREATE TABLE CUSTOMER (" +
                "ID int, " +
                "FirstName varchar(255)," +
                "LastName varchar(255)," +
                "Address varchar(255)," +
                "PhoneNumber BIGINT," +
                "CheckingAccountNum BIGINT," +
                "SavingsAccountNum BIGINT)";
        try{
            statement = connection.createStatement();
            statement.execute(SQLCreateCustomerTable);
        } catch (SQLException se) {
            se.printStackTrace();;

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                if (statement != null){
                    statement.close();
                }
            }catch (SQLException se2){

            }try{
                if (connection != null){
                    connection.close();
                }
            }catch (SQLException se3){
                se3.printStackTrace();
            }
        }

    }

    public void addCustomerToDB(Customer customerToAdd){

    }

}
