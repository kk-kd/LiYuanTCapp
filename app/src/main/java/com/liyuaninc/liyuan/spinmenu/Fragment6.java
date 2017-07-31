package com.liyuaninc.liyuan.spinmenu;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.liyuaninc.liyuan.R;

import java.util.ArrayList;
import java.util.List;

import db.file;

/**
 */
public class Fragment6 extends Fragment {

    private ListView listvie;
    private ArrayAdapter<String> adapter;
    private List<String> datalist=new ArrayList<>();
    private List<file> data;
    private file selected;

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
        listvie=(ListView)getView().findViewById(R.id.listview);
        adapter = new ArrayAdapter<>(getContext(),R.layout.frament_6,datalist);
        listvie.setAdapter(adapter);
        return inflater.inflate(R.layout.frament_6, container, false);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
listvie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        selected = data.get(position);

    }
});
    }

    public static Fragment4 newInstance() {
        Fragment4 fragment6 = new Fragment4();
        return fragment6;
    }

    private void querydata(){

    }



}

