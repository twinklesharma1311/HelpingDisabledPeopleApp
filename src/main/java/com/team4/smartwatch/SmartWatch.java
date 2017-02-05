package com.team4.smartwatch;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class SmartWatch extends AppCompatActivity {
    private ImageView helpButton;
    private TextView monthAndDate;
    private TextView year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_watch);

        helpButton = (ImageView) findViewById(R.id.helpButton);
        monthAndDate = (TextView) findViewById(R.id.monthAndDate);
        year = (TextView) findViewById(R.id.year);

        long date = System.currentTimeMillis();

        SimpleDateFormat yearformat = new SimpleDateFormat("yyyy");
        year.setText(yearformat.format(date));
        SimpleDateFormat monthanddate = new SimpleDateFormat("MMMM, dd");
        monthAndDate.setText(monthanddate.format(date));


        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread vibrate = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Vibrator mVibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                        mVibrator.vibrate(300);
                    }
                });
                vibrate.start();
                startActivity(new Intent(getApplicationContext(), helpActivity.class));

            }
        });

    }
}
