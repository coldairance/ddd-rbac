package com.coldairance.rbac.menu.adapter.port;

import com.coldairance.rbac.infracore.api.CommonResponse;
import com.coldairance.rbac.menu.application.dto.MenuDTO;
import com.coldairance.rbac.menu.application.service.MenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/menu")
@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping("/add")
    public CommonResponse addMenu(@RequestBody MenuDTO menuDTO) {
        // TODO check

        menuService.addMenu(menuDTO);

        return CommonResponse.success();
    }

    @DeleteMapping("/remove/{menu_id}")
    public CommonResponse removeMenu(@PathVariable("menu_id") String menuId) {
        // TODO check

        menuService.removeMenu(Long.valueOf(menuId));

        return CommonResponse.success();
    }
}
