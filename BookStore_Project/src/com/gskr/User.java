package com.gskr;


// User class performs initializing User details

import java.util.ArrayList;
import java.util.Map;

public class User{

   private final String userName;
   private final int userId;
   private final String emailId;
   private final String password;
   private Map<String, ArrayList<Book>> map;


   // User Constructor
    public User(String userName, int userId, String emailId, String password,Map<String,ArrayList<Book>> map){
        this.userName=userName;
        this.userId=userId;
        this.emailId=emailId;
        this.password=password;
        this.map=map;
    }


    public String getUserName() {
        return userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public int getUserId() {
        return userId;
    }

    public Map<String, ArrayList<Book>> getMap() {
        return map;
    }


}
