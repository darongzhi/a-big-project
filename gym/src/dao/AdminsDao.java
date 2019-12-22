package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.DBConn;
import common.DBConnImpl;
import model.Admins;

public class AdminsDao extends BaseDao<Admins>{
	//ÓÃ»§µÇÂ¼

    public boolean login(Admins obj) {
        
        boolean blean = false;
        String sql ="select *from admins where username =? and password=?";
        DBConn db = new DBConnImpl();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            con=db.getConn();
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,obj.getUsername());
            pstmt.setString(2,obj.getPassword());
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                obj.setId(id);;
                if(id>0){
                    blean = true;
                }        
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            db.close(con);
            db.close(pstmt);
            db.close(rs);
        }                
        return blean;
    }

}
