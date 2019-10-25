package com.practica.login.Request;

import android.content.Context;
import android.content.SharedPreferences;

import com.practica.login.model.User;

public class ApiClient {
    private static SharedPreferences sp;

    private static SharedPreferences connect(Context context){
        if (sp==null){
            sp=context.getSharedPreferences("datas", 0);
        }
        return sp;
    }

    public static void guardar(Context context, User user){
        SharedPreferences sp = connect(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong("dni", user.getDni());
        editor.putString("surname", user.getSurname());
        editor.putString("name", user.getName());
        editor.putString("mail", user.getMail());
        editor.putString("password", user.getPassword());
        editor.commit();
    }

    public static User leer(Context context){
        SharedPreferences sp=connect(context);
        Long dni = sp.getLong("dni", -1);
        String surname = sp.getString("surname", "-1");
        String name = sp.getString("name", "-1");
        String mail = sp.getString("mail", "-1");
        String password = sp.getString("password", "-1");

        User user = new User(dni, surname, name, mail, password);
        return user;
    }

    public static User login(Context context, String mail, String password){
        User user = null;
        SharedPreferences sp = connect(context);
        Long dni=sp.getLong("dni", -1);
        String surname=sp.getString("surname", "-1");
        String name = sp.getString("name", "-1");
        String email = sp.getString("mail", "-1");
        String passw = sp.getString("password", "-1");
        if (mail.equals(email) && password.equals(passw)){
            user = new User(dni, surname, name, email, passw);
        }
        return user;

    }
}
