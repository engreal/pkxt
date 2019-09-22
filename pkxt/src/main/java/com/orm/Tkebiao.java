package com.orm;

public class Tkebiao {
    private int id;
    private String shijian;
    private String xingqi;
    private String dijijieke;

    private int banji_id;
    private int kecheng_id;
    private int tea_id;
    private int jiaoshi_id;

    private String banji_name;
    private String kecheng_name;
    private String tea_name;
    private String jiaoshi_name;

    public int getBanji_id() {
        return banji_id;
    }

    public void setBanji_id(int banji_id) {
        this.banji_id = banji_id;
    }

    public String getBanji_name() {
        return banji_name;
    }

    public void setBanji_name(String banji_name) {
        this.banji_name = banji_name;
    }

    public String getDijijieke() {
        return dijijieke;
    }

    public void setDijijieke(String dijijieke) {
        this.dijijieke = dijijieke;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJiaoshi_id() {
        return jiaoshi_id;
    }

    public void setJiaoshi_id(int jiaoshi_id) {
        this.jiaoshi_id = jiaoshi_id;
    }

    public String getJiaoshi_name() {
        return jiaoshi_name;
    }

    public void setJiaoshi_name(String jiaoshi_name) {
        this.jiaoshi_name = jiaoshi_name;
    }

    public int getKecheng_id() {
        return kecheng_id;
    }

    public void setKecheng_id(int kecheng_id) {
        this.kecheng_id = kecheng_id;
    }

    public String getKecheng_name() {
        return kecheng_name;
    }

    public void setKecheng_name(String kecheng_name) {
        this.kecheng_name = kecheng_name;
    }

    public String getShijian() {
        return shijian;
    }

    public void setShijian(String shijian) {
        this.shijian = shijian;
    }

    public int getTea_id() {
        return tea_id;
    }

    public void setTea_id(int tea_id) {
        this.tea_id = tea_id;
    }

    public String getTea_name() {
        return tea_name;
    }

    public void setTea_name(String tea_name) {
        this.tea_name = tea_name;
    }

    public String getXingqi() {
        return xingqi;
    }

    public void setXingqi(String xingqi) {
        this.xingqi = xingqi;
    }

}
