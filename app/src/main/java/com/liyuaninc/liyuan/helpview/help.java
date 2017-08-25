package com.liyuaninc.liyuan.helpview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.liyuaninc.liyuan.R;
import com.liyuaninc.liyuan.help.opmodehelp;

public class help extends AppCompatActivity {
    private Button goopmodehelp;
    private Button goopmodehelp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        goopmodehelp=(Button)findViewById(R.id.opmodehelp);
        goopmodehelp2 = (Button)findViewById(R.id.opmodehel2);
        goopmodehelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(help.this,opmodehelp.class);
                startActivity(intent);

            }
        });
        goopmodehelp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(help.this,com.liyuaninc.liyuan.help.opmodeedit.opmode.class);
                startActivity(intent2);
            }
        });

    }
}
