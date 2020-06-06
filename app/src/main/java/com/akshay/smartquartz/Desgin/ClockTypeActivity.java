package com.akshay.smartquartz.Desgin;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.akshay.smartquartz.Adapter.Adapter_Clock;
import com.akshay.smartquartz.Bean.Bean_clock;
import com.akshay.smartquartz.DB_Helper.DB_Clock;
import com.akshay.smartquartz.R;

import java.util.ArrayList;

public class ClockTypeActivity extends AppCompatActivity {
    RecyclerView rvclocklist;
    ArrayList<Bean_clock> arrayclock;
    Adapter_Clock ac;
    DB_Clock dbc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R .layout.activity_clock_type);

        String type=getIntent().getStringExtra("ClockType");
        String ID=getIntent().getStringExtra("ID");
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setTitle(type);
        rvclocklist = (RecyclerView) findViewById(R.id.clocktype_rv);
        dbc = new DB_Clock(this);
        arrayclock = dbc.SelectAll(Integer.parseInt(ID));

        ac = new Adapter_Clock(this, arrayclock);
        rvclocklist.setAdapter(ac);
        rvclocklist.setLayoutManager(new GridLayoutManager(this,2));

    }
}
