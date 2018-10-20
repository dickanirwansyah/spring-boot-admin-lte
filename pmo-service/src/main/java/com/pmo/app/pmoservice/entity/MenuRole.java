package com.pmo.app.pmoservice.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "menu_role")
public class MenuRole implements Serializable{

    /***
     *  menu role -> menentukan menu dan sub menu
     *  yang di izinkan atau di permission
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "access_id")
    private String accessId;

    @Column(name = "menu_id")
    private String menuId;

    @Column(name = "parent_id")
    private String parentId;

    public MenuRole(){

    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getAccessId(){
        return accessId;
    }

    public void setAccessId(String accessId){
        this.accessId = accessId;
    }

    public String getMenuId(){
        return menuId;
    }

    public void setMenuId(String menuId){
        this.menuId = menuId;
    }

    public String getParentId(){
        return parentId;
    }

    public void setParentId(String parentId){
        this.parentId = parentId;
    }

}
