package com.practica.login.ui.register;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.practica.login.R;
import com.practica.login.Request.ApiClient;
import com.practica.login.model.User;

public class ViewModelRegister extends AndroidViewModel {

    public MutableLiveData<User> getUserMutableLiveData() {
        return userMutableLiveData;
    }

    public void setUserMutableLiveData(MutableLiveData<User> userMutableLiveData) {
        this.userMutableLiveData = userMutableLiveData;
    }

    private MutableLiveData<User> userMutableLiveData;
    private Context context;
    public ViewModelRegister(@NonNull Application application) {
        super(application);
        userMutableLiveData = new MutableLiveData<User>();
        context = application.getApplicationContext();
    }
    public void addUser(User user){
        ApiClient.guardar(context, user);
    }
    public void obtenerUser(){
        User us;
        us = ApiClient.leer(context);
        if (us != null){
            userMutableLiveData.setValue(us);
        }
    }
}
