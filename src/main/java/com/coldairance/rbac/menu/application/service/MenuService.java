package com.coldairance.rbac.menu.application.service;

import java.util.List;

import com.coldairance.rbac.menu.application.dto.MenuDTO;
import com.coldairance.rbac.menu.infrastructure.dao.MenuDO;

public interface MenuService {

    MenuDO findMenuById(Long menuId);

    List<MenuDTO> findMenus(List<Long> ids);

    List<Long> findRoleIds(Long menuId);

    void addMenu(MenuDTO menuDTO);

    void removeMenu(Long menuId);
}
