package com.cn.service;

import com.cn.bean.User;
import com.cn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "users")
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Cacheable(key = "#p0")
    public User findUserByUsername(String username){
        return userMapper.findUserByUsername(username);
    }
    @CachePut
    public void insertUser(User user){
        userMapper.insertUser(user);
    }
    @CacheEvict
    public void deleteUserById(Long id){
        userMapper.deleteUserById(id);
    }
}
