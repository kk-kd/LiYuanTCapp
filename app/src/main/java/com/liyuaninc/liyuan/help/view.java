package com.liyuaninc.liyuan.help;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.liyuaninc.liyuan.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;

public class view extends AppCompatActivity {


    final static String head="package org.firstinspires.ftc.teamcode;\n" +
            "\n" +
            "import com.qualcomm.robotcore.eventloop.opmode.OpMode;\n" +
            "import com.qualcomm.robotcore.eventloop.opmode.TeleOp;\n" +
            "import com.qualcomm.robotcore.hardware.DcMotor;\n" +
            "import com.qualcomm.robotcore.hardware.Servo;\n" +
            "import com.qualcomm.robotcore.util.Range;\n";

    final static String head2="@TeleOp (name = \"TELEOP\")\n" +
            "public class LiYuan_Teleop extends OpMode {\n" +
            "    DcMotor a;\n" +
            "    DcMotor b;\n" +
            "    DcMotor c;\n" +
            "    DcMotor d;\n";

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

    String avaluea="";
    String avalueb="";
    String avaluec="";
    String avalued="";
    String avaluee="";
    String avaluef="";
    String avalueg="";
    String avalueh="";
    String bvaluea="";
    String bvalueb="";
    String bvaluec="";
    String bvalued="";
    String xvaluea="";
    String xvalueb="";
    String xvaluec="";
    String xvalued="";
    String yvaluea="";
    String yvalueb="";
    String yvaluec="";
    String yvalued="";
    String upvaluea="";
    String upvalueb="";
    String upvaluec="";
    String upvalued="";
    String downvaluea="";
    String downvalueb="";
    String downvaluec="";
    String downvalued="";
    String leftvaluea="";
    String leftvalueb="";
    String leftvaluec="";
    String leftvalued="";
    String rightvaluea="";
    String rightvalueb="";
    String rightvaluec="";
    String rightvalued="";


    private Button back;
    private Button robotcontroller;
    private Button savetosd;
    private TextView view;
    private EditText setname;
    private String name;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
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
        setContentView(R.layout.activity_view);

        initsettinga("A");
        initsettingb("B");
        initsettingx("X");
        initsettingy("Y");
        initsettingup("up");
        initsettingdown("down");
        initsettingleft("left");
        initsettingright("right");
        String namea = load("namea");
        String nameb = load("nameb");
        String namec = load("namec");
        String named = load("named");
        String namee = load("namee");
        String namef = load("namef");
        String nameg = load("nameg");
        String nameh = load("nameh");

        final  String init=" @Override\n" +
                "    public void init() {\n" +
                "\n" +
                "        a=hardwareMap.dcMotor.get("+"\""+namea+"\""+");\n" +
                "        b=hardwareMap.dcMotor.get("+"\""+nameb+"\""+");\n" +
                "        c=hardwareMap.dcMotor.get("+"\""+namec+"\""+");\n" +
                "        d=hardwareMap.dcMotor.get("+"\""+named+"\""+");";

       /* String afinal=gamepad1a+"\n"+Motor+"a="+avaluea+";\n"+Motor+"b="+avalueb+";\n"+ Motor+"c="+avaluec+";\n"+Motor+"d="+avalued+";\n"+ "}\n";
        String bfinal=gamepad1b+"\n"+Motor+"a="+bvaluea+";\n"+Motor+"b="+bvalueb+";\n"+ Motor+"c="+bvaluec+";\n"+Motor+"d="+bvalued+";\n"+ "}\n";
        String xfinal=gamepad1x+"\n"+Motor+"a="+xvaluea+";\n"+Motor+"b="+xvalueb+";\n"+ Motor+"c="+xvaluec+";\n"+Motor+"d="+xvalued+";\n"+ "}\n";
        String yfinal=gamepad1y+"\n"+Motor+"a="+yvaluea+";\n"+Motor+"b="+yvalueb+";\n"+Motor+"c="+yvaluec+";\n"+Motor+"d="+yvalued+";\n"+  "}\n";
        String upfinal=gamepad1up+"\n"+Motor+"a="+upvaluea+";\n"+Motor+"b="+upvalueb+";\n"+Motor+"c="+upvaluec+";\n"+Motor+"d="+upvalued+";\n"+ "}\n";
        String downfinal=gamepad1down+"\n"+Motor+"a="+downvaluea+";\n"+Motor+"b="+downvalueb+ ";\n"+Motor+"c="+downvaluec+";\n"+Motor+"d="+downvalued+";\n"+ "}\n";
        String leftfinal=gamepad1left+"\n"+Motor+"a="+leftvaluea+";\n"+Motor+"b="+leftvalueb+ ";\n"+ Motor+"c="+leftvaluec+";\n"+Motor+"d="+leftvalued+";\n"+"}\n";
        String rightfinal=gamepad1right+"\n"+Motor+"a="+rightvaluea+";\n"+Motor+"b="+rightvalueb+";\n"+Motor+"c="+rightvaluec+";\n"+Motor+"d="+rightvalued+";\n"+ "}\n";
*/

        String afinal=checka();
        String bfinal=checkb();
        String xfinal=checkx();
        String yfinal=checky();
        String upfinal=checku();
        String downfinal=checkd();
        String leftfinal=checkl();
        String rightfinal=checkr();

        final String finalprogram=head+head2+init+loop+afinal+bfinal+xfinal+yfinal+upfinal+downfinal+leftfinal+rightfinal+"\n}}";

        back=(Button)findViewById(R.id.back);
        view=(TextView)findViewById(R.id.viewprogramtext);
        savetosd=(Button)findViewById(R.id.savetosd);
        robotcontroller=(Button)findViewById(R.id.controller) ;

        robotcontroller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(view.this,"唔，这个功能梨园开发组还在开发呐",Toast.LENGTH_SHORT).show();
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.this,opmodehelp.class);
                startActivity(intent);
                finish();
            }
        });
        view.setText(finalprogram);

        savetosd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
setname(finalprogram);


             /*大封印术！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
              继续封印！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
              */
                //第二种储存方式
               /* boolean isMounted = Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);

                if (isMounted) {
                    try {
                        writeFileToSDCard("FTCopmodehelp","helpopmode",finalprogram);
                        Toast.makeText(getApplicationContext(), "保存成功",Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(), "保存失败",Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.d("SDCard错误", "未安装SDCard！");
                    Toast.makeText(getApplicationContext(), "SDCard不存在或者为写保护状态",Toast.LENGTH_SHORT).show();
                }*/

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
                        Save(name,"thename");
                       String en=Environment.getExternalStorageState();
                       //获取SDCard状态,如果SDCard插入了手机且为非写保护状态
                      if(en.equals(Environment.MEDIA_MOUNTED)){
                          try {
                              initData(program);
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

    public String checka()
    {
        String afinal=gamepad1a;
        String aa;
        String ab;
        String ac;
        String ad;
        String ae;
        String af;
        String ag;
        String ah;
        String back="\n"+ "}\n";


        if (avaluea!=""){
            aa="\n"+" a.setPower("+avaluea+");";
            afinal=afinal+aa;
        }
        else ;
        if (avalueb!=""){
            ab="\n"+" b.setPower("+avalueb+");";
            afinal=afinal+ab;
        }
        else ;

        if (avaluec!=""){
            ac="\n"+" c.setPower("+avaluec+");";
            afinal=afinal+ac;
        }
        else ;
        if (avalued!=""){
            ad="\n"+" d.setPower("+avalued+");";
            afinal=afinal+ad;
        }
        else ;
        afinal=afinal+back;
        if (avaluee!=""){
            ae="\n"+Motor+"e="+avaluee+";";
            afinal=afinal+ae;
        }
        else ;
        if (avaluef!=""){
            af="\n"+Motor+"f="+avaluef+";";
            afinal=afinal+af;
        }
        else ;
        if (avalueg!=""){
            ag="\n"+Motor+"g="+avalueg+";";
            afinal=afinal+ag;
        }
        else ;
        if (avalueh!=""){
            ah="\n"+Motor+"h="+avalueh+";";
            afinal=afinal+ah;
        }
        else ;
        return afinal;



    }
    public String checkb()
    {
        String bfinal=gamepad1b;
        String a="";
        String b="";
        String c;
        String d;
        String back="\n"+ "}\n";


        if (bvaluea!=""){
            a="\n"+" a.setPower("+bvaluea+");";
            bfinal=bfinal+a;
        }
        else ;
        if (bvalueb!=""){
            b="\n"+" b.setPower("+bvalueb+");";
            bfinal=bfinal+b;
        }
        else ;

        if (bvaluec!=""){
            c="\n"+" c.setPower("+bvaluec+");";
            bfinal=bfinal+c;
        }
        else ;
        if (bvalued!=""){
            d="\n"+" d.setPower("+bvalued+");";
            bfinal=bfinal+d;
        }
        else ;
        bfinal=bfinal+back;


        return bfinal;



    }
    public String checkx()
    {
        String afinal=gamepad1x;
        String aa="";
        String ab="";
        String ac;
        String ad;
        String back="\n"+ "}\n";


        if (xvaluea!=""){
            aa="\n"+" a.setPower("+xvaluea+");";
            afinal=afinal+aa;
        }
        else ;
        if (xvalueb!=""){
            ab="\n"+" b.setPower("+xvalueb+");";
            afinal=afinal+ab;
        }
        else ;

        if (xvaluec!=""){
            ac="\n"+" c.setPower("+xvaluec+");";
            afinal=afinal+ac;
        }
        else ;
        if (xvalued!=""){
            ad="\n"+" d.setPower("+xvalued+");";
            afinal=afinal+ad;
        }
        else ;
        afinal=afinal+back;


        return afinal;



    }

    public String checky()
    {
        String afinal=gamepad1y;
        String aa="";
        String ab="";
        String ac;
        String ad;
        String back="\n"+ "}\n";


        if (yvaluea!=""){
            aa="\n"+" a.setPower("+yvaluea+");";
            afinal=afinal+aa;
        }
        else ;
        if (yvalueb!=""){
            ab="\n"+" b.setPower("+yvalueb+");";
            afinal=afinal+ab;
        }
        else ;

        if (yvaluec!=""){
            ac="\n"+" c.setPower("+yvaluec+");";
            afinal=afinal+ac;
        }
        else ;
        if (yvalued!=""){
            ad="\n"+" d.setPower("+yvalued+");";
            afinal=afinal+ad;
        }
        else ;
        afinal=afinal+back;


        return afinal;



    }

    public String checku()
    {
        String afinal=gamepad1up;
        String aa="";
        String ab="";
        String ac;
        String ad;
        String back="\n"+ "}\n";


        if (upvaluea!=""){
            aa="\n"+" a.setPower("+upvaluea+");";
            afinal=afinal+aa;
        }
        else ;
        if (upvalueb!=""){
            ab="\n"+" b.setPower("+upvalueb+");";
            afinal=afinal+ab;
        }
        else ;

        if (upvaluec!=""){
            ac="\n"+" c.setPower("+upvaluec+");";
            afinal=afinal+ac;
        }
        else ;
        if (upvalued!=""){
            ad="\n"+" d.setPower("+upvalued+");";
            afinal=afinal+ad;
        }
        else ;
        afinal=afinal+back;


        return afinal;



    }

    public String checkd()
    {
        String afinal=gamepad1down;
        String aa="";
        String ab="";
        String ac;
        String ad;
        String back="\n"+ "}\n";


        if (downvaluea!=""){
            aa="\n"+" a.setPower("+downvaluea+");";
            afinal=afinal+aa;
        }
        else ;
        if (downvalueb!=""){
            ab="\n"+"b.setPower("+downvalueb+");";
            afinal=afinal+ab;
        }
        else ;

        if (downvaluec!=""){
            ac="\n"+"c.setPower("+downvaluec+");";
            afinal=afinal+ac;
        }
        else ;
        if (downvalued!=""){
            ad="\n"+"d.setPower("+downvalued+");";
            afinal=afinal+ad;
        }
        else ;
        afinal=afinal+back;


        return afinal;



    }
    public String checkl()
    {
        String afinal=gamepad1left;
        String aa="";
        String ab="";
        String ac;
        String ad;
        String back="\n"+ "}\n";


        if (leftvaluea!=""){
            aa="\n"+" a.setPower("+leftvaluea+");";
            afinal=afinal+aa;
        }
        else ;
        if (leftvalueb!=""){
            ab="\n"+" b.setPower("+leftvalueb+");";
            afinal=afinal+ab;
        }
        else ;

        if (leftvaluec!=""){
            ac="\n"+" c.setPower("+leftvaluec+");";
            afinal=afinal+ac;
        }
        else ;
        if (leftvalued!=""){
            ad="\n"+" d.setPower("+leftvalued+");";
            afinal=afinal+ad;
        }
        else ;
        afinal=afinal+back;


        return afinal;



    }
    public String checkr()
    {
        String afinal=gamepad1right;
        String aa="";
        String ab="";
        String ac;
        String ad;
        String back="\n"+ "}\n";


        if (rightvaluea!=""){
            aa="\n"+" a.setPower("+rightvaluea+");";
            afinal=afinal+aa;
        }
        else ;
        if (rightvalueb!=""){
            ab="\n"+" b.setPower("+rightvalueb+");";
            afinal=afinal+ab;
        }
        else ;

        if (rightvaluec!=""){
            ac="\n"+" c.setPower("+rightvaluec+");";
            afinal=afinal+ac;
        }
        else ;
        if (rightvalued!=""){
            ad="\n"+" d.setPower("+rightvalued+");";
            afinal=afinal+ad;
        }
        else ;
        afinal=afinal+back;


        return afinal;



    }

    public void initsettinga(String way){
        avaluea= load("a"+way);
        avalueb=load("b"+way);
        avaluec= load("c"+way);
        avalued=load("d"+way);
        avaluee=load("e"+way);
        avaluef= load("f"+way);
        avalueg=load("g"+way);
        avalueh= load("h"+way);
    }
    public void initsettingb(String way){
        bvaluea= load("a"+way);
        bvalueb=load("b"+way);
        bvaluec= load("c"+way);
        bvalued=load("d"+way);
    }
    public void initsettingx(String way){
        xvaluea= load("a"+way);
        xvalueb=load("b"+way);
        xvaluec= load("c"+way);
        xvalued=load("d"+way);
    }
    public void initsettingy(String way){
        yvaluea= load("a"+way);
        yvalueb=load("b"+way);
        yvaluec= load("c"+way);
        yvalued=load("d"+way);
    }
    public void initsettingup(String way){
        upvaluea= load("a"+way);
        upvalueb=load("b"+way);
        upvaluec= load("c"+way);
        upvalued=load("d"+way);
    }
    public void initsettingdown(String way){
        downvaluea= load("a"+way);
        downvalueb=load("b"+way);
        downvaluec= load("c"+way);
        downvalued=load("d"+way);
    }
    public void initsettingleft(String way){
        leftvaluea= load("a"+way);
        leftvalueb=load("b"+way);
        leftvaluec= load("c"+way);
        leftvalued=load("d"+way);
    }
    public void initsettingright(String way){
        rightvaluea= load("a"+way);
        rightvalueb=load("b"+way);
        rightvaluec= load("c"+way);
        rightvalued=load("d"+way);
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
    /**
     * 向sdcard中写入文件
     * @param filename 文件名
     * @param content 文件内容
     */
    public void saveToSDCard(String filename,String content) throws Exception{
        File file=new File(Environment.getExternalStorageDirectory(), filename+".java");
        OutputStream out=new FileOutputStream(file);
        out.write(content.getBytes());
        out.close();
    }
    private void writeFileToSDCard(String way,String filename,String content) throws IOException {
        // 比如可以将一个文件作为普通的文档存储，那么先获取系统默认的文档存放根目录
        File parent_path = Environment.getExternalStorageDirectory();

        // 可以建立一个子目录专门存放自己专属文件
        File dir = new File(parent_path.getAbsoluteFile(), way);
        dir.mkdir();

        File file = new File(dir.getAbsoluteFile(), filename+".java");

        Log.d("文件路径", file.getAbsolutePath());

        // 创建这个文件，如果不存在
        file.createNewFile();

        FileOutputStream fos = new FileOutputStream(file);


        byte[] buffer = content.getBytes();

        // 开始写入数据到这个文件。
        fos.write(buffer, 0, buffer.length);
        fos.flush();
        fos.close();

        Log.d("文件写入", "成功");
    }
    private void initData(String content) {
        name = load("thename");
        String filePath = "/sdcard/LiYuan/simulationHelp/"+name+"/";
        String fileName =" LiYuan_Teleop"+".java";
        writeTxtToFile(content, filePath, fileName);
    }
    // 将字符串写入到文本文件中
    public void writeTxtToFile(String strcontent, String filePath, String fileName) {
        //生成文件夹之后，再生成文件，不然会出错
        makeFilePath(filePath, fileName);

        String strFilePath = filePath+fileName;
        // 每次写入时，都换行写
        String strContent = strcontent + "\r\n";
        try {
            File file = new File(strFilePath);
            if (!file.exists()) {
                Log.d("TestFile", "Create the file:" + strFilePath);
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            RandomAccessFile raf = new RandomAccessFile(file, "rwd");
            raf.seek(file.length());
            raf.write(strContent.getBytes());
            raf.close();
        } catch (Exception e) {
            Log.e("TestFile", "Error on write File:" + e);
        }
    }
    // 生成文件
    public File makeFilePath(String filePath, String fileName) {
        File file = null;
        makeRootDirectory(filePath);
        try {
            file = new File(filePath + fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }
    // 生成文件夹
    public static void makeRootDirectory(String filePath) {
        File file = null;
        try {
            file = new File(filePath);
            if (!file.exists()) {
                file.mkdir();
            }
        } catch (Exception e) {
            Log.i("error:", e+"");
        }






}}
