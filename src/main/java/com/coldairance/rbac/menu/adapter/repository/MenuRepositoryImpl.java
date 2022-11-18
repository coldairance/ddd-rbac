package com.coldairance.rbac.menu.adapter.repository;

import java.util.List;

import com.coldairance.rbac.menu.domain.repository.MenuRepository;
import com.coldairance.rbac.menu.infrastructure.dao.MenuDO;
import com.coldairance.rbac.menu.infrastructure.mapper.MenuMapper;
import com.coldairance.rbac.role.infrastructure.dao.RoleDO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MenuRepositoryImpl implements MenuRepository {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public MenuDO findMenuById(Long menuId) {
        // TODO check

        return menuMapper.selectById(menuId);
    }

    @Override
    public List<MenuDO> findMenus(List<Long> ids) {
        // TODO check

        return menuMapper.selectByIds(ids);
    }

    @Override
    public List<Long> findRoleIds(Long menuId) {
        // TODO check

        return menuMapper.selectRoleIds(menuId);
    }

    @Override
    public void addMenu(MenuDO menu) {
        // TODO check

        menuMapper.insert(menu);
    }

    @Override
    public void removeMenu(Long menuId) {
        // TODO check

        menuMapper.delete(menuId);

    }
}
