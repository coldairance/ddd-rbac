package com.coldairance.rbac.role.application.service;

import java.util.List;

import com.coldairance.rbac.role.application.dto.RoleDTO;
import com.coldairance.rbac.role.application.dto.RoleMenuDTO;
import com.coldairance.rbac.role.infrastructure.dao.RoleDO;

public interface RoleService {

    RoleDO findRoleById(Long roleId);

    List<RoleDTO> findRoles(List<Long> ids);

    List<Long> findUserIds(Long roleId);

    List<RoleDO> findRolesById(Long roleId);

    void addRole(RoleDTO role);

    void removeRole(Long roleId);

    void addMenu(RoleMenuDTO roleMenuDTO);

    List<Long> getMenuIds(Long roleId);

    void removeMenu(RoleMenuDTO roleMenuDTO);

    void removeRelatedMenus(Long roleId);
}
