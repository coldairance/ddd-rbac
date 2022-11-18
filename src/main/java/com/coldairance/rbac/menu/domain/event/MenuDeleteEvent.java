package com.coldairance.rbac.menu.domain.event;

import com.coldairance.rbac.infracore.event.DomainEvent;
import com.coldairance.rbac.menu.application.dto.MenuDTO;

public class MenuDeleteEvent extends DomainEvent {
    private Long menuId;

    public MenuDeleteEvent(MenuDTO menuDTO) {
        super("menu.MenuDeleteEvent");
        this.menuId = menuDTO.getMenuId();
    }

    public Long getMenuId() {
        return menuId;
    }

    @Override
    public String key() {
        return menuId.toString();
    }
}
