package db;

/**
 * Created by Administrator on 2017/4/29.
 */

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HttpUtils {

    //TODO:修改服务端地址
    private static String PATH;
    private static URL url;
    private static String typeState;
    private static Calendar c = Calendar.getInstance();

    //获取path
    private static String getPath(String state){
        String time = String.valueOf(c.get(Calendar.YEAR)+c.get(Calendar.MONTH)+c.get(Calendar.DAY_OF_MONTH));
        switch (state){
            case "REGISTER":
                PATH = "http://api.webhack.cn/reg/token/liyuan" + time;
                break;
            case "LOGIN":
                PATH = "http://api.webhack.cn/login/token/liyuan" + time;
                break;
            default:
        }
        return PATH;
    }
  //  public HttpUtils() {
   //     super();
  //  }

    // 静态代码块实例化url
    static {
        try {
            url = new URL(getPath(typeState));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送消息体到服务端
     *
     * @param params
     * @param encode
     * @return
     */
    public static String sendPostMessage(Map<String, String> params,
                                         String encode) {
        StringBuilder stringBuilder = new StringBuilder();
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                try {
                    stringBuilder
                            .append(entry.getKey())
                            .append("=")
                            .append(URLEncoder.encode(entry.getValue(), encode))
                            .append("&");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            try {
                HttpURLConnection urlConnection = (HttpURLConnection) url
                        .openConnection();
                urlConnection.setConnectTimeout(3000);
                urlConnection.setRequestMethod("POST"); // 以post请求方式提交
                urlConnection.setDoInput(true); // 读取数据
                urlConnection.setDoOutput(true); // 向服务器写数据
                // 获取上传信息的大小和长度
                byte[] myData = stringBuilder.toString().getBytes();
                // 设置请求体的类型是文本类型,表示当前提交的是文本数据
                urlConnection.setRequestProperty("Content-Type",
                        "application/x-www-form-urlencoded");
                urlConnection.setRequestProperty("Content-Length",
                        String.valueOf(myData.length));
                // 获得输出流，向服务器输出内容
                OutputStream outputStream = urlConnection.getOutputStream();
                // 写入数据
                outputStream.write(myData, 0, myData.length);
                outputStream.close();
                // 获得服务器响应结果和状态码
                int responseCode = urlConnection.getResponseCode();
                if (responseCode == 200) {
                    // 取回响应的结果
                    return changeInputStream(urlConnection.getInputStream(),
                            encode);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return "";
    }

    /**
     * 将一个输入流转换成指定编码的字符串
     *
     * @param inputStream
     * @param encode
     * @return
     */
    private static String changeInputStream(InputStream inputStream,
                                            String encode) {

        // 内存流
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int len = 0;
        String result = null;
        if (inputStream != null) {
            try {
                while ((len = inputStream.read(data)) != -1) {
                    byteArrayOutputStream.write(data, 0, len);
                }
                result = new String(byteArrayOutputStream.toByteArray(), encode);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 上传数据到服务器
     * @param uname
     * @param umail
     * @param upwd
     */
    public void AccessData(String uname, String umail, String upwd, String type){
        typeState = type;
        Map<String, String> map = new HashMap<String, String>();
        map.put("uname", uname);
        map.put("umail", umail);
        map.put("upwd" , upwd);
        String result = sendPostMessage(map, "UTF-8");
        Log.d("HttpUtils",result);
    }

}