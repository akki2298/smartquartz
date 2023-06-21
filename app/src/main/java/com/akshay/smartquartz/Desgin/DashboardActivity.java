package com.akshay.smartquartz.Desgin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.akshay.smartquartz.R;
import com.akshay.smartquartz.Utility.Constant;


public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    boolean doubleBackToExitPressedOnce = false;

    Button btnDimond,btnGod,btnHeartShape,btnPicture,btnPremium,btnSimple,btnSmall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        btnDimond=(Button)findViewById(R.id.dashbpard_btn_dimond);
        btnGod=(Button)findViewById(R.id.dashbpard_btn_god);
        btnHeartShape=(Button)findViewById(R.id.dashbpard_btn_heart);
        btnPicture=(Button)findViewById(R.id.dashbpard_btn_picture);
        btnPremium=(Button)findViewById(R.id.dashbpard_btn_premium);
        btnSimple=(Button)findViewById(R.id.dashbpard_btn_simple);
        btnSmall=(Button)findViewById(R.id.dashbpard_btn_small);

        btnDimond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(DashboardActivity.this,ClockTypeActivity.class);
                in.putExtra("ClockType","Dimond");
                in.putExtra("ID","1");
                startActivity(in);
            }
        });
        btnGod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(DashboardActivity.this,ClockTypeActivity.class);
                in.putExtra("ClockType","God");
                in.putExtra("ID","2");
                startActivity(in);
            }
        });

        btnHeartShape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(DashboardActivity.this,ClockTypeActivity.class);
                in.putExtra("ClockType","HeartShape");
                in.putExtra("ID","3");
                startActivity(in);
            }
        });
        
        btnPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(DashboardActivity.this,ClockTypeActivity.class);
                in.putExtra("ClockType","Picture");
                in.putExtra("ID","4");
                startActivity(in);
            }
        });
        
        btnPremium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(DashboardActivity.this,ClockTypeActivity.class);
                in.putExtra("ClockType","Premium");
                in.putExtra("ID","5");
                startActivity(in);
            }
        });
        
        btnSimple.setOnClickListener(new View.OnClickListener() {
            //added comment testing
            @Override
            public void onClick(View view) {
                Intent in=new Intent(DashboardActivity.this,ClockTypeActivity.class);
                in.putExtra("ClockType","Simple");
                in.putExtra("ID","6");
                startActivity(in);
            }
        });
        
        btnSmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(DashboardActivity.this,ClockTypeActivity.class);
                in.putExtra("ClockType","Small");
                in.putExtra("ID","7");
                startActivity(in);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
            return;
        }
        if (this.doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Snackbar.make(findViewById(R.id.coordinatorLayout), "Please click BACK again to exit", 0).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                DashboardActivity.this.doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_share) {
            Intent share = new Intent();
            share.setAction("android.intent.action.SEND");
            share.setType("text/plain");
            share.putExtra("android.intent.extra.TEXT", Constant.SharedMessage + "");
            startActivity(share);

            return true;
        }
        if (id == R.id.action_contact) {
            return true;
        }

        if (id == R.id.action_developer) {
            return true;
        }

        if (id == R.id.action_rate) {
            Intent rateintent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + getPackageName()));
            startActivity(rateintent);

        }

        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_about) {
            // Handle the camera action
        } else if (id == R.id.nav_developer) {

        } else if (id == R.id.nav_share) {

        } {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
