package com.pmo.app.pmoservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "menu")
public class Menu implements Serializable{


    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "active")
    private Short active;

    @Column(name = "level_menu")
    private Integer levelMenu;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "parent_id")
    private String parentId;

    @Column(name = "path_name")
    private String pathName;

    @Column(name = "class_style")
    private String classStyle;

    @Column(name = "menu_type")
    private Integer menuType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Short getActive() {
        return active;
    }

    public void setActive(Short active) {
        this.active = active;
    }

    public Integer getLevelMenu() {
        return levelMenu;
    }

    public void setLevelMenu(Integer levelMenu) {
        this.levelMenu = levelMenu;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    public String getClassStyle() {
        return classStyle;
    }

    public void setClassStyle(String classStyle) {
        this.classStyle = classStyle;
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", active=" + active +
                ", levelMenu=" + levelMenu +
                ", menuName='" + menuName + '\'' +
                ", parentId='" + parentId + '\'' +
                ", pathName='" + pathName + '\'' +
                ", classStyle='" + classStyle + '\'' +
                ", menuType=" + menuType +
                '}';
    }
}
