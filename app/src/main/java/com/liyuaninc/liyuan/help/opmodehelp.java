package com.liyuaninc.liyuan.help;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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
    String evalue="";
    String fvalue="";
    String gvalue="";
    String hvalue="";


    private Button X;
    private Button Y;
    private Button A;
    private Button B;
    private Button up;
    private Button left;
    private Button right;
    private Button down;
    private ImageButton change;
    private ImageButton setting;
    //dialog显示的名字
    private TextView dianamea;
    private TextView dianameb;
    private TextView dianamec;
    private TextView dianamed;
    private TextView dianamee;
    private TextView dianamef;
    private TextView dianameg;
    private TextView dianameh;
    //用户设置的名字
    private EditText aname;
    private EditText bname;
    private EditText cname;
    private EditText dname;
    private EditText ename;
    private EditText fname;
    private EditText gname;
    private EditText hname;

    private EditText et1;
    private EditText et2;
    private EditText et3;
    private EditText et4;
    private EditText et5;
    private EditText et6;
    private EditText et7;
    private EditText et8;
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
        setContentView(R.layout.activity_opmodehelp);
        X=(Button)findViewById(R.id.X);
        Y=(Button)findViewById(R.id.Y);
        A=(Button)findViewById(R.id.A);
        B=(Button)findViewById(R.id.B);
        up=(Button)findViewById(R.id.up);
        down=(Button)findViewById(R.id.down);
        left=(Button)findViewById(R.id.left);
        right=(Button)findViewById(R.id.right);
        setting=(ImageButton)findViewById(R.id.setting);
        change=(ImageButton)findViewById(R.id.view);


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
                finish();
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogsetting();
            }
        });
    }
    private void dialog(final String way) {

        LayoutInflater inflater=getLayoutInflater();
        final View layout=inflater.inflate(R.layout.helpdialog, (ViewGroup)findViewById(R.id.dialog));
        et1 = (EditText)layout.findViewById(R.id.valuea);
        et2 = (EditText)layout.findViewById(R.id.valueb);
        et3 = (EditText)layout.findViewById(R.id.valuec);
        et4 = (EditText)layout.findViewById(R.id.valued);
        et5 = (EditText)layout.findViewById(R.id.valuee);
        et6 = (EditText)layout.findViewById(R.id.valuef);
        et7 = (EditText)layout.findViewById(R.id.valueg);
        et8 = (EditText)layout.findViewById(R.id.valueh);
        dianamea = (TextView)layout.findViewById(R.id.dianamea);
        dianameb = (TextView)layout.findViewById(R.id.dianameb);
        dianamec = (TextView)layout.findViewById(R.id.dianamec);
        dianamed = (TextView)layout.findViewById(R.id.dianamed);
        dianamee = (TextView)layout.findViewById(R.id.dianamee);
        dianamef = (TextView)layout.findViewById(R.id.dianamef);
        dianameg = (TextView)layout.findViewById(R.id.dianameg);
        dianameh = (TextView)layout.findViewById(R.id.dianameh);




        init(way);
        new AlertDialog.Builder(this).
                setTitle(R.string.title).
                setCancelable(false).
                setView(layout).
                setPositiveButton(R.string.yes,
                        new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                cvalue = et3.getText().toString();
                                dvalue = et4.getText().toString();
                                bvalue = et2.getText().toString();
                                avalue = et1.getText().toString();
                                evalue = et5.getText().toString();
                                fvalue = et6.getText().toString();
                                gvalue = et7.getText().toString();
                                hvalue = et8.getText().toString();
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
                                if (evalue!=""){
                                    Save(evalue,"e"+way);
                                }
                                else  Toast.makeText(opmodehelp.this,"enull",LENGTH_SHORT).show();
                                if (fvalue!=""){
                                    Save(fvalue,"f"+way);
                                }
                                else  Toast.makeText(opmodehelp.this,"fnull",LENGTH_SHORT).show();
                                if (gvalue!=""){
                                    Save(gvalue,"g"+way);
                                }
                                else  Toast.makeText(opmodehelp.this,"gnull",LENGTH_SHORT).show();
                                if (hvalue!=""){
                                    Save(hvalue,"h"+way);
                                }
                                else  Toast.makeText(opmodehelp.this,"hnull",LENGTH_SHORT).show();
                            }})


                .setNegativeButton(R.string.no, null).show();
    }
    private void dialogsetting()
    {
        LayoutInflater inflater=getLayoutInflater();
        final View layout=inflater.inflate(R.layout.opmodehelpsetting, (ViewGroup)findViewById(R.id.dialogsetting));
        aname = (EditText)layout.findViewById(R.id.aname);
        bname = (EditText)layout.findViewById(R.id.bname);
        cname = (EditText)layout.findViewById(R.id.cname);
        dname = (EditText)layout.findViewById(R.id.dname);
        ename = (EditText)layout.findViewById(R.id.ename);
        fname = (EditText)layout.findViewById(R.id.fname);
        gname = (EditText)layout.findViewById(R.id.gname);
        hname = (EditText)layout.findViewById(R.id.hname);
        new AlertDialog.Builder(this).
                setTitle("请配置你的电机名字").
                setCancelable(false).
                setView(layout).
                setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String namea = aname.getText().toString();
                        String nameb = bname.getText().toString();
                        String namec = cname.getText().toString();
                        String named = dname.getText().toString();
                        String namee = ename.getText().toString();
                        String namef = fname.getText().toString();
                        String nameg = gname.getText().toString();
                        String nameh = hname.getText().toString();
                        Save(namea,"namea");
                        Save(nameb,"nameb");
                        Save(namec,"namec");
                        Save(named,"named");
                        Save(namee,"namee");
                        Save(namef,"namef");
                        Save(nameg,"nameg");
                        Save(nameh,"nameh");

                    }
                }).setNegativeButton(R.string.no, null).show();
    }
    public void firstinit(String way){
        Save(avalue,"a"+way);
        Save(bvalue,"b"+way);
        Save(cvalue,"c"+way);
        Save(dvalue,"d"+way);
        Toast.makeText(opmodehelp.this,"firstinit",LENGTH_SHORT).show();
    }
    public void init(String way){
        String namea = load("namea");
        String nameb = load("nameb");
        String namec = load("namec");
        String named = load("named");
        String namee = load("namee");
        String namef = load("namef");
        String nameg = load("nameg");
        String nameh = load("nameh");
        if (namea!="")
        {
            dianamea.setText("Motor "+namea);
        }
        if (nameb!="")
        {
            dianameb.setText("Motor "+nameb);
        }
        if (namec!="")
        {
            dianamec.setText("Motor "+namec);
        }
        if (named!="")
        {
            dianamed.setText("Motor "+named);
        }
        if (namee!="")
        {
            dianamee.setText("Motor "+namee);
        }
        if (namef!="")
        {
            dianamef.setText("Motor "+namef);
        }
        if (nameg!="")
        {
            dianameg.setText("Motor "+nameg);
        }
        if (nameh!="")
        {
            dianameh.setText("Motor "+nameh);
        }

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
