package com.practica.login.ui.login;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.practica.login.Request.ApiClient;
import com.practica.login.model.User;

public class ViewModelMain extends AndroidViewModel {

    public MutableLiveData<User> getUserMutableLiveData() {
        return userMutableLiveData;
    }

    public void setUserMutableLiveData(MutableLiveData<User> userMutableLiveData) {
        this.userMutableLiveData = userMutableLiveData;
    }

    private MutableLiveData<User> userMutableLiveData;
    private Context context;
    public ViewModelMain(@NonNull Application application) {
        super(application);
        userMutableLiveData = new MutableLiveData<User>();
        context = application.getApplicationContext();
    }
    public  void readUser(User user){
        ApiClient.leer(context);
    }
    public void readLogin (String mail, String pass){
        User us = ApiClient.login(context, mail, pass);
        if (us != null){
            userMutableLiveData.setValue(us);
        }
    }
}
