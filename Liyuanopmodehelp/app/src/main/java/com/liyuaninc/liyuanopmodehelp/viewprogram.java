package com.liyuaninc.liyuanopmodehelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class viewprogram extends AppCompatActivity {
    final static String head="package org.firstinspires.ftc.teamcode;\n" +
            "\n" +
            "import com.qualcomm.robotcore.eventloop.opmode.OpMode;\n" +
            "import com.qualcomm.robotcore.eventloop.opmode.TeleOp;\n" +
            "import com.qualcomm.robotcore.hardware.DcMotor;\n" +
            "import com.qualcomm.robotcore.hardware.Servo;\n" +
            "import com.qualcomm.robotcore.util.Range;\n";

    final static String head2="@TeleOp (name = \"TELEOP\")\n" +
            "public class FLYT_Teleop extends OpMode {\n" +
            "    DcMotor a;\n" +
            "    DcMotor b;\n" +
            "    DcMotor c;\n" +
            "    DcMotor d;\n";

    final static String init=" @Override\n" +
            "    public void init() {\n" +
            "\n" +
            "        a=hardwareMap.dcMotor.get(\"a\");\n" +
            "        b=hardwareMap.dcMotor.get(\"b\");\n" +
            "        c=hardwareMap.dcMotor.get(\"c\");\n" +
            "        d=hardwareMap.dcMotor.get(\"d\");";
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
    final static String gamepad1down=" if (gamepad1.dpad_down){";
    final static String Motor="Motor ";
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





    private Button back;
    private TextView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewprogram);

        String avalue=load(infogamepad1a);
        String bvalue=load(infogamepad1b);
        String xvalue=load(infogamepad1x);
        String yvalue=load(infogamepad1y);
        String upvalue=load(infogamepad1up);
        String downvalue=load(infogamepad1down);
        String leftvalue=load(infogamepad1left);
        String rightvalue=load(infogamepad1right);

        String avalueb=load(binfogamepad1a);
        String bvalueb=load(binfogamepad1b);
        String xvalueb=load(binfogamepad1x);
        String yvalueb=load(binfogamepad1y);
        String upvalueb=load(binfogamepad1up);
        String downvalueb=load(binfogamepad1down);
        String leftvalueb=load(binfogamepad1left);
        String rightvalueb=load(binfogamepad1right);

        String avalued=load(dinfogamepad1a);
        String bvalued=load(dinfogamepad1b);
        String xvalued=load(dinfogamepad1x);
        String yvalued=load(dinfogamepad1y);
        String upvalued=load(dinfogamepad1up);
        String downvalued=load(dinfogamepad1down);
        String leftvalued=load(dinfogamepad1left);
        String rightvalued=load(dinfogamepad1right);

        String avaluec=load(cinfogamepad1a);
        String bvaluec=load(cinfogamepad1b);
        String xvaluec=load(cinfogamepad1x);
        String yvaluec=load(cinfogamepad1y);
        String upvaluec=load(cinfogamepad1up);
        String downvaluec=load(cinfogamepad1down);
        String leftvaluec=load(cinfogamepad1left);
        String rightvaluec=load(cinfogamepad1right);

        String afinal=gamepad1a+"\n"+Motor+"a="+avalue+";\n"+Motor+"b="+avalueb+";\n"+ Motor+"c="+avaluec+";\n"+Motor+"d="+avalued+";\n"+ "}\n";
        String bfinal=gamepad1b+"\n"+Motor+"a="+bvalue+";\n"+Motor+"b="+bvalueb+";\n"+ Motor+"c="+bvaluec+";\n"+Motor+"d="+bvalued+";\n"+ "}\n";
        String xfinal=gamepad1x+"\n"+Motor+"a="+xvalue+";\n"+Motor+"b="+xvalueb+";\n"+ Motor+"c="+xvaluec+";\n"+Motor+"d="+xvalued+";\n"+ "}\n";
        String yfinal=gamepad1y+"\n"+Motor+"a="+yvalue+";\n"+Motor+"b="+yvalueb+";\n"+Motor+"c="+yvaluec+";\n"+Motor+"d="+yvalued+";\n"+  "}\n";
        String upfinal=gamepad1up+"\n"+Motor+"a="+upvalue+";\n"+Motor+"b="+upvalueb+";\n"+Motor+"c="+upvaluec+";\n"+Motor+"d="+upvalued+";\n"+ "}\n";
        String downfinal=gamepad1down+"\n"+Motor+"a="+downvalue+";\n"+Motor+"b="+downvalueb+ ";\n"+Motor+"c="+downvaluec+";\n"+Motor+"d="+downvalued+";\n"+ "}\n";
        String leftfinal=gamepad1left+"\n"+Motor+"a="+leftvalue+";\n"+Motor+"b="+leftvalueb+ ";\n"+ Motor+"c="+leftvaluec+";\n"+Motor+"d="+leftvalued+";\n"+"}\n";
        String rightfinal=gamepad1right+"\n"+Motor+"a="+rightvalue+";\n"+Motor+"b="+rightvalueb+";\n"+Motor+"c="+rightvaluec+";\n"+Motor+"d="+rightvalued+";\n"+ "}\n";




        String finalprogram=head+head2+init+loop+afinal+bfinal+xfinal+yfinal+upfinal+downfinal+leftfinal+rightfinal+"\n}}";




        back=(Button)findViewById(R.id.back);
        view=(TextView)findViewById(R.id.viewprogramtext);


       back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewprogram.this,help.class);
                startActivity(intent);
                finish();
            }
        });



        view.setText(finalprogram);









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
