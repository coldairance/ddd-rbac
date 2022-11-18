package com.coldairance.rbac.role.adapter.repository;

import java.util.List;

import com.coldairance.rbac.role.domain.repository.RoleRepository;
import com.coldairance.rbac.role.infrastructure.dao.RoleDO;
import com.coldairance.rbac.role.infrastructure.mapper.RoleMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public RoleDO findRoleById(Long roleId) {
        // TODO check

        return roleMapper.selectById(roleId);
    }

    @Override
    public List<RoleDO> findRoles(List<Long> ids) {
        // TODO check

        return roleMapper.selectByIds(ids);
    }

    @Override
    public List<Long> findUserIds(Long roleId) {
        // TODO check

        return roleMapper.selectUserIds(roleId);
    }

    @Override
    public List<RoleDO> findRolesById(Long roleId) {
        return null;
    }


    @Override
    public void addRole(RoleDO role) {
        // TODO check

        roleMapper.insert(role);
    }

    @Override
    public void removeRole(Long roleId) {
        // TODO check

        roleMapper.delete(roleId);

    }

    @Override
    public void addMenu(Long roleId, Long menuId) {
        // TODO check

        roleMapper.addMenu(roleId, menuId);
    }

    @Override
    public List<Long> getMenuIds(Long roleId) {
        // TODO check

        return roleMapper.selectMenuIds(roleId);
    }

    @Override
    public void removeMenu(Long roleId, Long menuId) {
        // TODO check

        roleMapper.deleteMenu(roleId, menuId);
    }

    @Override
    public void removeMenus(Long roleId) {
        // TODO check

        roleMapper.deleteMenus(roleId);
    }
}
