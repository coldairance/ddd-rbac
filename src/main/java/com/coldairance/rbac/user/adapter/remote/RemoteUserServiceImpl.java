package com.coldairance.rbac.user.adapter.remote;

import java.util.List;
import java.util.stream.Collectors;

import com.coldairance.rbac.menu.application.dto.MenuDTO;
import com.coldairance.rbac.role.application.dto.RoleDTO;
import com.coldairance.rbac.role.application.service.RoleService;
import com.coldairance.rbac.role.domain.remote.RemoteRoleService;
import com.coldairance.rbac.user.application.dto.UserRoleDTO;
import com.coldairance.rbac.user.application.service.UserService;
import com.coldairance.rbac.user.domain.remote.RemoteUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoteUserServiceImpl implements RemoteUserService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RemoteRoleService remoteRoleService;

    @Override
    public void addRole(UserRoleDTO userRoleDTO) {
        // TODO check

        userService.addRole(userRoleDTO);
    }

    @Override
    public List<RoleDTO> getRolesByUserId(Long userId) {
        // TODO check

        List<Long> roleIds = userService.findRoleIdsById(userId);
        return roleService.findRoles(roleIds);
    }

    @Override
    public List<MenuDTO> getMenusByUserId(Long userId) {
        // TODO check

        return userService.findRoleIdsById(userId)
                .stream()
                .flatMap(uid -> remoteRoleService.getMenus(uid).stream())
                .collect(Collectors.toList());
    }
}
