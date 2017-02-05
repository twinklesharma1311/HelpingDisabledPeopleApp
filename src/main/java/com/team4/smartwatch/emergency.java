package com.team4.smartwatch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class emergency extends Activity implements View.OnClickListener {

    private ImageView call911;
    private ImageView callcontact;
    private ImageView messagecontact;
    private SharedPreferences sharedPreferences;

    @SuppressWarnings("CHECKPERMISSION")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);

        call911 = (ImageView) findViewById(R.id.call911);
        callcontact = (ImageView) findViewById(R.id.callcontact);
        messagecontact = (ImageView) findViewById(R.id.messagecontact);


        call911.setOnClickListener(this);
        callcontact.setOnClickListener(this);
        messagecontact.setOnClickListener(this);
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
    }


    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.call911:
                Toast.makeText(getApplicationContext(), "Calling 911", Toast.LENGTH_LONG).show();
                try {
                    Thread myThread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Vibrator mVibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                            mVibrator.vibrate(300);

                        }
                    });
                    myThread.start();

                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.fromParts("tel", sharedPreferences.getString("Emergency","+14697209639"), null));
                    startActivity(intent);
                } catch (SecurityException ex) {
                    Toast.makeText(getApplicationContext(), "Call Permission Not Present", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.callcontact:
                Toast.makeText(getApplicationContext(), "Calling " +sharedPreferences.getString("Contact", "+14696849931"), Toast.LENGTH_LONG).show();
                try {
                    Thread myThread = new Thread(new Runnable() {
                        @Override
                        public void run() {

                            Vibrator mVibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                            mVibrator.vibrate(300);

                        }
                    });
                    myThread.start();
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.fromParts("tel", sharedPreferences.getString("Contact", "+14696849931"), null));
                    startActivity(intent);
                } catch (SecurityException ex) {
                    Toast.makeText(getApplicationContext(), "Call Permission Not Present", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.messagecontact:
                Toast.makeText(getApplicationContext(), "Sending SMS to "+ sharedPreferences.getString("Contact", "+14696849931"), Toast.LENGTH_LONG).show();
                Thread myThread = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        Vibrator mVibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                        mVibrator.vibrate(300);

                    }
                });
                myThread.start();
                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra("address", sharedPreferences.getString("Contact", "+14696849931"));
                smsIntent.putExtra("sms_body", "Help! I am in an emergency situation.");
                startActivity(smsIntent);
                break;

            default:
                break;
        }

    }


}
