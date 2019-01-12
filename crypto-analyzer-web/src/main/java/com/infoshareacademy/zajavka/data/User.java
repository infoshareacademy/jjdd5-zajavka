package com.infoshareacademy.zajavka.data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @Column(name = "USER_EMAIL" , length = 132)
    @NotNull
    private String userEmail;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_ROLE")
    private Integer userRole;

    public User() {
    }

    public User(@NotNull String userEmail, String userName, Integer userRole) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.userRole = userRole;
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

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "userEmail='" + userEmail + '\'' +
                ", userName='" + userName + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}
