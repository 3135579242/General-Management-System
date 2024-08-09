package com.along.generalmanagementsystemback.mapper;


import com.along.generalmanagementsystemback.domain.dto.UserLoginDTO;
import com.along.generalmanagementsystemback.domain.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<User> selectAll();

    List<User> selectByName(String name);

    void deleteUser(Integer id);

    void saveUser(User user);

    void updateUser(User user);

    User selectByIdUser(Integer id);

    Long login(UserLoginDTO userLoginDTO);

}
