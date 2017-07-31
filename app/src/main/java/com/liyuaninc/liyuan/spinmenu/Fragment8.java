package com.liyuaninc.liyuan.spinmenu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.liyuaninc.liyuan.Login.LoginActivity;
import com.liyuaninc.liyuan.R;
import com.liyuaninc.liyuan.help.opmodehelp;

/**
 *
 */
public class Fragment8 extends Fragment {
private Switch switchclock;
    private TextView text;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.frament_8, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
text=(TextView)getView().findViewById(R.id.startlock) ;
switchclock=(Switch)getView().findViewById(R.id.lockon);
        switchclock.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    text.setText("on");
                    Intent intent = new Intent(getActivity(),LoginActivity.class);
                    startActivity(intent);
                    onStop();
                    //Log.d("sfsfaf","stop");
                }
                else {
                    text.setText("off");
                }
            }
        });

    }

    public static Fragment8 newInstance() {
        Fragment8 fragment8 = new Fragment8();
        return fragment8;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}

