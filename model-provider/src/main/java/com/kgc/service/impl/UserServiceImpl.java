package com.kgc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.dao.UsersMapper;
import com.kgc.service.UserService;
import com.kgc.vo.Users;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by jora on 2019/6/18.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Resource
     private UsersMapper mapper;
    @Override
    public PageInfo<Map<String, Object>> query(Integer pNo, Integer pSize, Users u) {
        PageHelper.startPage(pNo,pSize);
        return new PageInfo<Map<String, Object>>(mapper.query(u));
    }

    @Override
    public String isLogin(String name, String password) {
        String loginMes="";
        Map<String, Object> mapInfo=mapper.queryByName(name);
        String pwd=(String) mapInfo.get("password");
        Integer status= (Integer) mapInfo.get("status");
        if(mapInfo==null){
         loginMes="登录失败，用户名不存在";
        }else if(pwd.equals(password)&&status==1){
            loginMes="loginOk";
        }else if(status==0){
            loginMes="账户被冻结";
        }else if(!pwd.equals(password)){
            loginMes="用户名或密码错误";
        }
        return loginMes;
    }

    @Override
    public String updPwd(String name,String oldPwd, String newPwd) {
        String upRes="";
        Map<String, Object> mapInfo=mapper.queryByName(name);
        System.out.println(mapInfo);
        String pwd=(String) mapInfo.get("password");
        if(pwd.equals(oldPwd)){
            Users users=new Users();
            users.setName(name);
            users.setPassword(newPwd);
            if(  mapper.update(users)>0){
                upRes="密码修改成功";
            }else {
                upRes="密码修改失败";
            }

        }else {
            upRes="旧密码输入错误！";
        }
        return upRes;
    }

    @Override
    public Map<String, Object> queryByName(String name) {
        return mapper.queryByName(name);
    }
}
