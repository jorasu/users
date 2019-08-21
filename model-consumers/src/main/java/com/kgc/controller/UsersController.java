package com.kgc.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.service.UserService;
import com.kgc.vo.Users;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by jora on 2019/6/18.
 */
@RestController
public class UsersController {
    @Resource
    private UserService service;
    @RequestMapping("/query.do")
    PageInfo<Map<String,Object>> query(@RequestParam(defaultValue = "1") Integer pNo, @RequestParam(defaultValue = "2") Integer pSize, Users u){
        return service.query(pNo,pSize,u);
    };
    @RequestMapping("/isLogin.do")
    String isLogin(String name,String password,HttpServletRequest request){
        String mes=service.isLogin(name,password);
        if("loginOk".equals(mes)){
            request.getSession().setAttribute("name",name);
        }
        return mes;
    };
    @RequestMapping("/updPwd.do")
    String updPwd(String name,String oldPwd,String newPwd){
       return service.updPwd(name,oldPwd,newPwd);
    };

    @RequestMapping("/queryByName.do")
    public Map<String, Object> queryByName(HttpServletRequest request) {
        String name= (String) request.getSession().getAttribute("name");
        return service.queryByName(name);
    }
}
