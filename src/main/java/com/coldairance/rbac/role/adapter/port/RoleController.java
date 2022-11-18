package com.coldairance.rbac.role.adapter.port;

import java.util.List;

import com.coldairance.rbac.infracore.api.CommonResponse;
import com.coldairance.rbac.menu.application.dto.MenuDTO;
import com.coldairance.rbac.role.application.dto.RoleDTO;
import com.coldairance.rbac.role.application.dto.RoleMenuDTO;
import com.coldairance.rbac.role.application.service.RoleService;
import com.coldairance.rbac.role.domain.remote.RemoteRoleService;
import com.coldairance.rbac.user.application.dto.UserDTO;
import com.coldairance.rbac.user.application.dto.UserRoleDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/role")
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private RemoteRoleService remoteRoleService;

    @PostMapping("/add")
    public CommonResponse addRole(@RequestBody RoleDTO roleDTO) {
        // TODO check

        roleService.addRole(roleDTO);
        return CommonResponse.success();
    }

    @DeleteMapping("/remove/{role_id}")
    public CommonResponse removeRole(@PathVariable("role_id") String roleId) {
        // TODO check

        roleService.removeRole(Long.valueOf(roleId));
        return CommonResponse.success();
    }

    @GetMapping("find_menus/{role_id}")
    public CommonResponse<List<MenuDTO>> findMenus(@PathVariable("role_id") String roleId) {
        // TODO check

        List<MenuDTO> menus = remoteRoleService.getMenus(Long.valueOf(roleId));
        return CommonResponse.success(menus);
    }

    @PostMapping("/add_menu")
    public CommonResponse addMenu(@RequestBody RoleMenuDTO roleMenuDTO) {
        // TODO check

        remoteRoleService.addMenu(roleMenuDTO);
        return CommonResponse.success();
    }

    @DeleteMapping("/remove_menu")
    public CommonResponse removeMenu(@RequestBody RoleMenuDTO roleMenuDTO) {
        // TODO check

        remoteRoleService.removeMenu(roleMenuDTO);
        return CommonResponse.success();
    }

    @DeleteMapping("/remove_menus/{role_id}")
    public CommonResponse removeMenus(@PathVariable("role_id") String roleId) {
        // TODO check

        roleService.removeRelatedMenus(Long.valueOf(roleId));
        return CommonResponse.success();
    }

    @PostMapping("/add_user")
    public CommonResponse addUser(@RequestBody UserRoleDTO userRoleDTO) {
        // TODO check

        remoteRoleService.addUser(userRoleDTO);
        return CommonResponse.success();
    }

    @DeleteMapping("/remove_user")
    public CommonResponse removeUser(@RequestBody UserRoleDTO userRoleDTO) {
        // TODO check

        remoteRoleService.removeUser(userRoleDTO);
        return CommonResponse.success();
    }

    @GetMapping("/find_users/{role_id}")
    public CommonResponse<List<UserDTO>> findUsers(@PathVariable("role_id") String roleId) {
        // TODO check

        List<UserDTO> users = remoteRoleService.getUsers(Long.valueOf(roleId));
        return CommonResponse.success(users);
    }
}
