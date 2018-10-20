package com.pmo.app.pmoservice.controller;

import com.pmo.app.pmoservice.entity.Menu;
import com.pmo.app.pmoservice.entity.MenuRole;
import com.pmo.app.pmoservice.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.naming.NamingException;
import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping(value = "/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping(value = "/menu-active")
    public List menuSub(@RequestParam("user") String user,
                        @RequestParam("role") String role) throws NamingException{

        if (role.equals("1")){
            return menuService.listMenuActive();
        }else {
            return menuService.listMenu(user);
        }
    }

}
