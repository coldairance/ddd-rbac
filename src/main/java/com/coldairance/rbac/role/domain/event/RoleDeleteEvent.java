package com.coldairance.rbac.role.domain.event;

import com.coldairance.rbac.infracore.event.DomainEvent;
import com.coldairance.rbac.role.application.dto.RoleDTO;

public class RoleDeleteEvent extends DomainEvent {

    private Long roleId;

    public RoleDeleteEvent(RoleDTO roleDTO) {
        super("role.RoleDeleteEvent");
        this.roleId = roleDTO.getRoleId();
    }


    public Long getRoleId() {
        return roleId;
    }

    @Override
    public String key() {
        return this.roleId.toString();
    }
}
