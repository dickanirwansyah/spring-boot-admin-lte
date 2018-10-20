package com.pmo.app.pmoservice.controller;

import com.pmo.app.pmoservice.entity.MenuRole;
import com.pmo.app.pmoservice.service.MenuRoleService;
import com.pmo.app.pmoservice.service.MenuService;
import com.pmo.app.pmoservice.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    MenuRoleService menuRoleService;

    @Autowired
    MenuService menuService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String uploadingPost(@RequestBody List<MenuRole> lsRole) {
        try {
            if(lsRole != null){
                String accessId = lsRole.get(0).getAccessId();
                List<MenuRole> lsMenu = menuRoleService.getAccessById(accessId);
                if(lsMenu.size() > 0){
                    menuRoleService.deleteAll(lsMenu);
                }
                menuRoleService.saveAll(lsRole);
                return ResponseMessage.MSG.SUCCESS;
            }else{
                return ResponseMessage.MSG.FAILED;
            }
        } catch (Exception e) {
            return ResponseMessage.MSG.ERROR;
        }
    }

    @GetMapping(value = "/menu-role-active")
    public List listMenuRole(@RequestParam(value = "user") String user,
                                       @RequestParam(value = "role") String role){

        if (role.equals("1")){
            return menuService.listMenuActive();
        }else {
            return menuRoleService.listMenuRole(user, role);
        }
    }
}
