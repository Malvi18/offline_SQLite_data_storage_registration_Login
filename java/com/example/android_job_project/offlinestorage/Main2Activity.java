package com.example.android_job_project.offlinestorage;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.android_job_project.R;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Fragment fragment=new BlankFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.Frame_Layout,fragment)
                .commit();

    }
}
