package com.liyuaninc.liyuantcapp.db.local;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2018/6/22.
 */

public class Information extends DataSupport {

    private int id;
    private String title;
    private String context;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
