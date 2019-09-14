package com.anta40.app.logindemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    PrefStartUp pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pref = new PrefStartUp(getApplicationContext());
        HashMap<String, String> login_data = pref.getUserDetails();

        String nama = login_data.get(PrefStartUp.KEY_NAMA);
        String email = login_data.get(PrefStartUp.KEY_EMAIL);

        Toast.makeText(getApplicationContext(), "Nama: "+nama+", email: "+email, Toast.LENGTH_LONG).show();
    }
}
