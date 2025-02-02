package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Data_Helper_Sqlite {
    private static String DBPathConnection = "jdbc:sqlite:database//Juego1.db"; 
    private static Connection conn = null;
    protected Data_Helper_Sqlite(){}
    
    protected static synchronized Connection openConnection() throws Exception{
        try {
            if(conn == null)
                conn = DriverManager.getConnection(DBPathConnection);
        } catch (SQLException e) {
            System.out.println(e);;
        } 
        return conn;
    }

    protected static void closeConnection() throws Exception{
        try {
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}