package com.pmo.app.pmoservice.controller;

import com.pmo.app.pmoservice.entity.MUserManagement;
import com.pmo.app.pmoservice.model.UserCredentials;
import com.pmo.app.pmoservice.service.MenuService;
import com.pmo.app.pmoservice.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    UserManagementService userManagementService;

    @Autowired
    private MenuService menuService;

    @PostMapping(value = "/login")
    public Map<String, Object> getCredentials(@RequestBody UserCredentials user,
                                              HttpServletRequest request,
                                              HttpSession session) throws NamingException {

        Map<String, Object> hasil = new LinkedHashMap<>();
        MUserManagement userLogin = userManagementService.checkLogin(user.getUsername(), user.getPassword());

        if (userLogin != null){
            String TokenId = UUID.randomUUID().toString();

            HttpSession sess = request.getSession();
            sess.setAttribute("user", user.getUsername());
            sess.setAttribute("password", user.getPassword());

            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Object credentials = SecurityContextHolder.getContext().getAuthentication().getCredentials();
            UsernamePasswordAuthenticationToken userPasswordToken = new UsernamePasswordAuthenticationToken(principal, credentials);

            String userin = "";
            String t = "";

            if (principal instanceof UserDetails){
                userin = ((UserDetails) principal).getUsername();
            }else {
                userin = principal.toString();
            }

            /**test log**/
            System.out.println("USER : "+userin);
            System.out.println("T : "+userPasswordToken.getName());
            System.out.println("T : "+userPasswordToken.toString());


            UserCredentials userCredentials = new UserCredentials();
            userCredentials.setFullName("Muhammad Dicka Nirwansyah");
            userCredentials.setRole("ADMIN");
            userCredentials.setUsername(user.getUsername());
            userCredentials.setPicture("assets/img/avatars/arms-blue.png");
            userCredentials.setLoginStatus(Boolean.TRUE);
            userCredentials.setToken(TokenId);

            hasil.put("status", true);
            hasil.put("message", "Login Berhasil");
            hasil.put("data", userCredentials);
            hasil.put("user", user.getUsername());
            hasil.put("password", user.getPassword());
            hasil.put("userId", userLogin.getLoginId());
            hasil.put("roleId", userLogin.getPositionId());
        }else {
            hasil.put("status", false);
            hasil.put("message", "Login Gagal");
            hasil.put("data", null);
        }
        return hasil;
    }
}
