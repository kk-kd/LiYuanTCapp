package com.liyuaninc.liyuan.spinmenu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.liyuaninc.liyuan.Login.LoginActivity;
import com.liyuaninc.liyuan.R;
import com.liyuaninc.liyuan.alltest;
import com.liyuaninc.liyuan.apkupdate.UpdateVersionController;
import com.liyuaninc.liyuan.toast_styles.TabToast;

import static com.liyuaninc.liyuan.R.id.controller;
import static com.liyuaninc.liyuan.R.id.toast_test;

/**
 *
 */
public class Fragment5 extends Fragment {
    private Button update;
    private Button clean;
    private Button test_update;
    private Button test_toast;
    private Button about;
    private Button news;
    private Button logout;
    private UpdateVersionController controller = null;
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
        View view = inflater.inflate(R.layout.hgz_set_page_layout, container, false);
        update = (Button)view.findViewById(R.id.updatecheck);
        clean = (Button)view.findViewById(R.id.cleanphone);
        test_update = (Button)view.findViewById(R.id.test_uptade);
        test_toast = (Button)view.findViewById(R.id.test_toast);
        about = (Button)view.findViewById(R.id.about);
        logout = (Button)view.findViewById(R.id.logout);
        news = (Button)view.findViewById(R.id.news);
        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (null == controller) {
            controller = UpdateVersionController.getInstance(getContext());
        }

        //用户要清除缓存，用户最大咯
        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TabToast.makeText(getContext(),"成功");
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.normalCheckUpdateInfo();
            }
        });

        test_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),com.liyuaninc.liyuan.test.toast_test.class);
                startActivity(intent);
            }
        });

        test_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),alltest.class);
                startActivity(intent);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  TabToast.makeText(getContext(),"恩，暂时没什么想说的，内测了再说吧");
                AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
                dialog.setTitle("关于梨园");
                dialog.setCancelable(false);
                dialog.setMessage("版本号：内测beta1.0\n" +
                        "\n开发组成员：Rarcher，糖果，李白白，Ricky，杏儿\n" +
                        "\n反馈QQ群：636085651[TCapp测试组]\n" +
                        "\n加入我们：联系糖果[473485069]或者联系Rarcher[2553263392]或者联系李白白[1344856276]" );
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog.show();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);

            }
        });

        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
                dialog.setTitle("更新");
                dialog.setCancelable(false);
                dialog.setMessage("更新了个蛇皮，老老实实看戏吧" );
                dialog.setPositiveButton("辣鸡Rarcher，看戏去了", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog.show();
            }
        });


    }

    public static Fragment5 newInstance() {
        Fragment5 fragment5 = new Fragment5();
        return fragment5;
    }
}

