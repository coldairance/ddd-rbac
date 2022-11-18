package com.coldairance.rbac.user.domain.repository;

import java.util.List;

import com.coldairance.rbac.user.application.dto.UserDTO;
import com.coldairance.rbac.user.infrastructure.dao.UserDO;

public interface UserRepository {

    UserDO findUserById(Long userId);

    List<UserDO> findUsers(List<Long> ids);

    void addUser(UserDO user);

    void removeUser(Long userId);

    void addRole(Long userId, Long roleId);

    List<Long> findRoleIdsById(Long userId);

    void removeRole(Long userId, Long roleId);

    void removeRoles(Long userId);

}
