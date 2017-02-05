package com.team4.smartwatch;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SettingsActivty extends Activity implements View.OnClickListener{
    private Button set911numButton;
    private Button setContactnumButton;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_activty);

        set911numButton = (Button) findViewById(R.id.set911NumButton);
        setContactnumButton = (Button) findViewById(R.id.setContactNumButton);

        set911numButton.setOnClickListener(this);
        setContactnumButton.setOnClickListener(this);
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.set911NumButton:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Emergency Number");
                final EditText input = new EditText(this);
                input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_CLASS_PHONE);
                builder.setView(input);
                final String emergencyNum = sharedPreferences.getString("Emergency","+14697209639");
                input.setText(emergencyNum);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String emergencyNum2 = input.getText().toString();
                        if (!emergencyNum.equals(emergencyNum2)){
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.remove("Emergency");
                            editor.putString("Emergency",emergencyNum2);
                            editor.commit();
                        }
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
                break;
            case R.id.setContactNumButton:
                AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                builder1.setTitle("Emergency Number");
                final EditText input1 = new EditText(this);
                input1.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_CLASS_PHONE);
                builder1.setView(input1);
                final String contactNum = sharedPreferences.getString("Contact","+14696849931");
                input1.setText(contactNum);
                builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String contactNum2 = input1.getText().toString();
                        if (!contactNum.equals(contactNum2)){
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.remove("Contact");
                            editor.putString("Contact",contactNum2);
                            editor.commit();
                        }
                    }
                });
                builder1.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder1.show();
                break;
        }
    }
}
