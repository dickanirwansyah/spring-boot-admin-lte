package com.pmo.app.pmoservice.repository;

import com.pmo.app.pmoservice.entity.MUserManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MUserManagemenetRepository extends JpaRepository<MUserManagement, String>{

    List<MUserManagement> findAll();

    List<MUserManagement> findByLoginId(String loginId);

    @Transactional
    void deleteByLoginId(String loginId);

    MUserManagement findByNameUserAndPassword(String nameUser, String password);

    List<MUserManagement> findByStatus(int status);
}
