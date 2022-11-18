package com.coldairance.rbac.infracore.event.impl;

import com.coldairance.rbac.infracore.event.DomainEvent;
import com.coldairance.rbac.infracore.event.DomainEventBus;
import com.coldairance.rbac.infracore.event.DomainEventHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author: yoda
 * @description: 事件总线的简单实现，只能在单体架构中应用
 */
@Component
public class SimpleEventBusImpl implements DomainEventBus, ApplicationContextAware {

  private ConfigurableApplicationContext applicationContext;

  private ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule())
      .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
  
  private static Logger LOGGER = LoggerFactory.getLogger(SimpleEventBusImpl.class);

  @Override
  public void post(DomainEvent event) {
    applicationContext.publishEvent(event);

  }

  @Override
  public void register(DomainEventHandler handler) {
//    applicationContext.addApplicationListener(handler);
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = (ConfigurableApplicationContext) applicationContext;
  }

}
