package com.anta40.app.logindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class WizardActivity extends AppCompatActivity {

    Button btnDone;
    PrefStartUp pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wizard);

        pref = new PrefStartUp(getApplicationContext());
        pref.setFirstTimeLaunch(false);

        btnDone = (Button) findViewById(R.id.btnDone);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iii = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(iii);
                finish();
            }
        });

        if (!pref.isLoggedIn()){

            if (pref.isFirstTimeLaunch()) {
                Intent iii = new Intent(getApplicationContext(), WizardActivity.class);
                startActivity(iii);
                finish();
            }
            else {
                Intent iii = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(iii);
                finish();
            }
        }
        else {
            Intent iii = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(iii);
            finish();
        }
    }
}
