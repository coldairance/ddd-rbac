package com.coldairance.rbac.user.application.dto;

import com.coldairance.rbac.user.infrastructure.dao.UserDO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {

    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
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

    public UserDO toDO() {
        UserDO userDO = new UserDO();
        userDO.setUserId(this.userId);
        userDO.setUsername(this.username);
        userDO.setPassword(this.password);
        return userDO;
    }
}
