package com.liyuaninc.liyuan.settings.rarcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.liyuaninc.liyuan.R;

public class rarcherstart extends AppCompatActivity {

    private String all ="初始化...\n" +
            "启动完成\n" +
            "版本号：7.14\n" +
            "输入run启动Rarcher人格程序>\n";
    private String nowwords;
    private EditText editText;
    private Button send;
    private TextView code;
    private String request;
    private String tocompete;
    private String comrequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitymain);
        editText = (EditText)findViewById(R.id.mingling);
        send = (Button)findViewById(R.id.send);
        code = (TextView)findViewById(R.id.rarchercode);
        code.setText(all);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nowwords ="\n"+"<user>.input:  "+editText.getText().toString();
                tocompete = editText.getText().toString();
                Log.d("tocompete",tocompete);
                comrequest = status(tocompete);
                editText.setText("");
                all = all+nowwords+"\n"+"<Rarcher>.output:  "+comrequest;
                code.setText(all);
            }
        });

    }

    private String status(String words)
    {
        if (words.equals("run"))
        {
            request="正在启动...\n" +
                    "请输入密码 (password)\n";
        }
        else if (words.equals("flyt1121"))
        {
            request="登录成功...\n" +
                    "Rarcher人格程序1.0beta版本测试成功\n";
        }
        else request = "无法识别的命令："+words;
        return request;
    }



}
