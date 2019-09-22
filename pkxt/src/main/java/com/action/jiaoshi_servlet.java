package com.action;

import com.dao.DB;
import com.orm.Tjiaoshi;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class jiaoshi_servlet extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String type = req.getParameter("type");

        if (type.endsWith("jiaoshiMana")) {
            jiaoshiMana(req, res);
        }
        if (type.endsWith("jiaoshiAdd")) {
            jiaoshiAdd(req, res);
        }
        if (type.endsWith("jiaoshiDel")) {
            jiaoshiDel(req, res);
        }
        if (type.endsWith("jiaoshiEdit")) {
            jiaoshiEdit(req, res);
        }
    }

    public void jiaoshiAdd(HttpServletRequest req, HttpServletResponse res) {
        String name = req.getParameter("name");
        String del = "no";
        String sql = "insert into t_jiaoshi values(?,?)";
        Object[] params = {name, del};
        DB mydb = new DB();
        mydb.doPstm(sql, params);
        mydb.closed();

        req.setAttribute("message", "操作成功");
        req.setAttribute("path", "jiaoshi?type=jiaoshiMana");

        String targetURL = "/common/success.jsp";
        dispatch(targetURL, req, res);
    }

    public void jiaoshiDel(HttpServletRequest req, HttpServletResponse res) {
        String sql = "update t_jiaoshi set del='yes' where id=" + Integer.parseInt(req.getParameter("id"));
        Object[] params = {};
        DB mydb = new DB();
        mydb.doPstm(sql, params);
        mydb.closed();

        req.setAttribute("message", "操作成功");
        req.setAttribute("path", "jiaoshi?type=jiaoshiMana");

        String targetURL = "/common/success.jsp";
        dispatch(targetURL, req, res);
    }

    public void jiaoshiMana(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
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

        req.setAttribute("jiaoshiList", jiaoshiList);
        req.getRequestDispatcher("admin/jiaoshi/jiaoshiMana.jsp").forward(req, res);
    }

    public void jiaoshiEdit(HttpServletRequest req, HttpServletResponse res) {
        int id = Integer.parseInt(req.getParameter("id"));

        String name = req.getParameter("name");

        String sql = "update t_jiaoshi set name=? where id=?";
        Object[] params = {name, id};
        DB mydb = new DB();
        mydb.doPstm(sql, params);
        mydb.closed();

        req.setAttribute("message", "操作成功");
        req.setAttribute("path", "jiaoshi?type=jiaoshiMana");

        String targetURL = "/common/success.jsp";
        dispatch(targetURL, req, res);
    }

    public void dispatch(String targetURI, HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatch = getServletContext().getRequestDispatcher(targetURI);
        try {
            dispatch.forward(request, response);
            return;
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void destroy() {

    }
}
