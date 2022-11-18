package com.coldairance.rbac.role.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoleMenuDTO {

    @JsonProperty("role_id")
    private Long roleId;
    @JsonProperty("menu_id")
    private Long menuId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}
