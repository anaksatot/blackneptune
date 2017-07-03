package com.blackneptune.entity;

import javax.persistence.*;

/**
 * Created by Admin on 5/2/2017.
 */
@Entity
@Table
public class User {
    @Id
    @Column(name= "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userID;
    @Column(name= "user_name")
    private String userName;
    @Column(name= "password")
    private String password;
    @Column(name= "email")
    private String email;
    @Column(name= "phone")
    private String phone;
    @Column(name= "role")
    private Role role;
    @Column(name= "identificationCode")
    private String identificationCode;

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(String userName, String password, String email, String phone, Role role, String identificationCode) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.identificationCode = identificationCode;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int user_id) {
        this.userID = user_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getIdentificationCode() {
        return identificationCode;
    }

    public void setIdentificationCode(String identificationCode) {
        this.identificationCode = identificationCode;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", role=" + role +
                ", identificationCode='" + identificationCode + '\'' +
                '}';
    }
}
