package com.coldairance.rbac.user.application.service;

import java.util.List;

import com.coldairance.rbac.user.application.dto.UserDTO;
import com.coldairance.rbac.user.application.dto.UserRoleDTO;
import com.coldairance.rbac.user.infrastructure.dao.UserDO;

public interface UserService {

    UserDO findUserById(Long userId);

    List<UserDTO> findUsers(List<Long> ids);

    void addUser(UserDTO userDTO);

    void removeUserById(Long userId);

    void addRole(UserRoleDTO userRoleDTO);

    List<Long> findRoleIdsById(Long userId);

    void removeRole(UserRoleDTO userRoleDTO);

    void removeRelatedRoles(Long userId);
}
