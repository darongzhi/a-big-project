package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



public class DBConnImpl implements DBConn{
    
    private String driver="com.mysql.jdbc.Driver";
    private String url="jdbc:mysql://localhost:3306/gym?useUnicode=true&characterEncoding=utf-8";
    private String user = "root";
    private String password = "123456";
    
    public Connection getConn(){
        Connection con = null;
        try{
            Class.forName(driver);
            con=DriverManager.getConnection(url,user,password);            
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
    
    public void close(Connection con){
        try{
            if(con != null){
                con.close();
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void close(PreparedStatement pstmt){
        try{
            if(pstmt != null){
                pstmt.close();
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void close(ResultSet rs){
        try{
            if(rs != null){
                rs.close();
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void close(Statement stmt){
        try{
            if(stmt != null){
                stmt.close();
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    
    public void closeAll(ResultSet rs,PreparedStatement pstmt,Connection con) {
        try {
            if(rs != null) {
                rs.close();
                rs = null;
            }
            if(pstmt != null) {
                pstmt.close();
                pstmt = null;
            }
            if(con != null) {
                con.close();
                con = null;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}