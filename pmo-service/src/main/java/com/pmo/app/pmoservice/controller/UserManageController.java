package com.pmo.app.pmoservice.controller;

import com.pmo.app.pmoservice.entity.MUserManagement;
import com.pmo.app.pmoservice.service.UserManagementService;
import com.pmo.app.pmoservice.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping(value = "/user-management")
public class UserManageController {

    @Autowired
    private UserManagementService userManagementService;

    @GetMapping(value = "/get")
    public List<MUserManagement> list(){
        return userManagementService.getByStatus();
    }

    @PostMapping(value = "/save")
    public String save(@RequestBody MUserManagement mUserManagement){
        try{
            userManagementService.save(mUserManagement);
            return ResponseMessage.MSG.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseMessage.MSG.ERROR;
        }
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestBody String id){
        try {
            userManagementService.delete(id);
            return ResponseMessage.MSG.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseMessage.MSG.ERROR;
        }
    }
}
