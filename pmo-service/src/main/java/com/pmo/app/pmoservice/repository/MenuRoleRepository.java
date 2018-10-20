package com.pmo.app.pmoservice.repository;

import com.pmo.app.pmoservice.entity.MenuRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MenuRoleRepository extends JpaRepository<MenuRole, Integer> {

    List<MenuRole> findAll();

    /** hapus access menu **/
    void deleteMenuByAccessId(String accessId);

    List<MenuRole> findMenuRoleByAccessId(String accessId);

    List<MenuRole> findMenuRoleByAccessIdAndParentId(String accessId, String parentId);
}
