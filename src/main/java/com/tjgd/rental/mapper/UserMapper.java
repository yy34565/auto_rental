package com.tjgd.rental.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tjgd.rental.entity.User;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author WU
 * @since 2026-04-10
 */
public interface UserMapper extends BaseMapper<User> {
    List<String> selectRoleNameByUserId(Integer userId);

}
