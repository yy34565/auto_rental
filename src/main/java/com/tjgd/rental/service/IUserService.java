package com.tjgd.rental.service;

import com.tjgd.rental.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WU
 * @since 2026-04-10
 */
public interface IUserService extends IService<User> {

    User selectByUsername(String username);

    List<String> selectRoleName(int id);


}
