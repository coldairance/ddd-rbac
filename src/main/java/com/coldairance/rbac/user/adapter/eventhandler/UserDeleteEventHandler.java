package com.coldairance.rbac.user.adapter.eventhandler;

import com.coldairance.rbac.infracore.event.DomainEventHandler;
import com.coldairance.rbac.user.application.service.UserService;
import com.coldairance.rbac.user.domain.event.UserDeleteEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDeleteEventHandler implements DomainEventHandler<UserDeleteEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(UserDeleteEvent userDeleteEvent) {
        // TODO check

        userService.removeRelatedRoles(userDeleteEvent.getUserId());
    }
}
