package com.team4.smartwatch;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class UserGuide extends Activity {
    private TextView title;
    private TextView description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_guide);

        title = (TextView) findViewById(R.id.userguideText);
        description = (TextView) findViewById(R.id.sampleText);

        String value = "a";
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getString("button");
        }

        if(value.equals("userguide")){
            title.setText("USER GUIDE");
            description.setText("A simple application for disabled people. Click different buttons on the main screen for different options");
        }
        else if(value.equals("customercare")){
            title.setText("CUSTOMER CARE");
            description.setText("Contact Information of the Project Mates");
        }
    }
}
