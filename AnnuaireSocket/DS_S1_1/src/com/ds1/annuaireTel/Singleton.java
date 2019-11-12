package com.ds1.annuaireTel;

import com.mysql.jdbc.Connection;
import java.sql.*;
/**
 * @desc A singleton database access class for MySQL
 * @author Ramindu
 */
public final class Singleton {
    public Connection conn;
    private Statement statement;
    private PreparedStatement stmt;
    public static Singleton db;
    private Singleton() {
        String url= "jdbc:mysql://localhost:3306/";
        String dbName = "devoirsjava";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "";
        try {
            Class.forName(driver).newInstance();
            this.conn = (Connection)DriverManager.getConnection(url+dbName,userName,password);
        }
        catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }
   
    public static synchronized Singleton getDbCon() {
        if ( db == null ) {
            db = new Singleton();
        }
        return db;
 
    }
     public ResultSet query(String query) throws SQLException{
        statement = db.conn.createStatement();
        ResultSet res = statement.executeQuery(query);
        return res;
    }
    public int insert(String insertQuery) throws SQLException {
        statement = db.conn.createStatement();
        int result = statement.executeUpdate(insertQuery);
        return result;
 
    }
    public boolean testLogin(String login, String password) throws SQLException {
    	String query = "select login , password from client where login=? and password=?";
    	stmt = db.conn.prepareStatement(query);
    	stmt.setString(1, login);
    	stmt.setString(2, password);
        ResultSet res = stmt.executeQuery();
        if(res.next()) return true;
        else return false;
    }
 
}
