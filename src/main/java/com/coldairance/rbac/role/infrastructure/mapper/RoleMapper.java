package com.coldairance.rbac.role.infrastructure.mapper;

import java.util.List;

import com.coldairance.rbac.role.infrastructure.dao.RoleDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface RoleMapper {

    @Select({"select role_id,role_name from s_role where role_id=#{roleId}}"})
    RoleDO selectById(Long roleId);

    List<RoleDO> selectByIds(List<Long> ids);

    @Select({"select user_id from s_user_role where role_id=#{roleId}"})
    List<Long> selectUserIds(Long roleId);

    void insert(RoleDO roleDO);
    @Delete({"delete from s_role where role_id=#{roleId}"})
    void delete(@Param("roleId") Long roleId);

    @Select({"select menu_id from s_role_menu where role_id=#{roleId}"})
    List<Long> selectMenuIds(@Param("roleId") Long roleId);

    @Insert({"insert into s_role_menu(role_id, menu_id) values(#{roleId},#{menuId})"})
    void addMenu(@Param("roleId") Long roleId, @Param("menuId") Long menuId);

    @Delete({"delete from s_role_menu where role_id=#{roleId} and menu_id=#{menuId}"})
    void deleteMenu(@Param("roleId") Long roleId, @Param("menuId") Long menuId);

    @Delete({"delete from s_role_menu where role_id=#{roleId}"})
    void deleteMenus(@Param("roleId") Long roleId);
}
