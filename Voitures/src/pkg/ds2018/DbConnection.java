package pkg.ds2018;

import java.sql.*;

class DbConnection
{
    private static Connection conn;
    
    private DbConnection(){}
    
    public static Connection getConnection()
    {
        try
        {
            if(conn==null)
            {
                Class.forName("com.mysql.jdbc.Driver");
                conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/forjdbc?characterEncoding=latin1&useConfigs=maxPerformance","root","");
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return conn;
    }
}