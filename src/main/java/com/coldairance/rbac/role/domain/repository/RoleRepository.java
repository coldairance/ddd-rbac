package com.coldairance.rbac.role.domain.repository;

import java.util.List;

import com.coldairance.rbac.role.application.dto.RoleDTO;
import com.coldairance.rbac.role.infrastructure.dao.RoleDO;

public interface RoleRepository {

    RoleDO findRoleById(Long roleId);

    List<RoleDO> findRoles(List<Long> ids);

    List<Long> findUserIds(Long roleId);

    List<RoleDO> findRolesById(Long roleId);

    void addRole(RoleDO role);

    void removeRole(Long roleId);

    void addMenu(Long roleId, Long menuId);

    List<Long> getMenuIds(Long roleId);

    void removeMenu(Long roleId, Long menuId);

    void removeMenus(Long roleId);
}
