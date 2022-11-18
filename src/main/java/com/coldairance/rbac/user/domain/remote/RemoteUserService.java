package com.coldairance.rbac.user.domain.remote;

import java.util.List;

import com.coldairance.rbac.menu.application.dto.MenuDTO;
import com.coldairance.rbac.role.application.dto.RoleDTO;
import com.coldairance.rbac.user.application.dto.UserRoleDTO;

public interface RemoteUserService {

    void addRole(UserRoleDTO userRoleDTO);

    List<RoleDTO> getRolesByUserId(Long userId);

    List<MenuDTO> getMenusByUserId(Long userId);
}
