package com.coldairance.rbac.role.adapter.eventhandler;

import com.coldairance.rbac.infracore.event.DomainEventHandler;
import com.coldairance.rbac.role.application.service.RoleService;
import com.coldairance.rbac.role.domain.event.RoleDeleteEvent;
import com.coldairance.rbac.role.domain.remote.RemoteRoleService;
import com.coldairance.rbac.user.application.dto.UserRoleDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleDeleteEventHandler implements DomainEventHandler<RoleDeleteEvent> {

    @Autowired
    private RoleService roleService;

    @Autowired
    private RemoteRoleService remoteRoleService;

    @Override
    public void onApplicationEvent(RoleDeleteEvent roleDeleteEvent) {
        Long roleId = roleDeleteEvent.getRoleId();
        // delete related menus
        roleService.removeRelatedMenus(roleId);
        // delete related users
        roleService.findUserIds(roleId).stream()
                .forEach(uid -> {
                    UserRoleDTO userRoleDTO = new UserRoleDTO();
                    userRoleDTO.setUserId(uid);
                    userRoleDTO.setRoleId(roleId);
                    remoteRoleService.removeUser(userRoleDTO);
                });
    }
}
