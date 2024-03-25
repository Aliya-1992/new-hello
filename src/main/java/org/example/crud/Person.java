package org.example.crud;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Person {
    private int id;
    private String userName;
    private String userPass;
    private String userEmail;
    private String userCountry;
    private String pass;
    private String userPass1;

    public String getUserPass1() {
        return userPass1;
    }

    public void setUserPass1(String userPass1) {
        this.userPass1 = userPass1;
    }

    private static ROLE role;


    public static ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public void setUserCountry(String userCountry) {
        this.userCountry = userCountry;
    }
    public enum ROLE{
        USER,ADMIN
    }


    public String hash(String sour) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(sour.getBytes());
            StringBuilder builder = new StringBuilder();
            for (byte b : bytes) {
                builder.append(String.format("%02X", b));
            }
            System.out.println(builder.toString());
            return builder.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}