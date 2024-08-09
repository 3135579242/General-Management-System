package com.along.generalmanagementsystemback.service;

import com.along.generalmanagementsystemback.domain.dto.UserLoginDTO;
import com.along.generalmanagementsystemback.domain.entity.Menu;
import com.along.generalmanagementsystemback.domain.entity.User;
import com.along.generalmanagementsystemback.domain.vo.MenuListVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 时间 2024年08月07日
 */
public interface IUserService {

    List<User> getUserList();

    List<User> getUserByName(String name);


    IPage<User> getPagesUser(Integer page, Integer size);

    void deleteUser(Integer id);

    void addUser(User user);

    void editUser(User user);

    User getByIdUser(Integer id);

    MenuListVO login(UserLoginDTO userLoginDTO);

}
