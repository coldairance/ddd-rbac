package com.coldairance.rbac.role.domain.remote;

import java.util.List;

import com.coldairance.rbac.menu.application.dto.MenuDTO;
import com.coldairance.rbac.role.application.dto.RoleMenuDTO;
import com.coldairance.rbac.user.application.dto.UserDTO;
import com.coldairance.rbac.user.application.dto.UserRoleDTO;

public interface RemoteRoleService {

    void addMenu(RoleMenuDTO roleMenuDTO);

    List<MenuDTO> getMenus(Long roleId);

    List<UserDTO> getUsers(Long roleId);

    void addUser(UserRoleDTO userRoleDTO);

    void removeUser(UserRoleDTO userRoleDTO);

    void removeMenu(RoleMenuDTO roleMenuDTO);
}
