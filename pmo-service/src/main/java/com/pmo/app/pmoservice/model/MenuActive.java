package com.pmo.app.pmoservice.model;

import com.pmo.app.pmoservice.entity.Menu;

import java.util.List;

@SuppressWarnings("serial")
public class MenuActive extends Menu {

    private List<Menu> sub;

    public MenuActive(){
        super();
    }

    public MenuActive(Menu menu){
        super();
        this.setId(menu.getId());
        this.setActive(menu.getActive());
        this.setClassStyle(menu.getClassStyle());
        this.setLevelMenu(menu.getLevelMenu());
        this.setMenuName(menu.getMenuName());
        this.setPathName(menu.getPathName());
        this.setParentId(menu.getParentId());
        this.setMenuType(menu.getMenuType());
    }

    public List<Menu> getSub(){
        return sub;
    }

    public void setSub(List<Menu> sub){
        this.sub = sub;
    }
}
