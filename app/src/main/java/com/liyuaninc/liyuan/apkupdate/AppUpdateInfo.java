package com.liyuaninc.liyuan.apkupdate;

public class AppUpdateInfo {
    private int vercode;        //版本号
    private String vername;        //版本名
    private String url;            //文件位置
    private String appname;        //App名称
    private String apkname;        //安装包名称
    private String uppcontent;    //更新内容
    private String forceUpp;    // 是否强制更新标记

    public String getForceUpp() {
        return forceUpp;
    }

    public void setForceUpp(String forceUpp) {
        this.forceUpp = forceUpp;
    }

    public String getUppcontent() {
        return uppcontent;
    }

    public void setUppcontent(String uppcontent) {
        this.uppcontent = uppcontent;
    }

    public int getVercode() {
        return vercode;
    }

    public void setVercode(int vercode) {
        this.vercode = vercode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVername() {
        return vername;
    }

    public void setVername(String vername) {
        this.vername = vername;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getApkname() {
        return apkname;
    }

    public void setApkname(String apkname) {
        this.apkname = apkname;
    }


    @Override
    public String toString() {
        return "UpdataInfo [vercode=" + vercode + ", url=" + url + ", vername="
                + vername + ", appname=" + appname + ", apkname=" + apkname
                + "]";
    }


}