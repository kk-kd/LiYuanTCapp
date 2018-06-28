package com.liyuaninc.liyuantcapp.db;

/**
 * Created by Administrator on 2017/4/29.
 */

import android.os.Environment;
import android.util.PrintStreamPrinter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 用于get或者post数据
 */
public class FinalNet {
    public static final String TAG = "GetPostUtil Debug";
    /**
     * @param url
     *            传入的url,包括了查询参数
     * @return 返回get后的数据
     */
    public static String sendGet(String url) {
        String result = "";
        // String
        URL realURL = null;
        URLConnection conn = null;
        BufferedReader bufReader = null;
        String line = "";
        try {
            realURL = new URL(url);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("url 格式错误");
        }
        try {
            conn = realURL.openConnection();
            // 设置连接参数...conn.setRequestProperty("xx", "xx");
            conn.setConnectTimeout(10000); // 10s timeout
             conn.setRequestProperty("accept", "*/*");
          //   conn.setRequestProperty("", "");
            conn.connect(); // 连接就把参数送出去了 get方法
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("连接错误");
        }
        try {
            bufReader = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(), "gb2312"));
            while ((line = bufReader.readLine()) != null) {
                result += line + "\n";
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("读取数据错误");
        } finally {
            // 释放资源
            if (bufReader != null) {
                try {
                    bufReader.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
    /**
     * @param url
     * @param param
     *            查询参数 ,形式如 name=xx&age=xx&sex=xx
     * @return
     */
    public static String sendGet(String url, String param)
    {
        return sendGet(url + "?" + param);
    }
    /**
     * @param url
     *            指定的url,不包括查询参数
     * @param param
     *            查询参数 形式如 name=xx&age=xx&sex=xx
     * @return 返回post后的数据
     */
    public static String sendPost(String url, String param) {
        String result = "";
        URL realURL = null;
        BufferedReader bufReader = null;
        // PrintWriter printWriter = null;
        PrintStreamPrinter out = null;
        URLConnection connection = null;
        String line = "";
        try {
            realURL = new URL(url);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            connection = realURL.openConnection();
            // 设置为可输入输出 post的模式,而且在输出之前不能获取输入的数据,否则报错
            connection.setDoOutput(true);
            connection.setDoOutput(true);
            // 已经连接了,所以不能再用connect(),否则报错的
            out = new PrintStreamPrinter(new PrintStream(
                    connection.getOutputStream()));
            out.println(param);
            //
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            bufReader = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(), "gb2312"));
            while ((line = bufReader.readLine()) != null) {
                result += line + "\n";
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // 释放资源
            try {
                if (bufReader != null) {
                    bufReader.close();
                }
                if (out != null) {
                    //
                }
            } catch (IOException e2) {
                // TODO: handle exception
            }
        }
        return result;
    }
    public static void saveFile(String content) {
        File file = new File(Environment.getExternalStorageDirectory()
                .getAbsolutePath(), "file.html");
        if (!file.exists()) {
            try {
                boolean status = file.createNewFile();
                System.out.println("is create new file :" + status);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        PrintWriter pw = null;
        try {
            FileWriter fw = new FileWriter(file);
            // pw = new PrintWriter(new Date() + ".html");
            // pw.println(content);
            fw.write(content);
            fw.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            if (pw != null) {
                pw.close();
            }
        }
    }
}