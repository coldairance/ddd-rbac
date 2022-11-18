package com.coldairance.rbac.menu.adapter.eventhandler;

import com.coldairance.rbac.infracore.event.DomainEventHandler;
import com.coldairance.rbac.menu.domain.event.MenuDeleteEvent;
import com.coldairance.rbac.menu.domain.remote.RemoteMenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuDeleteEventHandler implements DomainEventHandler<MenuDeleteEvent> {

    @Autowired
    private RemoteMenuService remoteMenuService;

    @Override
    public void onApplicationEvent(MenuDeleteEvent menuDeleteEvent) {
        // TODO check

        remoteMenuService.removeRelatedRoles(menuDeleteEvent.getMenuId());
    }
}
