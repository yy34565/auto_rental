package com.tjgd.rental.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tjgd.rental.entity.Permission;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author WU
 * @since 2026-04-10
 */
public interface PermissionMapper extends BaseMapper<Permission> {
    List<Permission> selectPermissionListByUserId(Integer userId);

}
