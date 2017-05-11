package com.liyuaninc.liyuan;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class user extends AppCompatActivity {
    private boolean visibility = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final FloatingActionButton user = (FloatingActionButton) findViewById(R.id.user);
        final FloatingActionButton fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                if (visibility == false) {
                    user.setVisibility(View.VISIBLE);
                    fab1.setVisibility(View.VISIBLE);
                    visibility = true;
                }
                else if (visibility == true){
                    user.setVisibility(View.GONE);
                    fab1.setVisibility(View.GONE);
                    visibility =  false;
                }


            }
        });
    }

}
