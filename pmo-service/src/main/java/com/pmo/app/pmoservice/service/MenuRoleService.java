package com.pmo.app.pmoservice.service;

import com.pmo.app.pmoservice.entity.Menu;
import com.pmo.app.pmoservice.entity.MenuRole;
import com.pmo.app.pmoservice.model.MenuActive;
import com.pmo.app.pmoservice.repository.MenuRepository;
import com.pmo.app.pmoservice.repository.MenuRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuRoleService {

    @Autowired
    private MenuRoleRepository menuRoleRepository;

    @Autowired
    private MenuRepository menuRepository;

    public List<MenuRole> getAll(){
        return menuRoleRepository.findAll();
    }

    public List<MenuRole> getAccessById(String accessId){
        return menuRoleRepository.findMenuRoleByAccessId(accessId);
    }

    public void deleteAccessId(String accessId){
        menuRoleRepository.deleteMenuByAccessId(accessId);
    }

    public void deleteAll(List<MenuRole> lsMenuRole){
        menuRoleRepository.delete(lsMenuRole);
    }

    public void saveAll(List<MenuRole> lsMenuRole){
        menuRoleRepository.save(lsMenuRole);
    }

    public void save(MenuRole menuRole){
        menuRoleRepository.save(menuRole);
    }

    public List<MenuRole> getByParentId(String accessId, String parentId){
        return menuRoleRepository.findMenuRoleByAccessIdAndParentId(accessId, parentId);
    }

    public List<MenuActive> listMenuRole(String accessId, String role){
        List<Menu> all = menuRepository.joinMenu(role);
        List<MenuActive> allDetail = new ArrayList<>();
        for (Menu menu : all){
            if (menu.getLevelMenu() == 1){
                List<MenuRole> lsMenuRole = getByParentId(accessId, menu.getId());
                MenuActive md = new MenuActive(menu);
                if (lsMenuRole.size() > 0){
                    md.setSub(menuRepository.findMenuByParentId(menu.getId()));
                }
                allDetail.add(md);
            }
        }
        return allDetail;
    }
}
