package com.pmo.app.pmoservice.service;

import com.pmo.app.pmoservice.entity.MUserManagement;
import com.pmo.app.pmoservice.repository.MUserManagemenetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManagementService {

    @Autowired
    private MUserManagemenetRepository userManagementRepository;

    public List<MUserManagement> getAll(){
        return userManagementRepository.findAll();
    }

    public List<MUserManagement> getByStatus(){
        return userManagementRepository.findByStatus(0);
    }

    public List<MUserManagement> getId(String Id){
        return userManagementRepository.findByLoginId(Id);
    }

    public MUserManagement checkLogin(String username, String password){
        return userManagementRepository.findByNameUserAndPassword(username, password);
    }

    public void save(MUserManagement mUserManagement){
        userManagementRepository.save(mUserManagement);
    }

    public void delete(String Id){
        userManagementRepository.deleteByLoginId(Id);
    }
}
