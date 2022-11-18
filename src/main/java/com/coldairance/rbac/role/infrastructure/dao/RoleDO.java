package com.coldairance.rbac.role.infrastructure.dao;


import com.coldairance.rbac.role.application.dto.RoleDTO;

public class RoleDO {

    private Long roleId;
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

    public RoleDTO toDto() {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleId(this.roleId);
        roleDTO.setRoleName(this.roleName);
        return roleDTO;
    }
    
}
