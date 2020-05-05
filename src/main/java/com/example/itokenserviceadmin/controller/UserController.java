package com.example.itokenserviceadmin.controller;

import com.example.itokenserviceadmin.config.baseResult.Result;
import com.example.itokenserviceadmin.config.exceptionHandle.ResultEnum;
import com.example.itokenserviceadmin.config.exceptionHandle.UserException;
import com.example.itokenserviceadmin.entity.User;
import com.example.itokenserviceadmin.service.UserService;
import com.example.itokenserviceadmin.serviceImpl.UserImpl;
import com.example.itokenserviceadmin.utils.ResultUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/success")
    public Result<User> success(User user){
        user.setId("3");
        return ResultUtil.success(user);
    }

    @PostMapping("/123")
    @ApiOperation(value="测试swagger", notes="根据url的id来指定更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "s1", value = "用户ID", required = true, dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "s2", value = "用户实体user", required = true, dataType = "int")
    })
    public Result postMethod(String s1,@RequestParam(required = true) int s2){
        return ResultUtil.success();
    }
    @RequestMapping("/err")
    public Result err(){
        return ResultUtil.error(ResultEnum.UNKNOW_ERROR);
    }

    @RequestMapping("/exception")
    public void exception() throws Exception {
        throw new UserException(ResultEnum.UNKNOW_ERROR);
    }

    @RequestMapping("/")
    public Map<String, Object> test() {
        Map<String, Object> map = new HashMap<>();
        map.put("user", userService.selectAll("1"));
        return map;
    }


    @RequestMapping("/login")
    public User login() {
        return userService.login("2", "22222");
    }

    @RequestMapping("/register")
    public int test1() {
        User user = new User();
        user.setId("2");
        user.setName("2");
        user.setPassword("22222");
        return userService.register(user);
    }
}
