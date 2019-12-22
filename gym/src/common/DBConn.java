package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public interface DBConn {

    Connection getConn();
    
    public void close(Connection con);
    public void close(PreparedStatement pstmt);
    public void close(ResultSet rs);
    public void close(Statement stmt);
    public void closeAll(ResultSet rs,PreparedStatement pstmt,Connection con);
    
}
