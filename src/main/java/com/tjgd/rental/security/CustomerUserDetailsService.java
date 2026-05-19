package com.tjgd.rental.security;

import com.tjgd.rental.entity.Permission;
import com.tjgd.rental.entity.User;
import com.tjgd.rental.service.IPermissionService;
import com.tjgd.rental.service.IUserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;


@Component
public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserService userService;


    @Resource
    private IPermissionService permissionService;

    // 用户登录,username为用户名 Userdetails为用户信息
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        User user=userService.selectByUsername(username);//到数据库按username查询用户信息
        if(user==null){
            throw new UsernameNotFoundException("用户不存在");
        }
        //查询用户权限列表
        List<Permission> permissions =
                permissionService.selectPermissionListByUserId(user.getId());
        user.setPermissionList(permissions);
//通过stream流处理，将权限对象转换为权限字符串列表
        List<String> list = permissions.stream().filter(obj -> Objects.nonNull(obj))
                .map(permission -> permission.getPermissionCode())
                .filter(obj1 -> Objects.nonNull(obj1))
                .toList();
        String[] array = list.toArray(new String[list.size()]);
        List<GrantedAuthority> authorityList=
                AuthorityUtils.createAuthorityList(array);
        user.setAuthorities(authorityList);





        return user;
    }
}
