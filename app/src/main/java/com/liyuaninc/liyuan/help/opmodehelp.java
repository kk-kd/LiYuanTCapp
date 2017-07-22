package com.liyuaninc.liyuan.help;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.service.voice.AlwaysOnHotwordDetector;
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


    String avalue="";
    String bvalue="";
    String cvalue="";
    String dvalue="";
    private Button X;
    private Button Y;
    private Button A;
    private Button B;
    private Button up;
    private Button left;
    private Button right;
    private Button down;
    private Button change;
    private EditText et1;
    private EditText et2;
    private EditText et3;
    private EditText et4;
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
        change=(Button)findViewById(R.id.view);

        firstinit("X");
        X.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           dialog("X");
            }
        });
        A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog("A");
            }
        });
        Y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog("Y");
            }
        });
        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog("B");
            }
        });
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog("up");
            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog("down");
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog("left");
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog("right");
            }
        });

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(opmodehelp.this,view.class);
                startActivity(intent);
            }
        });




    }

    /*
    * dialog creat a dialog to show all settings
    *
    * firstinit just make sure that none of the value is null
    *
    * init for making the user could see what they setting in the first time
    *
    * save means save the setting
    *
    * load means get the number which user have set just now
    * */
    private void dialog(final String way) {

        LayoutInflater inflater=getLayoutInflater();
        final View layout=inflater.inflate(R.layout.helpdialog, (ViewGroup)findViewById(R.id.dialog));
        et1 = (EditText)layout.findViewById(R.id.valuea);
        et2 = (EditText)layout.findViewById(R.id.valueb);
        et3 = (EditText)layout.findViewById(R.id.valuec);
        et4 = (EditText)layout.findViewById(R.id.valued);
        init(way);
        new AlertDialog.Builder(this).
                setTitle(R.string.title).
                setView(layout).
                setPositiveButton(R.string.yes,
                        new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                cvalue = et3.getText().toString();
                                dvalue = et4.getText().toString();
                                bvalue = et2.getText().toString();
                                avalue = et1.getText().toString();
                                if (avalue!=""){
                                    Save(avalue,"a"+way);
                                }
                                else  Toast.makeText(opmodehelp.this,"anull",LENGTH_SHORT).show();

                                if (bvalue!=""){
                                    Save(bvalue,"b"+way);
                                }
                                else {
                                    Toast.makeText(opmodehelp.this,"bnull",LENGTH_SHORT).show();
                                }
                                if (cvalue!=""){
                                    Save(cvalue,"c"+way);
                                }
                                else  Toast.makeText(opmodehelp.this,"cnull",LENGTH_SHORT).show();
                                if (dvalue!=""){
                                    Save(dvalue,"d"+way);
                                }
                                else  Toast.makeText(opmodehelp.this,"dnull",LENGTH_SHORT).show();
                            }})


                .setNegativeButton(R.string.no, null).show();


    }
    public void firstinit(String way){
        Save(avalue,"a"+way);
        Save(bvalue,"b"+way);
        Save(cvalue,"c"+way);
        Save(dvalue,"d"+way);
        Toast.makeText(opmodehelp.this,"firstinit",LENGTH_SHORT).show();
    }
    public void init(String way){

        avalue= load("a"+way);
        bvalue=load("b"+way);
        cvalue= load("c"+way);
        dvalue=load("d"+way);
        et1.setText(avalue);
        et2.setText(bvalue);
        et3.setText(cvalue);
        et4.setText(dvalue);
        Toast.makeText(opmodehelp.this,"init ok",LENGTH_SHORT).show();
    }
    public void Save (String input, String theway){
        FileOutputStream out=null;
        BufferedWriter writer=null;
        try{out=openFileOutput(theway,MODE_PRIVATE);
            writer=new BufferedWriter(new OutputStreamWriter(out));
            writer.write(input);
           // Toast.makeText(this,theway+"设置成功",Toast.LENGTH_LONG).show();


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
