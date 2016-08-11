package com.example.cass.rongapplication.beans;

import android.app.Service;

/**
 * Created by Cass on 2016/8/10.
 */
public class Friend {
    private String userid;
    private String name;
    private String photo;

    public Friend(String userid, String name, String photo) {
        this.userid = userid;
        this.name = name;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
