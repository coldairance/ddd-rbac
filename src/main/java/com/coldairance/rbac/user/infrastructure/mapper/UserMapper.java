package com.coldairance.rbac.user.infrastructure.mapper;

import java.util.List;

import com.coldairance.rbac.user.infrastructure.dao.UserDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select({"select * from s_user where user_id=#{userId}}"})
    UserDO selectById(@Param("userId") Long userId);

    List<UserDO> selectByIds(List<Long> ids);

    void insert(UserDO userDO);

    @Select({"select role_id from s_user_role where user_id=#{userId}"})
    List<Long> selectRoleIds(@Param("userId") Long userId);

    @Delete({"delete from s_user where user_id=#{userId}"})
    void delete(@Param("userId") Long userId);

    @Insert({"insert into s_user_role(user_id, role_id) values(#{userId},#{roleId})"})
    void addRole(@Param("userId") Long userId, @Param("roleId") Long roleId);

    @Delete({"delete from s_user_role where user_id=#{userId} and role_id=#{roleId}"})
    void deleteRole(@Param("userId") Long userId, @Param("roleId") Long roleId);

    @Delete({"delete from s_user_role where user_id=#{userId}"})
    void deleteRoles(@Param("userId") Long userId);
}
