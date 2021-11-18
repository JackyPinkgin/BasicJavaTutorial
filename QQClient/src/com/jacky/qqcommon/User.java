package com.jacky.qqcommon;

import java.io.Serializable;

/**
 * 2021/11/18
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private String userId;
    private String passwd;

    public User(String userId, String passwd) {
        this.userId = userId;
        this.passwd = passwd;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
