package com.coldairance.rbac.user.adapter.port;

import java.util.List;

import com.coldairance.rbac.infracore.api.CommonResponse;
import com.coldairance.rbac.menu.application.dto.MenuDTO;
import com.coldairance.rbac.role.application.dto.RoleDTO;
import com.coldairance.rbac.user.application.dto.UserDTO;
import com.coldairance.rbac.user.application.dto.UserRoleDTO;
import com.coldairance.rbac.user.application.service.UserService;
import com.coldairance.rbac.user.domain.remote.RemoteUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RemoteUserService remoteUserService;

    @PostMapping("/add")
    public CommonResponse addUser(@RequestBody UserDTO userDTO) {
        // TODO check

        userService.addUser(userDTO);
        return CommonResponse.success();
    }

    @DeleteMapping("/remove/{user_id}")
    public CommonResponse removeUser(@PathVariable("user_id") String userId) {
        // TODO check

        userService.removeUserById(Long.valueOf(userId));
        return CommonResponse.success();
    }

    @GetMapping("/find_roles/{user_id}")
    public CommonResponse<List<RoleDTO>> findRoles(@PathVariable("user_id") String userId) {
        // TODO check

        List<RoleDTO> roles = remoteUserService.getRolesByUserId(Long.valueOf(userId));
        return CommonResponse.success(roles);
    }

    @GetMapping("/find_menus/{user_id}")
    public CommonResponse<List<MenuDTO>> findMenus(@PathVariable("user_id") String userId) {
        // TODO check

        List<MenuDTO> menus = remoteUserService.getMenusByUserId(Long.valueOf(userId));
        return CommonResponse.success(menus);
    }


    @PostMapping("/add_role")
    public CommonResponse addMenu(@RequestBody UserRoleDTO userRoleDTO) {
        // TODO check

        remoteUserService.addRole(userRoleDTO);
        return CommonResponse.success();
    }

    @DeleteMapping("/remove_role")
    public CommonResponse removeRole(@RequestBody UserRoleDTO userRoleDTO) {
        // TODO check

        userService.removeRole(userRoleDTO);
        return CommonResponse.success();
    }

    @DeleteMapping("/remove_roles/{user_id}")
    public CommonResponse removeRoles(@PathVariable("user_id") String userId) {
        // TODO check

        userService.removeRelatedRoles(Long.valueOf(userId));
        return CommonResponse.success();
    }
}
