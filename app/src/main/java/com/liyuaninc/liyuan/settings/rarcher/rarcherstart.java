package com.liyuaninc.liyuan.settings.rarcher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.liyuaninc.liyuan.R;
import com.liyuaninc.liyuan.others.Developer_application;


public class rarcherstart extends AppCompatActivity {

    private String all ="初始化...\n" +
            "加载插件...\n" +
            "版本号：7.14\n" +
            "输入run启动Rarcher人格程序>\n";
    private String all2 ="初始化...\n" +
            "加载插件...\n" +
            "版本号：7.14\n" +
            "输入run启动Rarcher人格程序>\n";
    private String nowwords;
    private EditText editText;
    private Button send;
    private TextView code;
    private String request;
    private String tocompete;
    private String comrequest;
    private ScrollView scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activitymain);
        editText = (EditText)findViewById(R.id.mingling);
        send = (Button)findViewById(R.id.send);
        code = (TextView)findViewById(R.id.rarchercode);
        scrollView = (ScrollView)findViewById(R.id.scroll) ;
        code.setText(all);
        code.setMovementMethod(ScrollingMovementMethod.getInstance());

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
        code.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP){
                    scrollView.requestDisallowInterceptTouchEvent(false);
                }else{
                    scrollView.requestDisallowInterceptTouchEvent(true);
                }
                return false;
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
                    "Rarcher人格程序1.0beta版本测试成功\n" +
                    "输入'help'查看当前可用命令\n";


        }
        else if (words.equals("help"))
        {
            request="帮助菜单：\n" +
                    "developer      查看开发者成员名单;\n" +
                    "tips           查看如何使用梨园;\n" +
                    "update         查看更新说明;\n" +
                    "con            获取开发组联系方式;\n";
        }
        else if (words.equals("developer"))
        {
            request="确定转入开发者名单界面\n" +
                    "如果确定请输入'TP-D'并将自动关闭此程序\n" +
                    "不想跳转可直接输入其他命令\n";
        }
        else if (words.equals("TP-D"))
        {
            Intent intent = new Intent(rarcherstart.this,Developer_application.class);
            startActivity(intent);
            finish();
        }
        else if (words.equals("tips"))
        {
            request="我们的初衷是希望各个队伍能够在一起分享自己的代码，并能够从他人的代码中能够学习到更多的知识，因此我们添加了一个共享代码的功能，也衷心的祝愿中国的tc能够越走越好。在此之外，我们也准备了一些辅助来帮助我们的新队伍来快速的了解并使用我们的代码，关于汉化的问题，之后的汉化都会在梨园这个平台上进行分享。\n";
        }
        else if (words.equals("update"))
        {
            request="now version:   1.0beta\n";
        }
        else if (words.equals("con"))
        {
            request="测试组QQ群：636085651\n" +
                    "开发组QQ群：********* 【请使用开发者账号登录或者加入开发组一同完善梨园获取】\n";
        }




        else request = "无法识别的命令："+words+"\n";
        return request;
    }



}
