package com.coldairance.rbac.menu.infrastructure.mapper;

import java.util.List;

import com.coldairance.rbac.menu.infrastructure.dao.MenuDO;
import com.coldairance.rbac.role.infrastructure.dao.RoleDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface MenuMapper {
    @Select({"select menu_id,menu_name from s_menu where menu_id=#{menuId}}"})
    MenuDO selectById(@Param("menuId") Long menuId);

    List<MenuDO> selectByIds(List<Long> ids);

    @Select({"select role_id from s_role_menu where menu_id=#{menuId}"})
    List<Long> selectRoleIds(Long menuId);
    void insert(MenuDO menuDO);

    @Delete({"delete from s_menu where menu_id=#{menuId}"})
    void delete(@Param("menuId") Long menuId);
}
