package com.example.demo.dto;

public class UserDTO {
    private Integer userId;
    private String userName;
    private String address;
    
    // Constructors
    public UserDTO() {}
    
    public UserDTO(Integer userId, String userName, String address) {
        this.userId = userId;
        this.userName = userName;
        this.address = address;
    }
    
    // Getters and Setters
    public Integer getUserId() {
        return userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
}