package com.utils;
import java.sql.*;

public class DBUtil {
    static String url = "jdbc:mysql://localhost:3306/cicps?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
    static String username = "root";
    static String password = "123456";
    static Connection  conn = null;
    static ResultSet rs = null;
    static PreparedStatement ps =null;
    static Statement stmt=null;
    public static void init(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            System.out.println("init [SQL驱动程序初始化失败！]");
            e.printStackTrace();
        }
    }
    public static int addUpdDel(String sql){
        int i = 0;
        try {
            PreparedStatement ps =  conn.prepareStatement(sql);
            i =  ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("sql数据库增删改异常");
            e.printStackTrace();
        }

        return i;
    }
    public static ResultSet selectSql(String sql){
        try {
            stmt=conn.createStatement();
            rs =  stmt.executeQuery(sql);
        } catch (Exception e) {
            System.out.println("sql数据库查询异常");
            e.printStackTrace();
        }
        return rs;
    }
    public static void closeConn(){
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("sql数据库关闭异常");
            e.printStackTrace();
        }
    }
}

