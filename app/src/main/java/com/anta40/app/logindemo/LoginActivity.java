package com.anta40.app.logindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    PrefStartUp pref;
    EditText edtNama, edtEmail;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtNama = (EditText) findViewById(R.id.edtNama);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sNama = edtNama.getText().toString();
                String sEmail = edtEmail.getText().toString();

                if (sNama.equals("Linus") && (sEmail.equals("linus@kernel.org"))){
                    pref.createLoginSession(sNama, sEmail);
                    Intent iii = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(iii);
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Login gagal. Harap ulangi.", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
