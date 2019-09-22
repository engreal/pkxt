package com.action;

import com.dao.DB;
import com.orm.Tkebiao;
import com.service.liuService;
import com.util.Util;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class kebiao_servlet extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String type = req.getParameter("type");

        if (type.endsWith("kebiaoMana")) {
            kebiaoMana(req, res);
        }
        if (type.endsWith("kebiaoAdd")) {
            kebiaoAdd(req, res);
        }
        if (type.endsWith("kebiaoDel")) {
            kebiaoDel(req, res);
        }
        if (type.endsWith("kebiaoSearch")) {
            kebiaoSearch(req, res);
        }
    }

    public void kebiaoAdd(HttpServletRequest req, HttpServletResponse res) {
        String shijian = req.getParameter("shijian");
        String xingqi = "";
        try {
            xingqi = Util.getWeekStr(req.getParameter("shijian"));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String dijijieke = req.getParameter("dijijieke");
        int banji_id = Integer.parseInt(req.getParameter("banji_id"));
        int kecheng_id = Integer.parseInt(req.getParameter("kecheng_id"));
        int tea_id = Integer.parseInt(req.getParameter("tea_id"));
        int jiaoshi_id = Integer.parseInt(req.getParameter("jiaoshi_id"));
        String del = "no";

        boolean b = false;
        String sqlQ = "select * from t_kebiao where shijian=? and dijijieke=? and banji_id=? and kecheng_id=? and tea_id=? and jiaoshi_id=? and del=?";
        Object[] paramsQ = {shijian, dijijieke, banji_id, kecheng_id, tea_id, jiaoshi_id, "no"};
        DB mydbQ = new DB();
        try {
            mydbQ.doPstm(sqlQ, paramsQ);
            ResultSet rsQ = mydbQ.getRs();
            if (rsQ.next() == true) {
                b = true;
            }
            rsQ.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mydbQ.closed();
        System.out.println(b + "^^");
        if (b == true) {
            req.setAttribute("message", "有冲突，请重新录入");
            req.setAttribute("path", "admin/kebiao/kebiaoAdd.jsp");
        } else {
            String sql = "insert into t_kebiao values(?,?,?,?,?,?,?,?)";
            Object[] params = {shijian, xingqi, dijijieke, banji_id, kecheng_id, tea_id, jiaoshi_id, del};
            DB mydb = new DB();
            mydb.doPstm(sql, params);
            mydb.closed();
            req.setAttribute("message", "操作成功");
            req.setAttribute("path", "kebiao?type=kebiaoMana");
        }

        String targetURL = "/common/success.jsp";
        dispatch(targetURL, req, res);
    }

    public void kebiaoDel(HttpServletRequest req, HttpServletResponse res) {
        String sql = "update t_kebiao set del='yes' where id=" + Integer.parseInt(req.getParameter("id"));
        Object[] params = {};
        DB mydb = new DB();
        mydb.doPstm(sql, params);
        mydb.closed();

        req.setAttribute("message", "操作成功");
        req.setAttribute("path", "kebiao?type=kebiaoMana");

        String targetURL = "/common/success.jsp";
        dispatch(targetURL, req, res);
    }

    public void kebiaoMana(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List kebiaoList = new ArrayList();
        String sql = "select * from t_kebiao where del='no'";
        Object[] params = {};
        DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            ResultSet rs = mydb.getRs();
            while (rs.next()) {
                Tkebiao kebiao = new Tkebiao();
                kebiao.setId(rs.getInt("id"));
                kebiao.setShijian(rs.getString("shijian"));
                kebiao.setXingqi(rs.getString("xingqi"));
                kebiao.setDijijieke(rs.getString("dijijieke"));

                kebiao.setBanji_id(rs.getInt("banji_id"));
                kebiao.setKecheng_id(rs.getInt("kecheng_id"));
                kebiao.setTea_id(rs.getInt("tea_id"));
                kebiao.setJiaoshi_id(rs.getInt("jiaoshi_id"));

                kebiao.setBanji_name(liuService.getBanjiName(rs.getInt("banji_id")));
                kebiao.setKecheng_name(liuService.getKechengName(rs.getInt("kecheng_id")));
                kebiao.setTea_name(liuService.getTeaName(rs.getInt("tea_id")));
                kebiao.setJiaoshi_name(liuService.getJiaoshiName(rs.getInt("jiaoshi_id")));
                kebiaoList.add(kebiao);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        System.out.println(kebiaoList.size());
        req.setAttribute("kebiaoList", kebiaoList);
        req.getRequestDispatcher("admin/kebiao/kebiaoMana.jsp").forward(req, res);
    }

    public void kebiaoSearch(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List kebiaoList = new ArrayList();
        String sql = "select * from t_kebiao where del='no' and banji_id=" + Integer.parseInt(req.getParameter("banji_id"));
        Object[] params = {};
        DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            ResultSet rs = mydb.getRs();
            while (rs.next()) {
                Tkebiao kebiao = new Tkebiao();
                kebiao.setId(rs.getInt("id"));
                kebiao.setShijian(rs.getString("shijian"));
                kebiao.setXingqi(rs.getString("xingqi"));
                kebiao.setDijijieke(rs.getString("dijijieke"));

                kebiao.setBanji_id(rs.getInt("banji_id"));
                kebiao.setKecheng_id(rs.getInt("kecheng_id"));
                kebiao.setTea_id(rs.getInt("tea_id"));
                kebiao.setJiaoshi_id(rs.getInt("jiaoshi_id"));

                kebiao.setBanji_name(liuService.getBanjiName(rs.getInt("banji_id")));
                kebiao.setKecheng_name(liuService.getKechengName(rs.getInt("kecheng_id")));
                kebiao.setTea_name(liuService.getTeaName(rs.getInt("tea_id")));
                kebiao.setJiaoshi_name(liuService.getJiaoshiName(rs.getInt("jiaoshi_id")));
                kebiaoList.add(kebiao);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        System.out.println(kebiaoList.size());
        req.setAttribute("kebiaoList", kebiaoList);
        req.getRequestDispatcher("admin/kebiao/kebiaoMana.jsp").forward(req, res);
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
