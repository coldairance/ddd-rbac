package com.coldairance.rbac.infracore.event;

import org.springframework.context.ApplicationListener;

public interface DomainEventHandler<T extends DomainEvent> extends ApplicationListener<T> {

}
