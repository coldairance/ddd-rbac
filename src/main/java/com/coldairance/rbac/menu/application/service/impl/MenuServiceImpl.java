package com.coldairance.rbac.menu.application.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.coldairance.rbac.infracore.event.DomainEventBus;
import com.coldairance.rbac.menu.application.dto.MenuDTO;
import com.coldairance.rbac.menu.application.service.MenuService;
import com.coldairance.rbac.menu.domain.event.MenuDeleteEvent;
import com.coldairance.rbac.menu.domain.repository.MenuRepository;
import com.coldairance.rbac.menu.infrastructure.dao.MenuDO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private DomainEventBus eventBus;


    @Override
    public MenuDO findMenuById(Long menuId) {
        // TODO check

        return menuRepository.findMenuById(menuId);
    }

    @Override
    public List<MenuDTO> findMenus(List<Long> ids) {
        // TODO check

        return menuRepository.findMenus(ids)
                .stream()
                .map(menuDO -> menuDO.toDto())
                .collect(Collectors.toList());
    }

    @Override
    public List<Long> findRoleIds(Long menuId) {
        // TODO check

        return menuRepository.findRoleIds(menuId);
    }

    @Override
    public void addMenu(MenuDTO menuDTO) {
        // TODO check

        menuRepository.addMenu(menuDTO.toDo());
    }

    @Override
    public void removeMenu(Long menuId) {
        // TODO check

        menuRepository.removeMenu(menuId);

        // post event
        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setMenuId(menuId);
        MenuDeleteEvent menuDeleteEvent = new MenuDeleteEvent(menuDTO);
        eventBus.post(menuDeleteEvent);
    }
}
