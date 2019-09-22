package com.dao;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBTest {
    @Test
    public void test() throws Exception {
        DB db = new DB();
        String sql = "select * from t_admin";
        Object[] params = {};
        try {
            db.doPstm(sql, params);
            System.out.println("changed:"+db.getCount());
            try (ResultSet rs = db.getRs()){
                int n = rs.getMetaData().getColumnCount();
                while (rs.next()) {
                    ArrayList<String> line = new ArrayList<>(n);
                    while (line.size() < n) {
                        line.add(rs.getString(line.size()+1));
                    }
                    System.out.println(line);
                }
            }
        } finally {
            db.closed();
        }


    }
}
