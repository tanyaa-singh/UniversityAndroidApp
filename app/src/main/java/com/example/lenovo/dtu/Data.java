package com.example.lenovo.dtu;

/**
 * Created by Lenovo on 26-07-2016.
 */
public class Data {

    private int _id;
    private String name;
    private String course;
    private String phone;
    private String email;
    private String password;

    public Data(){

    }

    public Data(int _id, String course, String name, String phone, String email, String password) {
        this._id = _id;
        this.course = course;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public int get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
