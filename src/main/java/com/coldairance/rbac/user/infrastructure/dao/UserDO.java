package com.coldairance.rbac.user.infrastructure.dao;

import com.coldairance.rbac.user.application.dto.UserDTO;

public class UserDO {

    private Long userId;
    private String username;
    private String password;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDTO toDto() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(this.userId);
        userDTO.setUsername(this.username);
        userDTO.setPassword(this.password);
        return userDTO;
    }
}
