package com.kgc.dao;

import com.github.pagehelper.PageInfo;
import com.kgc.vo.Users;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by jora on 2019/6/18.
 */
@Repository
public interface UsersMapper {

    List<Map<String,Object>> query(Users u);

    Map<String,Object> queryByName(String name);

    int update(Users users);

}
