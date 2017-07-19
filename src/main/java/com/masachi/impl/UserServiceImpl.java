package com.masachi.impl;

import com.masachi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by masachi on 2017/7/19.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String getCurrentUser(String username) {
        String sql = "select password from user where username = " + username;

        try{
            return jdbcTemplate.queryForObject(sql, String.class);
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}
