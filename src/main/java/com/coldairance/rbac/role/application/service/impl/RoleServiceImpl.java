package com.coldairance.rbac.role.application.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.coldairance.rbac.infracore.event.DomainEventBus;
import com.coldairance.rbac.menu.infrastructure.dao.MenuDO;
import com.coldairance.rbac.role.application.dto.RoleDTO;
import com.coldairance.rbac.role.application.dto.RoleMenuDTO;
import com.coldairance.rbac.role.application.service.RoleService;
import com.coldairance.rbac.role.domain.event.RoleDeleteEvent;
import com.coldairance.rbac.role.domain.repository.RoleRepository;
import com.coldairance.rbac.role.infrastructure.dao.RoleDO;
import com.coldairance.rbac.role.infrastructure.mapper.RoleMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository repository;

    @Autowired
    private DomainEventBus eventBus;

    @Override
    public RoleDO findRoleById(Long roleId) {
        // TODO check

        return repository.findRoleById(roleId);
    }

    @Override
    public List<RoleDTO> findRoles(List<Long> ids) {
        // TODO check

        return repository.findRoles(ids)
                .stream()
                .map(roleDO -> roleDO.toDto())
                .collect(Collectors.toList());
    }

    @Override
    public List<Long> findUserIds(Long roleId) {
        // TODO check

        return repository.findUserIds(roleId);
    }

    @Override
    public List<RoleDO> findRolesById(Long roleId) {
        return repository.findRolesById(roleId);
    }


    @Override
    public void addRole(RoleDTO role) {
        // TODO check

        repository.addRole(role.toDO());
    }

    @Override
    public void removeRole(Long roleId) {
        // TODO check

        repository.removeRole(roleId);


        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleId(roleId);
        RoleDeleteEvent event = new RoleDeleteEvent(roleDTO);
        eventBus.post(event);

    }

    @Override
    public void addMenu(RoleMenuDTO roleMenuDTO) {
        // TODO check

        repository.addMenu(roleMenuDTO.getRoleId(), roleMenuDTO.getMenuId());
    }

    @Override
    public List<Long> getMenuIds(Long roleId) {
        // TODO check

        return repository.getMenuIds(roleId);
    }

    @Override
    public void removeMenu(RoleMenuDTO roleMenuDTO) {
        // TODO check

        repository.removeMenu(roleMenuDTO.getRoleId(), roleMenuDTO.getMenuId());
    }

    @Override
    public void removeRelatedMenus(Long roleId) {
        // TODO check

        repository.removeMenus(roleId);
    }
}
