package com.liyuaninc.liyuan.writecode;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.liyuaninc.liyuan.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class writecode2 extends AppCompatActivity {

    private ImageButton back;
    private ImageButton codeinfo;
    private EditText usercode;
    String code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writecode2);

        codeinfo = (ImageButton)findViewById(R.id.codeinfo);
        back = (ImageButton)findViewById(R.id.backtof6);
        usercode = (EditText)findViewById(R.id.usercode);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        codeinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code = usercode.getText().toString();
                saveTxt(code,writecode2.this,"/sdcard/LiYuan/sendcode/","sendcode.梨园");
                Intent intent = new Intent(writecode2.this, com.liyuaninc.liyuan.writecode.codeinfo.class);
                startActivity(intent);
            }
        });

    }
    //写入文件[sd卡]
    public static boolean saveTxt(String phoneNumber, Context context, String path,String name){
        //sd卡检测
        String sdStatus = Environment.getExternalStorageState();
        if(!sdStatus.equals(Environment.MEDIA_MOUNTED)){
            Toast.makeText(context, "SD 卡不可用", Toast.LENGTH_SHORT).show();
            return false;
        }
        //检测文件夹是否存在
        File file = new File(path);
        file.exists();
        file.mkdirs();
        String p = path+File.separator+name;
        FileOutputStream outputStream = null;
        try {
            //创建文件，并写入内容
            outputStream = new FileOutputStream(new File(p));
            String msg = new String(phoneNumber);
            outputStream.write(msg.getBytes("UTF-8"));
            Toast.makeText(context, "写入成功", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(outputStream!=null){
                try {
                    outputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
    //读取文件[sd卡]
    public static String readPhoneNumber(String path,String name){
        byte Buffer[] = new byte[1024];
        //得到文件输入流
        File file = new File(path+File.separator+name);
        FileInputStream in = null;
        ByteArrayOutputStream outputStream = null;
        try {
            in = new FileInputStream(file);
            //读出来的数据首先放入缓冲区，满了之后再写到字符输出流中
            int len = in.read(Buffer);
            //创建一个字节数组输出流
            outputStream = new ByteArrayOutputStream();
            outputStream.write(Buffer,0,len);
            //把字节输出流转String
            return new String(outputStream.toByteArray());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outputStream!=null){
                try {
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
