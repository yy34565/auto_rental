package com.tjgd.rental.service.impl;

import com.tjgd.rental.entity.Permission;
import com.tjgd.rental.mapper.PermissionMapper;
import com.tjgd.rental.service.IPermissionService;
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
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

    @Override
    public List<Permission> selectPermissionListByUserId(Integer userId) {

        return baseMapper.selectPermissionListByUserId(userId);

    }
}
