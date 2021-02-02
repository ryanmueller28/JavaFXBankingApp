package Controller;

import Model.Account;

import java.sql.*;

public class SQLAccountController {

    private String jbdcSchema = ""; // replace with jbdc specific schema
    private String sqlUsrName = ""; // replace with jbdc specific usr name, pass to interact screen
    private String sqlUsrPwd = ""; // pass to interact screen
    private String databaseName = "BankInfo";

    Connection connection = DriverManager.getConnection(jbdcSchema, sqlUsrName, sqlUsrPwd);

    Statement statement = null;

    public SQLAccountController() throws SQLException{

    }

    public void createAccountTable(){
        String SQLCreateAccountTable = "CREATE TABLE Account (" +
                "AccountNumber BIGINT" +
                "Balance DECIMAL(15, 2)" +
                "InterestRate DECIMAL(12, 2)" +
                "MainOwnerFirstName varchar(255)" +
                "MainOwnerLastName varchar(255)" +
                "SecondaryOwnerFirstName varchar(255) " +
                "SecondaryOwnerLastName varchar(255)";

        try{
            statement = connection.createStatement();
            statement.execute(SQLCreateAccountTable);
        } catch (SQLException se) {
            se.printStackTrace();

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

    public void addAccountToDB(Account accountToAdd){
        String insertBegin = "INSERT INTO Account (" +
                "AccountNumber, Balance, InterestRate, MainOwnerFirstName, MainOwnerLastName, SecondaryOwnerFirstName, SecondaryOwnerLastName";

        String secondaryFirst = "", secondaryLast = "";

        /**
         * This checks if the secondary customer is empty.
         * If it is, the string for secondary customer will be
         * If not, we get it.
         */
        if (accountToAdd.getOwningCustomers().listIterator(1) == null) {
            secondaryFirst = "";
            secondaryLast = "";
        }else if (accountToAdd.getOwningCustomers().listIterator(1) != null){

            /**
             * A bit hacky to me,
             * But this gets the string of OwningCustomers[0 + 1] and then gets the names
             */
            secondaryFirst = accountToAdd.getOwningCustomers().listIterator(0).next().getFirstName();
            secondaryLast = accountToAdd.getOwningCustomers().listIterator(0).next().getLastName();
        }

        String whatToInsert = "VALUES(" + accountToAdd.getAccountNumber()
                + ", " + accountToAdd.getBalance() + ", " + accountToAdd.getInterestRate() + ", " +
                accountToAdd.getOriginalOwner().getFirstName() + ", " + accountToAdd.getOriginalOwner().getLastName() + ", " + secondaryFirst +
                ", " + secondaryLast + ")";

        String insertAccountStatement = insertBegin + whatToInsert;

        try{
            statement = connection.createStatement();
            statement.execute(insertAccountStatement);
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

    public String getJbdcSchema() {
        return jbdcSchema;
    }

    public void setJbdcSchema(String jbdcSchema) {
        this.jbdcSchema = jbdcSchema;
    }

    public String getSqlUsrName() {
        return sqlUsrName;
    }

    public void setSqlUsrName(String sqlUsrName) {
        this.sqlUsrName = sqlUsrName;
    }

    public String getSqlUsrPwd() {
        return sqlUsrPwd;
    }

    public void setSqlUsrPwd(String sqlUsrPwd) {
        this.sqlUsrPwd = sqlUsrPwd;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }
}
