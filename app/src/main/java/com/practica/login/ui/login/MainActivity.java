package com.practica.login.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.practica.login.R;
import com.practica.login.model.User;
import com.practica.login.ui.register.RegisterActivity;
import com.practica.login.ui.register.ViewModelRegister;

public class MainActivity extends AppCompatActivity {
    private ViewModelMain vw;
    private Context context;
    private Button btlogin, btpass, btregister;
    private EditText etlogin, etpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configView();
        vw = ViewModelProviders.of(this).get(ViewModelMain.class);
        vw.getUserMutableLiveData().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                i.putExtra("clave", "L");
                startActivity(i);
            }
        });
    }
    public void configView(){
        etlogin = findViewById(R.id.Etlogin);
        etpass = findViewById(R.id.Etpassword);
        btlogin = findViewById(R.id.BtLogin);
        btregister = findViewById(R.id.BtRegister);
        btregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                i.putExtra("clave", "R");
                startActivity(i);
            }
        });
        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vw.readLogin(etlogin.getText().toString(), etpass.getText().toString());
            }
        });
    }
}
