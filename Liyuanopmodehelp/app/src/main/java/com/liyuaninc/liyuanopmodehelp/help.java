package com.liyuaninc.liyuanopmodehelp;

import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class help extends AppCompatActivity {
    final static String head="package org.firstinspires.ftc.teamcode;\n" +
            "\n" +
            "import com.qualcomm.robotcore.eventloop.opmode.OpMode;\n" +
            "import com.qualcomm.robotcore.eventloop.opmode.TeleOp;\n" +
            "import com.qualcomm.robotcore.hardware.DcMotor;\n" +
            "import com.qualcomm.robotcore.hardware.Servo;\n" +
            "import com.qualcomm.robotcore.util.Range;";

    final static String head2="@TeleOp (name = \"TELEOP\")\n" +
            "public class FLYT_Teleop extends OpMode {\n" +
            "    DcMotor LB;\n" +
            "    DcMotor LF;\n" +
            "    DcMotor RF;\n" +
            "    DcMotor RB;\n";

    final static String init=" @Override\n" +
            "    public void init() {\n" +
            "\n" +
            "        LB=hardwareMap.dcMotor.get(\"LB\");\n" +
            "        LF=hardwareMap.dcMotor.get(\"LF\");\n" +
            "        RF=hardwareMap.dcMotor.get(\"RF\");\n" +
            "        RB=hardwareMap.dcMotor.get(\"RB\");";
    final static String loop="    }\n" +
            "\n" +
            "    @Override\n" +
            "    public void loop() {\n";
    final static String gamepad1a=" if (gamepad1.a){";
    final static String gamepad1b=" if (gamepad1.b){";
    final static String gamepad1x=" if (gamepad1.x){";
    final static String gamepad1y=" if (gamepad1.y){";
    final static String gamepad1up=" if (gamepad1.dpad_up){";
    final static String gamepad1left=" if (gamepad1.dpad_left){";
    final static String gamepad1right=" if (gamepad1.dpad_right){";
    final static String Motor="Motor";
    final static String infogamepad1a="gamepad1.a";
    final static String infogamepad1b="gamepad1.b";
    final static String infogamepad1x="gamepad1.x";
    final static String infogamepad1y="gamepad1.y";
    final static String infogamepad1up="gamepad1.dpad_up";
    final static String infogamepad1down="gamepad1.dpad_down";
    final static String infogamepad1left="gamepad1.dpad_left";
    final static String infogamepad1right="gamepad1.dpad_right";



    final static String binfogamepad1a="bgamepad1.a";
    final static String binfogamepad1b="bgamepad1.b";
    final static String binfogamepad1x="bgamepad1.x";
    final static String binfogamepad1y="bgamepad1.y";
    final static String binfogamepad1up="bgamepad1.dpad_up";
    final static String binfogamepad1down="bgamepad1.dpad_down";
    final static String binfogamepad1left="bgamepad1.dpad_left";
    final static String binfogamepad1right="bgamepad1.dpad_right";

    final static String cinfogamepad1a="cgamepad1.a";
    final static String cinfogamepad1b="cgamepad1.b";
    final static String cinfogamepad1x="cgamepad1.x";
    final static String cinfogamepad1y="cgamepad1.y";
    final static String cinfogamepad1up="cgamepad1.dpad_up";
    final static String cinfogamepad1down="cgamepad1.dpad_down";
    final static String cinfogamepad1left="cgamepad1.dpad_left";
    final static String cinfogamepad1right="cgamepad1.dpad_right";

    final static String dinfogamepad1a="dgamepad1.a";
    final static String dinfogamepad1b="dgamepad1.b";
    final static String dinfogamepad1x="dgamepad1.x";
    final static String dinfogamepad1y="dgamepad1.y";
    final static String dinfogamepad1up="dgamepad1.dpad_up";
    final static String dinfogamepad1down="dgamepad1.dpad_down";
    final static String dinfogamepad1left="dgamepad1.dpad_left";
    final static String dinfogamepad1right="dgamepad1.dpad_right";
    String infomotoravalue=" ";
    String infomotorbvalue=" ";
    String infomotorcvalue=" ";
    String infomotordvalue=" ";
    String infomotoraname=" ";
    String infomotorbname=" ";
    String infomotorcname=" ";
    String infomotordname=" ";
    String infoway=" ";

    String avalue="0";
    String bvalue="0";
    String cvalue="0";
    String dvalue="0";






    private Button X;
    private Button Y;
    private Button A;
    private Button B;
    private Button up;
    private Button left;
    private Button right;
    private Button down;
    private Button change;
    private TextView nowway;
    private Button finishchange;
    private EditText motora;
    private EditText motorb;
    private EditText motorc;
    private EditText motord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        X=(Button)findViewById(R.id.X);
        Y=(Button)findViewById(R.id.Y);
        A=(Button)findViewById(R.id.A);
        B=(Button)findViewById(R.id.B);
        up=(Button)findViewById(R.id.up);
        down=(Button)findViewById(R.id.down);
        left=(Button)findViewById(R.id.left);
        right=(Button)findViewById(R.id.right);
        change=(Button)findViewById(R.id.change);
        nowway=(TextView)findViewById(R.id.nowway) ;
        finishchange=(Button)findViewById(R.id.finish);
        motora=(EditText)findViewById(R.id.motora);
        motorb=(EditText)findViewById(R.id.bvalue);
        motorc=(EditText)findViewById(R.id.cvalue);
        motord=(EditText)findViewById(R.id.dvalue);
        Save2(avalue,infogamepad1b);
        Save2(avalue,infogamepad1a);
        Save2(avalue,infogamepad1x);
        Save2(avalue,infogamepad1y);
        Save2(avalue,infogamepad1up);
        Save2(avalue,infogamepad1down);
        Save2(avalue,infogamepad1left);
        Save2(avalue,infogamepad1left);

        Save2(bvalue,binfogamepad1b);
        Save2(bvalue,binfogamepad1a);
        Save2(bvalue,binfogamepad1x);
        Save2(bvalue,binfogamepad1y);
        Save2(bvalue,binfogamepad1up);
        Save2(bvalue,binfogamepad1down);
        Save2(bvalue,binfogamepad1left);
        Save2(bvalue,binfogamepad1left);

        Save2(cvalue,cinfogamepad1b);
        Save2(cvalue,cinfogamepad1a);
        Save2(cvalue,cinfogamepad1x);
        Save2(cvalue,cinfogamepad1y);
        Save2(cvalue,cinfogamepad1up);
        Save2(cvalue,cinfogamepad1down);
        Save2(cvalue,cinfogamepad1left);
        Save2(cvalue,cinfogamepad1left);

        Save2(dvalue,dinfogamepad1b);
        Save2(dvalue,dinfogamepad1a);
        Save2(dvalue,dinfogamepad1x);
        Save2(dvalue,dinfogamepad1y);
        Save2(dvalue,dinfogamepad1up);
        Save2(dvalue,dinfogamepad1down);
        Save2(dvalue,dinfogamepad1left);
        Save2(dvalue,dinfogamepad1left);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(help.this,viewprogram.class);
                startActivity(intent);
                finish();
            }
        });


        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String avalueforb;
                String bvalueforb;
                String cvalueforb;
                String dvalueforb;
                bvalueforb=load(binfogamepad1b);
                avalueforb=load(infogamepad1b);
                cvalueforb=load(cinfogamepad1b);
                dvalueforb=load(dinfogamepad1b);
               // Toast.makeText(help.this,avalueforb,Toast.LENGTH_SHORT).show();
                infomotoravalue=avalueforb;
                infomotorbvalue=bvalueforb;
                infomotorcvalue=cvalueforb;
                infomotordvalue=dvalueforb;

                motora.setText(infomotoravalue);
                motorb.setText(infomotorbvalue);
                motorc.setText(infomotorcvalue);
                motord.setText(infomotordvalue);
                nowway.setText(infogamepad1b);

                finishchange.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        avalue=motora.getText().toString();
                        bvalue=motorb.getText().toString();
                        Save(avalue,infogamepad1b);
                        Save(bvalue,binfogamepad1b);
                        cvalue=motord.getText().toString();
                        dvalue=motorc.getText().toString();
                        Save(cvalue,cinfogamepad1b);
                        Save(dvalue,dinfogamepad1b);

                    }
                });



            }
        });

        A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String avaluefora;
                String bvaluefora;
                String cvaluefora;
                String dvaluefora;
              //  String send;
                avaluefora=load(infogamepad1a);
                bvaluefora=load(binfogamepad1a);
                cvaluefora=load(cinfogamepad1a);
                dvaluefora=load(dinfogamepad1a);
                // Toast.makeText(help.this,avalueforb,Toast.LENGTH_SHORT).show();
                infomotoravalue=avaluefora;
                infomotorbvalue=bvaluefora;
                infomotorcvalue=cvaluefora;
                infomotordvalue=dvaluefora;

                motora.setText(infomotoravalue);
                motorb.setText(infomotorbvalue);
                motorc.setText(infomotorcvalue);
                motord.setText(infomotordvalue);
                nowway.setText(infogamepad1a);

                finishchange.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        avalue=motora.getText().toString();
                        bvalue=motorb.getText().toString();
                        Save(avalue,infogamepad1a);
                        Save(bvalue,binfogamepad1a);
                        cvalue=motorc.getText().toString();
                        dvalue=motord.getText().toString();
                        Save(cvalue,cinfogamepad1a);
                        Save(dvalue,dinfogamepad1a);

                    }
                });



            }
        });
        X.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String avalueforx;
                String bvalueforx;
                String cvalueforx;
                String dvalueforx;
                //  String send;
                avalueforx=load(infogamepad1x);
                bvalueforx=load(binfogamepad1x);
                cvalueforx=load(cinfogamepad1x);
                dvalueforx=load(dinfogamepad1x);
                // Toast.makeText(help.this,avalueforb,Toast.LENGTH_SHORT).show();
                infomotoravalue=avalueforx;
                infomotorbvalue=bvalueforx;
                infomotorcvalue=cvalueforx;
                infomotordvalue=dvalueforx;

                motora.setText(infomotoravalue);
                motorb.setText(infomotorbvalue);
                motorc.setText(infomotorcvalue);
                motord.setText(infomotordvalue);
                nowway.setText(infogamepad1x);

                finishchange.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        avalue=motora.getText().toString();
                        bvalue=motorb.getText().toString();
                        Save(avalue,infogamepad1x);
                        Save(bvalue,binfogamepad1x);
                        cvalue=motorc.getText().toString();
                        dvalue=motord.getText().toString();
                        Save(cvalue,cinfogamepad1x);
                        Save(dvalue,dinfogamepad1x);

                    }
                });



            }
        });

        Y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String avaluefory;
                String bvaluefory;
                String cvaluefory;
                String dvaluefory;
                //  String send;
                avaluefory=load(infogamepad1y);
                bvaluefory=load(binfogamepad1y);
                cvaluefory=load(cinfogamepad1y);
                dvaluefory=load(dinfogamepad1y);
                // Toast.makeText(help.this,avalueforb,Toast.LENGTH_SHORT).show();
                infomotordvalue=dvaluefory;
                infomotorcvalue=cvaluefory;
                infomotoravalue=avaluefory;
                infomotorbvalue=bvaluefory;

                motora.setText(infomotoravalue);
                motorb.setText(infomotorbvalue);
                motorc.setText(infomotorcvalue);
                motord.setText(infomotordvalue);
                nowway.setText(infogamepad1y);

                finishchange.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        avalue=motora.getText().toString();
                        bvalue=motorb.getText().toString();
                        Save(avalue,infogamepad1y);
                        Save(bvalue,binfogamepad1y);
                        cvalue=motorc.getText().toString();
                        dvalue=motord.getText().toString();
                        Save(cvalue,cinfogamepad1y);
                        Save(dvalue,dinfogamepad1y);


                    }
                });



            }
        });


        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String avalueforup;
                String bvalueforup;
                String cvalueforup;
                String dvalueforup;
                //  String send;
                avalueforup=load(infogamepad1up);
                bvalueforup=load(binfogamepad1up);
                cvalueforup=load(cinfogamepad1up);
                dvalueforup=load(dinfogamepad1up);
                // Toast.makeText(help.this,avalueforb,Toast.LENGTH_SHORT).show();
                infomotoravalue=avalueforup;
                infomotorbvalue=bvalueforup;
                infomotorcvalue=cvalueforup;
                infomotordvalue=dvalueforup;


                motora.setText(infomotoravalue);
                motorb.setText(infomotorbvalue);
                motord.setText(infomotordvalue);
                motorc.setText(infomotorcvalue);
                nowway.setText(infogamepad1up);

                finishchange.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        avalue=motora.getText().toString();
                        bvalue=motorb.getText().toString();
                        Save(avalue,infogamepad1up);
                        Save(bvalue,binfogamepad1up);
                        cvalue=motorc.getText().toString();
                        dvalue=motord.getText().toString();
                        Save(dvalue,dinfogamepad1up);
                        Save(cvalue,cinfogamepad1up);

                    }
                });



            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String avaluefordown;
                String bvaluefordown;
                String cvaluefordown;
                String dvaluefordown;
                //  String send;
                avaluefordown=load(infogamepad1down);
                bvaluefordown=load(binfogamepad1down);
                cvaluefordown=load(cinfogamepad1down);
                dvaluefordown=load(dinfogamepad1down);
                // Toast.makeText(help.this,avalueforb,Toast.LENGTH_SHORT).show();
                infomotoravalue=avaluefordown;
                infomotorbvalue=bvaluefordown;
                infomotorcvalue=cvaluefordown;
                infomotordvalue=dvaluefordown;

                motora.setText(infomotoravalue);
                motorb.setText(infomotorbvalue);
                motorc.setText(infomotorcvalue);
                motord.setText(infomotordvalue);
                nowway.setText(infogamepad1down);

                finishchange.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        avalue=motora.getText().toString();
                        bvalue=motorb.getText().toString();
                        Save(avalue,infogamepad1down);
                        Save(bvalue,binfogamepad1down);
                        cvalue=motorc.getText().toString();
                        dvalue=motord.getText().toString();
                        Save(cvalue,cinfogamepad1down);
                        Save(dvalue,dinfogamepad1down);
                    }
                });



            }
        });

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String avalueforleft;
                String bvalueforleft;
                String cvalueforleft;
                String dvalueforleft;
                //  String send;
                avalueforleft=load(infogamepad1left);
                bvalueforleft=load(binfogamepad1left);
                cvalueforleft=load(cinfogamepad1left);
                dvalueforleft=load(dinfogamepad1left);
                // Toast.makeText(help.this,avalueforb,Toast.LENGTH_SHORT).show();
                infomotoravalue=avalueforleft;
                infomotorbvalue=bvalueforleft;
                infomotorcvalue=cvalueforleft;
                infomotordvalue=dvalueforleft;

                motora.setText(infomotoravalue);
                motorb.setText(infomotorbvalue);
                motorc.setText(infomotorcvalue);
                motord.setText(infomotordvalue);
                nowway.setText(infogamepad1left);

                finishchange.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        avalue=motora.getText().toString();
                        bvalue=motorb.getText().toString();
                        Save(avalue,infogamepad1left);
                        Save(bvalue,binfogamepad1left);
                        cvalue=motorc.getText().toString();
                        dvalue=motord.getText().toString();
                        Save(cvalue,cinfogamepad1left);
                        Save(dvalue,dinfogamepad1left);
                    }
                });



            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String avalueforright;
                String bvalueforright;
                String cvalueforright;
                String dvalueforright;
                //  String send;
                avalueforright=load(infogamepad1right);
                bvalueforright=load(binfogamepad1right);
                cvalueforright=load(cinfogamepad1right);
                dvalueforright=load(dinfogamepad1right);
                // Toast.makeText(help.this,avalueforb,Toast.LENGTH_SHORT).show();
                infomotoravalue=avalueforright;
                infomotorbvalue=bvalueforright;
                infomotorcvalue=cvalueforright;
                infomotordvalue=dvalueforright;

                motora.setText(infomotoravalue);
                motorb.setText(infomotorbvalue);
                motorc.setText(infomotorcvalue);
                motord.setText(infomotordvalue);
                nowway.setText(infogamepad1right);

                finishchange.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        avalue=motora.getText().toString();
                        bvalue=motorb.getText().toString();
                        Save(avalue,infogamepad1right);
                        Save(bvalue,binfogamepad1right);
                        cvalue=motorc.getText().toString();
                        dvalue=motord.getText().toString();
                        Save(cvalue,cinfogamepad1right);
                        Save(dvalue,dinfogamepad1right);

                    }
                });



            }
        });


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
    public String load(String theway){
        FileInputStream in =null;
        BufferedReader reader =null;
        StringBuilder content =new StringBuilder();
        try {
            in = openFileInput(theway);
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
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
    public void Save2 (String input, String theway){
        FileOutputStream out=null;
        BufferedWriter writer=null;
        try{out=openFileOutput(theway,MODE_PRIVATE);
            writer=new BufferedWriter(new OutputStreamWriter(out));
            writer.write(input);
          //  Toast.makeText(this,theway+"设置成功",Toast.LENGTH_LONG).show();


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
}
