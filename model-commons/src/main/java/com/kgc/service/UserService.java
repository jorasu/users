package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.vo.Users;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.Map;

/**
 * Created by jora on 2019/6/18.
 */
public interface UserService {

    PageInfo<Map<String,Object>> query(Integer pNo,Integer pSize,Users u);

    String isLogin(String name,String password);

    String updPwd(String name,String oldPwd,String newPwd);

    Map<String,Object> queryByName(String name);
}
