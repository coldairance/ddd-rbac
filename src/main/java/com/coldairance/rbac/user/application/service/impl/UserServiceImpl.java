package com.coldairance.rbac.user.application.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.coldairance.rbac.infracore.event.DomainEventBus;
import com.coldairance.rbac.user.application.dto.UserDTO;
import com.coldairance.rbac.user.application.dto.UserRoleDTO;
import com.coldairance.rbac.user.application.service.UserService;
import com.coldairance.rbac.user.domain.event.UserDeleteEvent;
import com.coldairance.rbac.user.domain.repository.UserRepository;
import com.coldairance.rbac.user.infrastructure.dao.UserDO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private DomainEventBus eventBus;

    @Override
    public UserDO findUserById(Long userId) {
        // TODO check

        return repository.findUserById(userId);
    }

    @Override
    public List<UserDTO> findUsers(List<Long> ids) {
        // TODO check

        return repository.findUsers(ids)
                .stream()
                .map(userDO -> userDO.toDto())
                .collect(Collectors.toList());
    }

    @Override
    public void addUser(UserDTO userDTO) {
        // TODO check

        repository.addUser(userDTO.toDO());
    }

    @Override
    public void removeUserById(Long userId) {
        // TODO check

        repository.removeUser(userId);

        // post event
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userId);
        eventBus.post(new UserDeleteEvent(userDTO));
    }

    @Override
    public void addRole(UserRoleDTO userRoleDTO) {
        // TODO check

        repository.addRole(userRoleDTO.getUserId(), userRoleDTO.getRoleId());
    }

    @Override
    public List<Long> findRoleIdsById(Long userId) {
        // TODO check

        return repository.findRoleIdsById(userId);
    }

    @Override
    public void removeRole(UserRoleDTO userRoleDTO) {
        // TODO check

        repository.removeRole(userRoleDTO.getUserId(), userRoleDTO.getRoleId());
    }

    @Override
    public void removeRelatedRoles(Long userId) {
        // TODO check

        repository.removeRoles(userId);
    }
}
