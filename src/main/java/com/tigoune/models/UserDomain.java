package com.tigoune.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** Modelo para el usuario */
public class UserDomain {
    private String username;
    private String password;
    private List<UserDomain> lstUsers = new ArrayList<>();
	    
    private UserDomain( Map<String,String> userData){
        this.username = userData.get("username");
        this.password = userData.get("password");
    }
    public UserDomain( List<Map<String,String>> userData){
        createConstructor(userData);
    }
    public List<UserDomain> getLstUsers() {
        return lstUsers;
    }
    private void createConstructor(List<Map<String, String>> userData) {
        for (Map<String, String> data: userData){
            lstUsers.add(new UserDomain(data));
        }
    }
    public String getUsername(){
        return username;
    }
    public String getpassword() {
	        return password;
    }
}


