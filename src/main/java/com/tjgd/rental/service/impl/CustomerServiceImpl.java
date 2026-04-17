package com.tjgd.rental.service.impl;

import com.tjgd.rental.entity.Customer;
import com.tjgd.rental.mapper.CustomerMapper;
import com.tjgd.rental.service.ICustomerService;
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
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

}
