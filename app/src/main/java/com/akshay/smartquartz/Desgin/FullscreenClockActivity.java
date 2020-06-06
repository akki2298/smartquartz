package com.akshay.smartquartz.Desgin;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.akshay.smartquartz.Bean.Bean_clock;
import com.akshay.smartquartz.DB_Helper.DB_Clock;
import com.akshay.smartquartz.R;
import com.akshay.smartquartz.Utility.Constant;

import java.util.ArrayList;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenClockActivity extends AppCompatActivity {
    Button btnclose;
    ImageView ImgClock;
    Button btnCopy;
    Button btnShare;
    ArrayList<Bean_clock> arrayclock;
    DB_Clock dbc;
    Bean_clock bc;
    /**
    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen_clock);

        ImgClock = (ImageView) findViewById(R.id.fullscreen_img);
        btnCopy = (Button) findViewById(R.id.fullscreen_copy);
        btnShare = (Button) findViewById(R.id.fullscreen_share);
        final String ID = getIntent().getStringExtra("ID");
        String image = getIntent().getStringExtra("Title");
        dbc = new DB_Clock(this);
        bc = dbc.selectByID(Integer.parseInt(ID));

        String uri = "@drawable/" + image;
        int imageResource = getResources().getIdentifier(uri, null, getPackageName());
        Drawable res = getResources().getDrawable(imageResource);
        ImgClock.setImageDrawable(res);

        btnCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("copy", bc.getModel_No());
                clipboard.setPrimaryClip(clip);
                Toast.makeText(FullscreenClockActivity.this, "Copied to clipboard", Toast.LENGTH_SHORT).show();

            }
        });
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent share = new Intent();
                share.setAction("android.intent.action.SEND");
                share.setType("text/plain");
                share.putExtra("android.intent.extra.TEXT", "Model No : " + bc.getModel_No() + "\n" + Constant.link);
                startActivity(share);

            }
        });
    }
}
        // Set up the user interaction to manually show or hide the system UI.

        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.



