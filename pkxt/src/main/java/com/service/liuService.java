package com.service;

import com.dao.DB;

import java.sql.ResultSet;

public class liuService {
    public static String getZhuanyeName(int id) {
        String zhuanye_name = "";

        String sql = "select * from t_zhuanye where id=" + id;
        Object[] params = {};
        DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            ResultSet rs = mydb.getRs();
            rs.next();
            zhuanye_name = rs.getString("name");
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        return zhuanye_name;
    }

    public static String getBanjiName(int id) {
        String name = "";

        String sql = "select * from t_banji where id=" + id;
        Object[] params = {};
        DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            ResultSet rs = mydb.getRs();
            rs.next();
            name = rs.getString("name");
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        return name;
    }

    public static String getStuXuehao(int id) {
        String xuehao = "";

        String sql = "select * from t_stu where id=" + id;
        Object[] params = {};
        DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            ResultSet rs = mydb.getRs();
            rs.next();
            xuehao = rs.getString("xuehao");
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        return xuehao;
    }

    public static String getKechengName(int id) {
        String name = "";

        String sql = "select * from t_kecheng where id=" + id;
        Object[] params = {};
        DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            ResultSet rs = mydb.getRs();
            rs.next();
            name = rs.getString("name");
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        return name;
    }

    public static String getTeaName(int id) {
        String name = "";

        String sql = "select * from t_tea where id=" + id;
        Object[] params = {};
        DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            ResultSet rs = mydb.getRs();
            rs.next();
            name = rs.getString("name");
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        return name;
    }

    public static String getJiaoshiName(int id) {
        String name = "";

        String sql = "select * from t_jiaoshi where id=" + id;
        Object[] params = {};
        DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            ResultSet rs = mydb.getRs();
            rs.next();
            name = rs.getString("name");
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        return name;
    }

}
