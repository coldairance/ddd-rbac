package com.coldairance.rbac.menu.adapter.remote;

import com.coldairance.rbac.menu.application.service.MenuService;
import com.coldairance.rbac.menu.domain.remote.RemoteMenuService;
import com.coldairance.rbac.role.application.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoteMenuServiceImpl implements RemoteMenuService {

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    @Override
    public void removeRelatedRoles(Long menuId) {
        // TODO check

        menuService.findRoleIds(menuId).stream()
                .forEach(roleId -> roleService.removeRelatedMenus(roleId));
    }
}
