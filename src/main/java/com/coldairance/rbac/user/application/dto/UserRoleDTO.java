package com.coldairance.rbac.user.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRoleDTO {

    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("role_id")
    private Long roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
