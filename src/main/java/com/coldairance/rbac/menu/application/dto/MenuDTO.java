package com.coldairance.rbac.menu.application.dto;

import com.coldairance.rbac.menu.infrastructure.dao.MenuDO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MenuDTO {

    @JsonProperty("menu_id")
    private Long menuId;
    @JsonProperty("menu_name")
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
    public MenuDO toDo() {
        MenuDO menuDO = new MenuDO();
        menuDO.setMenuId(this.menuId);
        menuDO.setMenuName(this.menuName);
        return menuDO;
    }
}
