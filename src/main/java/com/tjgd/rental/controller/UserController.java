package com.tjgd.rental.controller;

import com.tjgd.rental.service.IUserService;
import com.tjgd.rental.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author WU
 * @since 2026-04-10
 */
@RestController
@RequestMapping("/rental/user")
public class UserController {


    @Autowired
    private IUserService userService;


    @GetMapping
    public Result<List> list(){

        return Result.success(userService.list());

    }



}
