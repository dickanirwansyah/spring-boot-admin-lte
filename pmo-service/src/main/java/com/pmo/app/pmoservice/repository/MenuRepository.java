package com.pmo.app.pmoservice.repository;

import com.pmo.app.pmoservice.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, String> {

    List<Menu> findMenuByParentId(String parentId);

    List<Menu> findMenuById(String id);

    List<Menu> findMenuByLevelMenu(Integer levelMenu);

    @Query(value = "select m.id, m.active, m.level_menu, m.menu_name, m.parent_id, m.path_name, m.class_style, m.menu_type from menu m, menu_role mr where m.id = mr.menu_id and mr.access_id=:role", nativeQuery = true)
    List<Menu> joinMenu(@Param("role") String role);
}
