package com.erif.toastyledemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.erif.toastyledemo.helper.AdapterRecyclerView;
import com.erif.toastyledemo.helper.MainActivityHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] titles;
    private MainActivityHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new MainActivityHelper(this);

        RecyclerView recyclerView = findViewById(R.id.act_main_recyclerView);
        AdapterRecyclerView adapter = new AdapterRecyclerView(callback());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        titles = new String[]{
                "Basic", "Text Color", "Icon Left", "Icon Right", "With Border", "Corner Radius",
                "Corner Radius (Custom)", "Background Color" , "Font Family", "With State", "Position"
        };
        List<String> list = new ArrayList<>(Arrays.asList(titles));
        adapter.setList(list);

    }

    private AdapterRecyclerView.Callback callback() {
        return message -> {
            if (message.equals(titles[0])) {
                helper.toastBasic();
            } else if (message.equals(titles[1])) {
                helper.toastTextColor();
            } else if (message.equals(titles[2])) {
                helper.toastIconLeft();
            } else if (message.equals(titles[3])) {
                helper.toastIconRight();
            } else if (message.equals(titles[4])) {
                helper.toastBorder();
            } else if (message.equals(titles[5])) {
                helper.toastCorner();
            } else if (message.equals(titles[6])) {
                helper.toastCornerCustom();
            } else if (message.equals(titles[7])) {
                helper.toastBackground();
            } else if (message.equals(titles[8])) {
                helper.toastFont();
            } else if (message.equals(titles[9])) {
                helper.toastState();
            } else if (message.equals(titles[10])) {
                helper.toastPosition();
            }
        };
    }

}