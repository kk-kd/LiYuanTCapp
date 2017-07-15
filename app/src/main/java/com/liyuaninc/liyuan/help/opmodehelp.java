package com.liyuaninc.liyuan.help;

import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.liyuaninc.liyuan.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static android.widget.Toast.LENGTH_SHORT;

public class opmodehelp extends AppCompatActivity {
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

    String avalue="";
    private Button X;
    private Button Y;
    private Button A;
    private Button B;
    private Button up;
    private Button left;
    private Button right;
    private Button down;
   // private Button change;
  //  private TextView nowway;
  //  private Button finishchange;

    private EditText motorb;
    private EditText motorc;
    private EditText motord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opmodehelp);
        X=(Button)findViewById(R.id.X);
        Y=(Button)findViewById(R.id.Y);
        A=(Button)findViewById(R.id.A);
        B=(Button)findViewById(R.id.B);
        up=(Button)findViewById(R.id.up);
        down=(Button)findViewById(R.id.down);
        left=(Button)findViewById(R.id.left);
        right=(Button)findViewById(R.id.right);


        X.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           dialog("X");
            }
        });



    }
    private void dialog(final String way) {

        LayoutInflater inflater=getLayoutInflater();
        final View layout=inflater.inflate(R.layout.helpdialog, (ViewGroup)findViewById(R.id.dialog));

        new AlertDialog.Builder(this).
                setTitle(R.string.title).
                setView(layout).
                setPositiveButton(R.string.yes,
                        new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText et1 = (EditText)layout.findViewById(R.id.valuea);
                                avalue = et1.getText().toString();
                                if (avalue!=""){
                                    Save(avalue,way);
                                }
                                else ;
                            }})


                .setNegativeButton(R.string.no, null).show();


    }
  /*  private void dialog (final String way){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.helpdialog, (ViewGroup) findViewById(R.id.dialog));


        final EditText motora = new EditText(this);


        new AlertDialog.Builder(this).setTitle(R.string.title).setView(layout)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        avalue=motora.getText().toString();
                        Toast.makeText(opmodehelp.this,avalue,LENGTH_SHORT).show();
                    }
                })
                .setIcon(R.drawable.rarcher)
                .setCancelable(false)
                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })




                .show();

    }*/
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
