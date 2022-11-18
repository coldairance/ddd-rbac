package com.coldairance.rbac.user.adapter.repository;

import java.util.List;

import com.coldairance.rbac.user.application.dto.UserDTO;
import com.coldairance.rbac.user.domain.repository.UserRepository;
import com.coldairance.rbac.user.infrastructure.dao.UserDO;
import com.coldairance.rbac.user.infrastructure.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDO findUserById(Long userId) {
        // TODO check

        return userMapper.selectById(userId);
    }

    @Override
    public List<UserDO> findUsers(List<Long> ids) {
        // TODO check

        return userMapper.selectByIds(ids);
    }

    @Override
    public void addUser(UserDO user) {
        // TODO check

        userMapper.insert(user);
    }

    @Override
    public void removeUser(Long userId) {
        // TODO check

        userMapper.delete(userId);

    }

    @Override
    public void addRole(Long userId, Long roleId) {
        // TODO check

        userMapper.addRole(userId, roleId);
    }

    @Override
    public List<Long> findRoleIdsById(Long userId) {
        // TODO check

        return userMapper.selectRoleIds(userId);
    }

    @Override
    public void removeRole(Long userId, Long roleId) {
        // TODO check

        userMapper.deleteRole(userId, roleId);
    }

    @Override
    public void removeRoles(Long userId) {
        // TODO check

        userMapper.deleteRoles(userId);
    }
}
