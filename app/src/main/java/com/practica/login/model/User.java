package com.practica.login.model;

public class User {

    private long dni;
    private String surname;
    private String name;
    private String mail;
    private String password;

    public User(long dni, String surname, String name, String mail, String password){
        this.dni = dni;
        this.surname = surname;
        this.name = name;
        this.mail = mail;
        this.password = password;
    }

    public User(){}

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString(){
        return "User{" +
                "dni=" + dni +
                "surname=" + surname + '\'' +
                "name=" + name + '\'' +
                "mail=" + mail + '\'' +
                "password=" + password + '\'' +
                '}';
    }
}
