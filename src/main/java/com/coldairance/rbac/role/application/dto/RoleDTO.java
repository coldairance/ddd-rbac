package com.coldairance.rbac.role.application.dto;

import com.coldairance.rbac.role.infrastructure.dao.RoleDO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RoleDTO {

    @JsonProperty("role_id")
    private Long roleId;
    @JsonProperty("role_name")
    private String roleName;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public RoleDO toDO() {
        RoleDO roleDO = new RoleDO();
        roleDO.setRoleId(this.roleId);
        roleDO.setRoleName(this.roleName);
        return roleDO;
    }
}
