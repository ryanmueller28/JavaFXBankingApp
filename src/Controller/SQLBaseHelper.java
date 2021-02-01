package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLBaseHelper {
    private String jbdcSchema = ""; // replace with jbdc specific schema
    private String sqlUsrName = ""; // replace with jbdc specific usr name, pass to interact screen
    private String sqlUsrPwd = ""; // pass to interact screen
    private String databaseName = "BankInfo";

    public SQLBaseHelper() {

    }

    public String getSqlUsrName(){
        return sqlUsrName;
    }


    public void setSqlUsrName(String sqlUsr){
        this.sqlUsrName = sqlUsr;
    }

    public String getSqlUsrPwd() {
        return sqlUsrPwd;
    }

    public void setSqlUsrPwd(String sqlUsrPwd) {
        this.sqlUsrPwd = sqlUsrPwd;
    }



    Statement statement = null;

    public void Login(String jbdc, String usrName, String usrPassword) throws SQLException {
        this.jbdcSchema = jbdc;
        this.sqlUsrName = usrName;
        this.sqlUsrPwd = usrPassword;

        Connection connection = DriverManager.getConnection(jbdcSchema, sqlUsrName, sqlUsrPwd);
        try{
            statement = connection.createStatement();
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

    public String getDatabaseName() {
        return databaseName;
    }
}
