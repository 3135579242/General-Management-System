package com.along.generalmanagementsystemback.controller;

import com.along.generalmanagementsystemback.domain.dto.UserLoginDTO;
import com.along.generalmanagementsystemback.domain.entity.Menu;
import com.along.generalmanagementsystemback.domain.entity.User;
import com.along.generalmanagementsystemback.domain.result.ResponseResult;
import com.along.generalmanagementsystemback.domain.vo.MenuListVO;
import com.along.generalmanagementsystemback.service.IUserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 时间 2024年08月07日
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService iUserService;

    @GetMapping("/list")
    public ResponseResult<List<User>> getUserList(){
        return ResponseResult.success(iUserService.getUserList());
    }

    @GetMapping("/name/{name}")
    public ResponseResult<List<User>> getUserByName(@PathVariable("name") String name){
        return ResponseResult.success(iUserService.getUserByName(name));
    }

    // http://localhost:8080/user/pages?page=1&size=2
    @GetMapping("/pages")
    public ResponseResult<IPage<User>> getPagesUser(@RequestParam("page") Integer page, @RequestParam("size") Integer size){
        return ResponseResult.success(iUserService.getPagesUser(page,size));
    }

    @DeleteMapping("/{id}")
    public ResponseResult<Void> deleteUser(@PathVariable Integer id){
        iUserService.deleteUser(id);
        return ResponseResult.success();
    }

    @PostMapping
    public ResponseResult<Void> addUser(@RequestBody User user){
        iUserService.addUser(user);
        return ResponseResult.success();
    }

    @PutMapping
    public ResponseResult<Void> editUser(@RequestBody User user){
        iUserService.editUser(user);
        return ResponseResult.success();
    }

    @GetMapping("/{id}")
    public ResponseResult<User> getByIdUser(@PathVariable Integer id){
        return ResponseResult.success(iUserService.getByIdUser(id));
    }


    @PostMapping("/login")
    public ResponseResult<MenuListVO> login(@RequestBody UserLoginDTO userLoginDTO){
        MenuListVO menuList = iUserService.login(userLoginDTO);
        return ResponseResult.success(menuList);
    }


}
