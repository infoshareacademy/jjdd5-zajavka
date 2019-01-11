package com.infoshareacademy.zajavka.data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private int userId;

    @Column(name = "USER_EMAIL")
    @NotNull
    private String userEmail;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_ROLE")
    private int userRole;

    public User() {
    }

    public User(String userEmail, String userPassword, String userName, String userSurname, int userRole) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.userRole = userRole;
    }


    public int getUserId() {
        return userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }
}
