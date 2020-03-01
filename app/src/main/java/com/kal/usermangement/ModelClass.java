package com.kal.usermangement;

import android.provider.BaseColumns;

public class ModelClass {

    private String firstName;
    private String lastName;
    private String userName;
    private  int password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public int getPassword() {
        return password;
    }

    public int getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public ModelClass(String firstName, String lastName, String userName, int password, int phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }

    private  int phone;
    private String email;

    ModelClass(){}

   public static class modelInnerClass implements BaseColumns {
       public static final String tablename = "Personal_info";
       public  static final String coulmnCount="Order";
       public static final String coulmnOne = "first_name";
       public static final String coulmnTwo = "last_name";
       public static final String coulmnThree = "user_name";
       public static final String coulmnFour = "user_pssword";
       public static final String coulmnFive = "user_phone";
       public static final String coulmnSix = "emaile";
       public static final String coulmnSeven = "sex";
   }





}
