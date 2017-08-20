package com.liyuaninc.liyuan.help.opmodeedit;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.liyuaninc.liyuan.R;
import com.liyuaninc.liyuan.tools.Writetosdcard;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class opmode extends AppCompatActivity {

    String thehead="package org.firstinspires.ftc.teamcode;\n" +
            "\n" +
            "import com.qualcomm.robotcore.eventloop.opmode.Disabled;\n" +
            "import com.qualcomm.robotcore.eventloop.opmode.OpMode;\n" +
            "import com.qualcomm.robotcore.eventloop.opmode.TeleOp;\n" +
            "import com.qualcomm.robotcore.hardware.DcMotor;\n" +
            "import com.qualcomm.robotcore.hardware.DcMotorSimple;\n" +
            "import com.qualcomm.robotcore.hardware.Servo;\n" +
            "import com.qualcomm.robotcore.util.Range;\n" +
            "\n" +
            "\n" +
            "\n" +
            "@TeleOp (name=\"hand drive\")\n" +
            "@Disabled\n" +
            "public class LiYuan_Teleop extends OpMode {\n";

    String theinit=" @Override\n" +
            "    public void init() {\n";
    String theloop="  }\n" +
            "\n" +
            "    @Override\n" +
            "    public void loop() {";
    String thelast="\n" +
            "    }\n" +
            "}";
    Writetosdcard writetosdcard = new Writetosdcard();


    private TextView head;
    private TextView init;
    private TextView loop;
    private TextView last;
    private EditText initcode;
    private EditText define;
    private EditText loopcode;
    private ImageButton out;
    private EditText setname;

    private String name;
    private String codeinit;
    private String codedefine;
    private String codeloop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 设置状态栏透明!!!!记得在setContentView之前

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opmode);


        head = (TextView)findViewById(R.id.opcodehead);
        init = (TextView)findViewById(R.id.opcodeinit);
        loop = (TextView)findViewById(R.id.opcodeloop);
        initcode = (EditText)findViewById(R.id.opcodeinitcode);
        define = (EditText)findViewById(R.id.define);
        loopcode = (EditText)findViewById(R.id.opcodeloopcode);
        last = (TextView)findViewById(R.id.last);
        out = (ImageButton)findViewById(R.id.out);

        head.setText(thehead);
        init.setText(theinit);
        loop.setText(theloop);
        last.setText(thelast);
        codeinit = initcode.getText().toString();
        codedefine = define.getText().toString();
        codeloop = loopcode.getText().toString();
        final String finalprogram = thehead+codedefine+theinit+codeinit+theloop+codeloop+thelast;
        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setname(finalprogram);
            }
        });







    }
    private void setname(final String program)
    {
        LayoutInflater inflater=getLayoutInflater();
        final View layout=inflater.inflate(R.layout.setname, (ViewGroup)findViewById(R.id.setthename));
        setname = (EditText)layout.findViewById(R.id.setname);
        new AlertDialog.Builder(this).
                setTitle("请输入你的文件名").
                setCancelable(true).
                setView(layout).
                setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        name = setname.getText().toString();
                        String en= Environment.getExternalStorageState();
                        //获取SDCard状态,如果SDCard插入了手机且为非写保护状态
                        if(en.equals(Environment.MEDIA_MOUNTED)){
                            try {
                               writetosdcard.initData(program, "/sdcard/LiYuan/op_code_Help/"+name+"/",name);
                                Toast.makeText(getApplicationContext(), "保存成功",Toast.LENGTH_SHORT).show();
                            } catch (Exception e) {
                                Toast.makeText(getApplicationContext(), "保存失败",Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            //提示用户SDCard不存在或者为写保护状态
                            Toast.makeText(getApplicationContext(), "SDCard不存在或者为写保护状态",Toast.LENGTH_SHORT).show();
                        }
                    }
                }).show();

    }
    public void Save (String input, String theway){
        FileOutputStream out=null;
        BufferedWriter writer=null;
        try{out=openFileOutput(theway,MODE_PRIVATE);
            writer=new BufferedWriter(new OutputStreamWriter(out));
            writer.write(input);
            Toast.makeText(this,theway+"设置成功",Toast.LENGTH_LONG).show();


        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try{
                if (writer!=null){
                    writer.close();
                }

            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public  String load(String theway){
        FileInputStream in =null;
        BufferedReader reader =null;
        StringBuilder content =new StringBuilder();
        try {
            in = openFileInput(theway);
            reader = new BufferedReader(new InputStreamReader(in));
            String line = " ";
            while ((line=reader.readLine())!=null){
                content.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            if (reader!=null){
                try {
                    reader.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return content.toString();
    }
}
