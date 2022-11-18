package com.coldairance.rbac.menu.infrastructure.dao;

import com.coldairance.rbac.menu.application.dto.MenuDTO;

public class MenuDO {

    private Long menuId;
    private String menuName;

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public MenuDTO toDto() {
        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setMenuId(this.menuId);
        menuDTO.setMenuName(this.menuName);
        return menuDTO;
    }
}
