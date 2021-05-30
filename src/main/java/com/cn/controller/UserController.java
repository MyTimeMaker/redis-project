package com.cn.controller;

import com.cn.bean.User;
import com.cn.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/findUserByUsername")
    public User findUserByUsername(@RequestBody JSONObject queryUser){
        String username = queryUser.getString("username");
        User user = userService.findUserByUsername(username);
        return user;
    }
    @RequestMapping("/insertUser")
    public void insertUser(@RequestBody JSONObject insertUser){
        User user = new User();
        user.setUsername(insertUser.getString("username"));
        user.setPassword(insertUser.getString("password"));
        user.setPhone(insertUser.getString("phone"));
        user.setEmail(insertUser.getString("email"));
        user.setAge(insertUser.getInt("age"));
        userService.insertUser(user);
    }
    @RequestMapping("deleteUser")
    public void deleteUserById(@RequestBody JSONObject deleteId){
        Long id = deleteId.getLong("id");
        userService.deleteUserById(id);
    }
}
