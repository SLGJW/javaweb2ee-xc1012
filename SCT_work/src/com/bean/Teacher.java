package com.bean;

public class Teacher {
    private int tid;
    private String tname;
    private String password;

    public Teacher() {
    }

    public Teacher(int tid, String tname, String password) {
        this.tid = tid;
        this.tname = tname;
        this.password = password;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
