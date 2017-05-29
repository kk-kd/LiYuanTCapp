package com.liyuaninc.liyuanopmodehelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class userin extends AppCompatActivity {


    private Button in;
    private Button out;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userin);


        in=(Button)findViewById(R.id.in);
        out=(Button)findViewById(R.id.exit);

        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(userin.this,help.class);
                startActivity(intent);
            }
        });



    }
}
