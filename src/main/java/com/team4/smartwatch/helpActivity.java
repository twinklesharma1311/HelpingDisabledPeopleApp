package com.team4.smartwatch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;

public class helpActivity extends Activity implements View.OnClickListener {
    private ImageView emergency;
    private ImageView picture_mode;
    private ImageView talk;
    private ImageView hear;
    private ImageView settings;
    private ImageView userGuide;
    private ImageView customerCare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        emergency = (ImageView) findViewById(R.id.emergency);
        picture_mode = (ImageView) findViewById(R.id.picturemode);
        hear = (ImageView) findViewById(R.id.hear);
        talk = (ImageView) findViewById(R.id.talk);
        settings = (ImageView) findViewById(R.id.settings);
        userGuide = (ImageView) findViewById(R.id.userguide);
        customerCare = (ImageView) findViewById(R.id.customercare);


        emergency.setOnClickListener(this);
        picture_mode.setOnClickListener(this);
        talk.setOnClickListener(this);
        hear.setOnClickListener(this);
        settings.setOnClickListener(this);
        userGuide.setOnClickListener(this);
        customerCare.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.emergency:
                Thread vibrate = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Vibrator mVibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                        mVibrator.vibrate(300);
                    }
                });
                vibrate.start();
                startActivity(new Intent(getApplicationContext(), com.team4.smartwatch.emergency.class));
                break;

            case R.id.picturemode:
                Thread vibrate1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Vibrator mVibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                        mVibrator.vibrate(300);
                    }
                });
                vibrate1.start();
                startActivity(new Intent(getApplicationContext(), PictureMode.class));
                break;
            case R.id.talk:
                Thread vibrate2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Vibrator mVibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                        mVibrator.vibrate(300);
                    }
                });
                vibrate2.start();
                startActivity(new Intent(getApplicationContext(),TalkActivity.class));
                break;
            case R.id.hear:
                Thread vibrate3 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Vibrator mVibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                        mVibrator.vibrate(300);
                    }
                });
                vibrate3.start();
                startActivity(new Intent(getApplicationContext(),HearActivity.class));
                break;
            case R.id.settings:
                Thread vibrate4 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Vibrator mVibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                        mVibrator.vibrate(300);
                    }
                });
                vibrate4.start();
                startActivity(new Intent(getApplicationContext(), SettingsActivty.class));
                break;
            case R.id.userguide:
                Thread vibrate5 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Vibrator mVibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                        mVibrator.vibrate(300);
                    }
                });
                vibrate5.start();
                Intent intent = new Intent(getApplicationContext(),UserGuide.class);
                intent.putExtra("button", "userguide");
                startActivity(intent);
                break;
            case R.id.customercare:
                Thread vibrate6 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Vibrator mVibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                        mVibrator.vibrate(300);
                    }
                });
                vibrate6.start();
                Intent intent1 = new Intent(getApplicationContext(),UserGuide.class);
                intent1.putExtra("button","customercare");
                startActivity(intent1);
                break;
        }
    }
}
