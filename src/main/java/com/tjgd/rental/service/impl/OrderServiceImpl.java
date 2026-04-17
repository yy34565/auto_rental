package com.tjgd.rental.service.impl;

import com.tjgd.rental.entity.Order;
import com.tjgd.rental.mapper.OrderMapper;
import com.tjgd.rental.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WU
 * @since 2026-04-10
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
