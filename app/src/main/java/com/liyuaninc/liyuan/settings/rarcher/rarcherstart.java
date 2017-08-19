package com.liyuaninc.liyuan.settings.rarcher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.liyuaninc.liyuan.Login.LoginActivity;
import com.liyuaninc.liyuan.R;
import com.liyuaninc.liyuan.Register.RegisterActivity;
import com.liyuaninc.liyuan.others.Developer_application;
import com.liyuaninc.liyuan.spinmenu.Fragment2;
import com.liyuaninc.liyuan.spinmenu.Fragment5;
import com.liyuaninc.liyuan.spinmenu.Fragment6;
import com.liyuaninc.liyuan.spinmenu.Fragment7;


public class rarcherstart extends AppCompatActivity {

    private String all ="初始化...\n" +
            "加载插件...\n" +
            "版本号：1.1beta\n" +
            "输入run启动梨园控制台>\n";
    private String all2 ="初始化...\n" +
            "加载插件...\n" +
            "版本号：1.1beta\n" +
            "输入run启动梨园控制台>\n";
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
        //屏蔽父控件的触碰
        code.setMovementMethod(ScrollingMovementMethod.getInstance());

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nowwords ="\n"+"<user>.input:  "+editText.getText().toString();
                tocompete = editText.getText().toString();
               // Log.d("tocompete",tocompete);
                comrequest = status(tocompete);
                editText.setText("");
                all = all+nowwords+"\n"+"<Rarcher>.output:  "+comrequest;
                code.setText(all);
            }
        });
        code.getParent().requestDisallowInterceptTouchEvent(true);

    }

    private String status(String words)
    {
        if (words.equals("run"))
        {
            request="\n正在启动...\n" +
                    "输入'help'查看当前可用命令\n";
        }
        else if (words.equals("help"))
        {
            request="\n帮助菜单：\n" +
                    "clr            清屏\n" +
                    "tp             跳转界面\n" +
                    "tips           查看如何使用梨园;\n" +
                    "update         查看更新说明;\n" +
                    "con            获取开发组联系方式;\n";
        }
        else if (words.equals("tp"))
        {
            request="\ndeveloper      查看开发者成员名单;\n" +
                    "login          登录界面\n" +
                    "reg            注册界面\n";
        }
        else if (words.equals("clr"))
        {
            Intent intent = new Intent(rarcherstart.this,rarcherstart.class);
            startActivity(intent);
            finish();
        }
        else if (words.equals("developer"))
        {
            Intent intent = new Intent(rarcherstart.this,Developer_application.class);
            startActivity(intent);
            finish();
        }
        else if (words.equals("login"))
        {
            Intent intent = new Intent(rarcherstart.this,LoginActivity.class);
            startActivity(intent);
            finish();

        }
        else if (words.equals("reg"))
        {
            Intent intent = new Intent(rarcherstart.this,RegisterActivity.class);
            startActivity(intent);
            finish();
        }

        else if (words.equals("tips"))
        {
            request="\n我们的初衷是希望各个队伍能够在一起分享自己的代码，并能够从他人的代码中能够学习到更多的知识，因此我们添加了一个共享代码的功能，也衷心的祝愿中国的tc能够越走越好。在此之外，我们也准备了一些辅助来帮助我们的新队伍来快速的了解并使用我们的代码，关于汉化的问题，之后的汉化都会在梨园这个平台上进行分享。\n";
        }
        else if (words.equals("update"))
        {
            request="\nnow version:   1.1beta\n";
        }
        else if (words.equals("con"))
        {
            request="\n测试组QQ群：636085651\n" +
                    "开发组QQ群：********* 【请使用开发者账号登录或者加入开发组一同完善梨园获取】\n";
        }

        else request = "\n无法识别的命令："+words+"\n";
        return request;
    }



}
