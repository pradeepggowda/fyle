package com.fyle.interview.model.user;

public class UserDto {
    private String user_name;
    private String email_id;
    private String password;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "user_name='" + user_name + '\'' +
                ", email_id='" + email_id + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
