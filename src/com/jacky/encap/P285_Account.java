package com.jacky.encap;

import com.sun.corba.se.impl.ior.ObjectAdapterIdNumber;

public class P285_Account {
    private String name;
    private int balance;
    private String pwd;

    public P285_Account() {
    }

    public P285_Account(String name, int balance, String pwd) {
        this.setName(name);
        this.setBalance(balance);
        this.setPwd(pwd);
    }

    public String getInfo() {
        return "name " + name + " balance " + balance + " pwd " + pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() == 2 || name.length() == 3 || name.length() == 4) {
            this.name = name;
        } else {
            System.out.println("姓名长度必须是2/3/4");
            this.name = "NONAME";
        }
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        if (balance >= 20) {
            this.balance = balance;
        } else {
            System.out.println("余额必须大于等于20,默认是0");
        }
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        if (pwd.length() == 6) {
            this.pwd = pwd;
        } else {
            System.out.println("密码必须是6位");
            this.pwd = "111111";
        }
    }
}
