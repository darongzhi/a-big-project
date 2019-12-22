package dao;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.DBConn;
import common.DBConnImpl;



public class BaseDao<Entity> {

    DBConn db = new DBConnImpl();
    int r=0;
    private Class clazz;
    
    public BaseDao(){
        clazz = this.getClass();
        Type t = clazz.getGenericSuperclass();
        ParameterizedType pe = (ParameterizedType) t;
        clazz = (Class) pe.getActualTypeArguments()[0];
        System.out.println(clazz);
    }
    
    //添加
    public int add(Entity obj) throws Exception {
        
        Connection con = db.getConn();
        String tables = clazz.getSimpleName();
        Field[] fields = clazz.getDeclaredFields();

        String sql = "insert into " + tables + " values(null";
        for (int i = 1; i < fields.length; i++) {
            sql += ",?";
        }
        sql = sql + ")";

        System.out.println(sql);
        PreparedStatement pstmt = null;
        pstmt = con.prepareStatement(sql);

        for (int i = 1; i < fields.length; i++) {
            String name= "get"+Character.toUpperCase(fields[i].getName().charAt(0));
            name = name + fields[i].getName().substring(1);
            Method m =clazz.getMethod(name);
            Object value= m.invoke(obj);        
            pstmt.setObject(i, value);
        }
        r=pstmt.executeUpdate();
        db.close(pstmt);
        db.close(con);
        return r;
        
    }

    //删除
    public int delete(int id) throws Exception {
        Connection con = db.getConn();
        String tables = clazz.getSimpleName();
        Field[] fields = clazz.getDeclaredFields();
        
        String idName = fields[0].getName();
        
        String sql = "delete  from " + tables + " where "+idName+" ="+id;
        System.out.println(sql);
        PreparedStatement pstmt = null;
        pstmt = con.prepareStatement(sql);
        r=pstmt.executeUpdate();
        db.close(pstmt);
        db.close(con);
        return r;
        
    }

    //更新
    public int update(Entity obj) throws Exception {
        Connection con = db.getConn();
        String tables = clazz.getSimpleName();
        String sql = "update "+tables+" set ";
        Field[] fields = clazz.getDeclaredFields();
        
        String idName = fields[0].getName();
        
        for(int i=1;i<fields.length;i++){
            sql += fields[i].getName() + "=?,";
        }
        sql = sql.substring(0,sql.length()-1)+" where "+idName+" = ?";
        System.out.println(sql);
        PreparedStatement pstmt = null;
        pstmt = con.prepareStatement(sql);
        for(int i =1;i<fields.length;i++){
            String methodName = "get"+Character.toUpperCase(fields[i].getName().charAt(0))+fields[i].getName().substring(1);
            Method m = clazz.getMethod(methodName);
            pstmt.setObject(i,m.invoke(obj));
        }
        
        String FiledFirstName = "get"+Character.toUpperCase(fields[0].getName().charAt(0))+fields[0].getName().substring(1);
        Method m2 = clazz.getMethod(FiledFirstName);
        pstmt.setInt(fields.length, (Integer)m2.invoke(obj));
        r=pstmt.executeUpdate();
        db.close(pstmt);
        return r;        
    }

    //根据id查询
    public Entity get(int id) throws Exception {
        Connection con = db.getConn();
        
        Field[] fields = clazz.getDeclaredFields();
        String idName = fields[0].getName();
        
        String sql = "select * from "+clazz.getSimpleName() + " where "+idName+" =" +id;
        System.out.println(sql);
        PreparedStatement pstmt = null;
        pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        Entity entity =(Entity) clazz.newInstance();
        if(rs.next()){
            //Field[] fields = clazz.getDeclaredFields();
            for(int i=0;i<fields.length;i++){
                String methodName = "set" +Character.toUpperCase(fields[i].getName().charAt(0))+fields[i].getName().substring(1);
                Method m = clazz.getDeclaredMethod(methodName, fields[i].getType());
                Object value = rs.getObject(fields[i].getName());
                System.out.println(methodName + "=========" + value);
                m.invoke(entity, value);
            }
        }
        db.closeAll(rs, pstmt, con);
        return entity;
    }

    //全查
    public List<Entity> getList() throws Exception {
        Connection con = db.getConn();
        String sql = "select * from "+clazz.getSimpleName();
        PreparedStatement pstmt = null;
        pstmt = con.prepareStatement(sql);
        List<Entity> list = new ArrayList<Entity>();
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
            Entity entrty = (Entity)clazz.newInstance();
            Field[] fields = clazz.getDeclaredFields();
            for(int i=0;i<fields.length;i++){
                String methodName = "set"+Character.toUpperCase(fields[i].getName().charAt(0))+fields[i].getName().substring(1);
                Method m = clazz.getMethod(methodName, fields[i].getType());
                m.invoke(entrty, rs.getObject(fields[i].getName()));
            }
            list.add(entrty);
        }
        System.out.println(sql);
        db.closeAll(rs, pstmt, con);
        return list;
    }

}
