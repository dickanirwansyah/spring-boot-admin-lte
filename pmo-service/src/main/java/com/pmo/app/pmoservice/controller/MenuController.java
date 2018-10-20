package com.pmo.app.pmoservice.controller;

import com.pmo.app.pmoservice.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping(value = "/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @SuppressWarnings({"rawtypes"})
    @GetMapping(value = "/menu-active")
    public List menuSub(@RequestParam("user") String user,
                        @RequestParam("role") String role){

        if (role.equals("1")){
            return menuService.listMenuActive();
        }else {
            return menuService.listMenu(user);
        }
    }

}
