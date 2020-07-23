package spring.ioc.model;

import java.util.Objects;

public class MyUser {
    private String email;
    private String pass;

    public MyUser() {
    }

    public MyUser(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyUser myUser = (MyUser) o;
        return Objects.equals(email, myUser.email) &&
                Objects.equals(pass, myUser.pass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, pass);
    }
}
