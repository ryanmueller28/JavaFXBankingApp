package Controller;

import Model.Customer;

import java.sql.*;
import java.util.Scanner;


public class SQLCustomerController {
    private static String jbdcSchema = ""; // replace with jbdc specific schema
    private static String sqlUsrName = ""; // replace with jbdc specific usr name, pass to interact screen
    private static String sqlUsrPwd = ""; // pass to interact screen
    private static String databaseName = "";

    public void setSqlUsrName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input your user name: ");
        sqlUsrName = sc.nextLine();
    }

    public void setSqlUsrPwd(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input your password: ");
        sqlUsrPwd = sc.nextLine();
    }


    Connection connection = DriverManager.getConnection(jbdcSchema, sqlUsrName, sqlUsrName);
    Statement statement = null;
    // Customer Array

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
        String insertBegin = "INSERT INTO Customers " +
                "(ID, FirstName, LastName, Address, PhoneNumber, CheckingAccountNum, SavingsAccountNum)";

        String whatToInsert = "VALUES(" + customerToAdd.getId()
                + customerToAdd.getFirstName() + customerToAdd.getLastName() +
                customerToAdd.getAddress() + customerToAdd.getPhoneNumber() +
                customerToAdd.getCheckingAccount() + customerToAdd.getSavingsAccount() + ")";

        String insertCustomerStatement = insertBegin + whatToInsert;

        try{
            statement = connection.createStatement();
            statement.execute(insertCustomerStatement);
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

}
