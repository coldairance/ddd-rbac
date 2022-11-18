package com.coldairance.rbac.role.adapter.remote;

import java.util.List;

import com.coldairance.rbac.menu.application.dto.MenuDTO;
import com.coldairance.rbac.menu.application.service.MenuService;
import com.coldairance.rbac.role.application.dto.RoleMenuDTO;
import com.coldairance.rbac.role.application.service.RoleService;
import com.coldairance.rbac.role.domain.remote.RemoteRoleService;
import com.coldairance.rbac.user.application.dto.UserDTO;
import com.coldairance.rbac.user.application.dto.UserRoleDTO;
import com.coldairance.rbac.user.application.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoteRoleServiceImpl implements RemoteRoleService {

    @Autowired
    private MenuService menuService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Override
    public void addMenu(RoleMenuDTO roleMenuDTO) {
        // TODO check

        roleService.addMenu(roleMenuDTO);
    }

    @Override
    public List<MenuDTO> getMenus(Long roleId) {
        // TODO check

        List<Long> menuIds = roleService.getMenuIds(roleId);
        return menuService.findMenus(menuIds);
    }

    @Override
    public List<UserDTO> getUsers(Long roleId) {
        // TODO check

        List<Long> userIds = roleService.findUserIds(roleId);
        return userService.findUsers(userIds);
    }

    @Override
    public void addUser(UserRoleDTO userRoleDTO) {
        // TODO check

        userService.addRole(userRoleDTO);
    }

    @Override
    public void removeUser(UserRoleDTO userRoleDTO) {
        // TODO check

        userService.removeRole(userRoleDTO);
    }

    @Override
    public void removeMenu(RoleMenuDTO roleMenuDTO) {
        // TODO check

        roleService.removeMenu(roleMenuDTO);
    }
}
