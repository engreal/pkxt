package com.service;

import com.dao.DB;
import com.orm.*;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class loginService {
    public String login(String userName, String userPw, int userType) {
        System.out.println("userType" + userType);
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String result = "no";

        if (userType == 0)//系统管理员登陆
        {
            String sql = "select * from t_admin where username=? and userpwd=?";
            Object[] params = {userName, userPw};
            DB mydb = new DB();
            mydb.doPstm(sql, params);
            try {
                ResultSet rs = mydb.getRs();
                boolean mark = (rs == null || !rs.next() ? false : true);
                if (mark == false) {
                    result = "no";
                } else {
                    result = "yes";
                    if (rs.next()) {
                        TAdmin admin = new TAdmin();
                        admin.setUserId(rs.getInt("id"));
                        admin.setUserName(rs.getString("username"));
                        admin.setUserPw(rs.getString("userpwd"));
                        WebContext ctx = WebContextFactory.get();
                        HttpSession session = ctx.getSession();
                        session.setAttribute("userType", 0);
                        session.setAttribute("admin", admin);
                    }
                }
                rs.close();
            } catch (SQLException e) {
                System.out.println("登录失败！");
                e.printStackTrace();
            } finally {
                mydb.closed();
            }

        }

        if (userType == 1) {
        }
        if (userType == 2) {

        }
        return result;
    }

    public String adminPwEdit(String userPwNew) {
        System.out.println("DDDD");
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        WebContext ctx = WebContextFactory.get();
        HttpSession session = ctx.getSession();
        TAdmin admin = (TAdmin) session.getAttribute("admin");

        String sql = "update t_admin set userPw=? where userId=?";
        Object[] params = {userPwNew, admin.getUserId()};
        DB mydb = new DB();
        mydb.doPstm(sql, params);

        return "yes";
    }

    public List zhuanyeAll() {
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        List zhuanyeList = new ArrayList();
        String sql = "select * from t_zhuanye where del='no'";
        Object[] params = {};
        DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            ResultSet rs = mydb.getRs();
            while (rs.next()) {
                Tzhuanye zhuanye = new Tzhuanye();
                zhuanye.setId(rs.getInt("id"));
                zhuanye.setName(rs.getString("name"));
                zhuanye.setJieshao(rs.getString("jieshao"));
                zhuanyeList.add(zhuanye);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        return zhuanyeList;
    }

    public List banjiAll() {
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        List banjiList = new ArrayList();
        String sql = "select * from t_banji where del='no'";
        Object[] params = {};
        DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            ResultSet rs = mydb.getRs();
            while (rs.next()) {
                Tbanji banji = new Tbanji();
                banji.setId(rs.getInt("id"));
                banji.setName(rs.getString("name"));
                banjiList.add(banji);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        return banjiList;
    }

    public List stuAll() {
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        List stuList = new ArrayList();
        String sql = "select * from t_stu where del='no'";
        Object[] params = {};
        DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            ResultSet rs = mydb.getRs();
            while (rs.next()) {
                Tstu stu = new Tstu();
                stu.setId(rs.getInt("id"));
                stu.setXuehao(rs.getString("xuehao"));
                stuList.add(stu);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        return stuList;
    }

    public List kechengAll() {
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        List kechengList = new ArrayList();
        String sql = "select * from t_kecheng where del='no'";
        Object[] params = {};
        DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            ResultSet rs = mydb.getRs();
            while (rs.next()) {
                Tkecheng kecheng = new Tkecheng();
                kecheng.setId(rs.getInt("id"));
                kecheng.setName(rs.getString("name"));
                kechengList.add(kecheng);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        return kechengList;
    }

    public List teaAll() {
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        List teaList = new ArrayList();
        String sql = "select * from t_tea where del='no'";
        Object[] params = {};
        DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            ResultSet rs = mydb.getRs();
            while (rs.next()) {
                Ttea tea = new Ttea();
                tea.setId(rs.getInt("id"));
                tea.setName(rs.getString("name"));
                teaList.add(tea);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        return teaList;
    }

    public List jiaoshiAll() {
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        List jiaoshiList = new ArrayList();
        String sql = "select * from t_jiaoshi where del='no'";
        Object[] params = {};
        DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            ResultSet rs = mydb.getRs();
            while (rs.next()) {
                Tjiaoshi jiaoshi = new Tjiaoshi();
                jiaoshi.setId(rs.getInt("id"));
                jiaoshi.setName(rs.getString("name"));
                jiaoshiList.add(jiaoshi);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        return jiaoshiList;
    }

    public String xuankeAdd(int stu_id, int kecheng_id) {
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String result = "no";
        String sql = "select * from t_stu_kecheng where stu_id=? and kecheng_id=?";
        Object[] params = {stu_id, kecheng_id};
        DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            ResultSet rs = mydb.getRs();
            if (rs.next() == true) {
                result = "no";
            } else {
                result = "yes";
                String sql1 = "insert into t_stu_kecheng values(?,?)";
                Object[] params1 = {stu_id, kecheng_id};
                mydb.doPstm(sql1, params1);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        return result;
    }

    public String xuankeDel(int stu_id, int kecheng_id) {
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String result = "no";
        String sql = "delete from t_stu_kecheng where stu_id=? and kecheng_id=?";
        Object[] params = {stu_id, kecheng_id};
        DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            int ii = mydb.getCount();
            if (ii == 1) {
                result = "yes";
            } else {
                result = "no";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        return result;
    }

}
