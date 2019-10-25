package com.practica.login.ui.register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.practica.login.R;
import com.practica.login.model.User;

public class RegisterActivity extends AppCompatActivity {
    ViewModelRegister vw;
    private TextView etdni, etsurname, etname, etmail, etpass;
    private Button btsave;


    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_register);
        configView();
        Intent i = getIntent();
        String datos = i.getStringExtra("clave");
        vw = ViewModelProviders.of(this).get(ViewModelRegister.class);
        vw.getUserMutableLiveData().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                etdni.setText(user.getDni()+"");
                etsurname.setText(user.getSurname());
                etname.setText(user.getName());
                etmail.setText(user.getMail());
                etpass.setText(user.getPassword());
            }
        });
        if (datos.equals("L")){

            vw.obtenerUser();
        }
    }

    public void configView(){
        etdni = findViewById(R.id.RegEtDni);
        etsurname = findViewById(R.id.RegEtSurname);
        etname = findViewById(R.id.RegEtName);
        etmail = findViewById(R.id.RegEtMail);
        etpass = findViewById(R.id.RegEtPassword);
        btsave = findViewById(R.id.RegBtSave);

        btsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.setDni(Long.parseLong(etdni.getText().toString()));
                user.setSurname(etsurname.getText().toString());
                user.setName(etname.getText().toString());
                user.setMail(etmail.getText().toString());
                user.setPassword(etpass.getText().toString());
                vw.addUser(user);
            }
        });

    }
}
