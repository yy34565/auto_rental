package com.tjgd.rental.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tjgd.rental.entity.User;
import com.tjgd.rental.mapper.UserMapper;
import com.tjgd.rental.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WU
 * @since 2026-04-10
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    @Override
    public User selectByUsername(String username) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",username);
        return baseMapper.selectOne(queryWrapper);

    }

    @Override
    public List<String> selectRoleName(int id) {
        return baseMapper.selectRoleNameByUserId(id);
    }
}
