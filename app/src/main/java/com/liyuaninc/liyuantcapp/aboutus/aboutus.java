package com.liyuaninc.liyuantcapp.aboutus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.liyuaninc.liyuantcapp.R;

public class aboutus extends AppCompatActivity {

    private ImageView back;
    private TextView details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        back= (ImageView)findViewById(R.id.backtosetting);
        details = (TextView)findViewById(R.id.details);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        details.setText("关于本程序："+"\n"+"本程序为免费无广告应用，如您发现其中有任何广告或者花钱购买，那么您使用的是盗版。"+"\n"+"本程序不会要求任何敏感的个人信息"
        +"也不会要求任何对您手机或者信息方面造成任何伤害的权限"+"\n"+"本应用欢迎各位转载推荐，但请用以下地址下载以确保使用的是最新官方版本：https://github.com/CandyZQ/LiYuanTCapp"
                +"\n"+"关于作者们："+"\n"+"我们衷心希望能有更多的朋友们一起加入到first系列的比赛中来，但毕竟人力有限，且本应用为已经退役的FIRST系列参赛队员自愿开发，" +
                        "因此，请勿对本应用进行任何篡改，盗版等，如果您想加入我们，请联系梨园开发组，谢谢"
        );
    }
}
