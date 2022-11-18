package com.coldairance.rbac.user.domain.event;

import com.coldairance.rbac.infracore.event.DomainEvent;
import com.coldairance.rbac.user.application.dto.UserDTO;

public class UserDeleteEvent extends DomainEvent {

    private Long userId;

    public UserDeleteEvent(UserDTO userDTO) {
        super("user.UserDeleteEvent");
        this.userId = userDTO.getUserId();
    }


    public Long getUserId() {
        return userId;
    }

    @Override
    public String key() {
        return userId.toString();
    }
}
