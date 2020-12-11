package ca.gbc.comp3074.mind_manager_app;

import io.realm.RealmObject;

public class User extends RealmObject {

    private String firstName;
    private String userName;
    private String password;

    public User() {
    }

    public User(String firstName, String userName, String password) {
        this.firstName = firstName;
        this.userName = userName;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}