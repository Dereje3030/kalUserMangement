package com.kal.usermangement;

class Users {
    Users(){}
    private String fname;
    private String lname;
    private String uname;
    private String upassword;

    public Users(String fname, String lname, String uname, String upassword, String uphone, String uemail, String ugender) {
        this.fname = fname;
        this.lname = lname;
        this.uname = uname;
        this.upassword = upassword;
        this.uphone = uphone;
        this.uemail = uemail;
        this.ugender = ugender;
    }

    private String uphone;
    private String uemail;
    private String ugender;

    public Users(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}
