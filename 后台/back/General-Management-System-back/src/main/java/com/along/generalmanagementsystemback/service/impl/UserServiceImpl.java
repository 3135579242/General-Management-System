package com.along.generalmanagementsystemback.service.impl;

import com.along.generalmanagementsystemback.domain.dto.UserLoginDTO;
import com.along.generalmanagementsystemback.domain.entity.Menu;
import com.along.generalmanagementsystemback.domain.entity.User;
import com.along.generalmanagementsystemback.domain.vo.MenuListVO;
import com.along.generalmanagementsystemback.mapper.MenuMapper;
import com.along.generalmanagementsystemback.mapper.UserMapper;
import com.along.generalmanagementsystemback.service.IUserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 时间 2024年08月07日
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<User> getUserList() {
        return userMapper.selectAll();
    }

    @Override
    public List<User> getUserByName(String name) {
        return userMapper.selectByName(name);
    }

    @Override
    public IPage<User> getPagesUser(Integer page, Integer size) {
        Page<User> userPage = new Page<>(page, size);
        return userMapper.selectPage(userPage, null);
    }

    @Override
    public void deleteUser(Integer id) {
        userMapper.deleteUser(id);
    }

    @Override
    public void addUser(User user) {
        user.setBirthDate(user.getBirthDate().split("T")[0]);
        userMapper.saveUser(user);
    }

    @Override
    public void editUser(User user) {
        user.setBirthDate(user.getBirthDate().split("T")[0]);
        userMapper.updateUser(user);
    }

    @Override
    public User getByIdUser(Integer id) {
        return userMapper.selectByIdUser(id);
    }

    @Override
    public MenuListVO login(UserLoginDTO userLoginDTO) {
        Long userId = userMapper.login(userLoginDTO);
        List<Menu> menus = menuMapper.selectMenuList(userId);
        for (Menu menu : menus) {
            List<Menu> childrenList = menuMapper.selectByChildrenIdMenuList(menu.getChildren());
            menu.setChildrenItem(childrenList);
        }
        return MenuListVO.builder()
                .menuList(menus)
                .build();
    }

}
