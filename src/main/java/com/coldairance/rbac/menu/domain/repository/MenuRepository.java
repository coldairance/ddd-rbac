package com.coldairance.rbac.menu.domain.repository;

import java.util.List;

import com.coldairance.rbac.menu.infrastructure.dao.MenuDO;
import com.coldairance.rbac.role.infrastructure.dao.RoleDO;

public interface MenuRepository {

    MenuDO findMenuById(Long menuId);

    List<MenuDO> findMenus(List<Long> ids);

    List<Long> findRoleIds(Long menuId);

    void addMenu(MenuDO menu);

    void removeMenu(Long menuId);
}
