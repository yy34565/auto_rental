package com.tjgd.rental.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author WU
 * @since 2026-04-10
 */
@Data
@TableName("sys_user")
@Accessors(chain = true)
@ApiModel(value = "User对象", description = "")
public class User implements Serializable, UserDetails {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户账户
     */
    @ApiModelProperty("用户账户")
    private String username;

    /**
     * 用户密码
     */
    @ApiModelProperty("用户密码")
    private String password;

    /**
     * 账户是否过期
     */
    @ApiModelProperty("账户是否过期")
    private Boolean isAccountNonExpired=true;

    /**
     * 账户是否被锁定
     */
    @ApiModelProperty("账户是否被锁定")
    private Boolean isAccountNonLocked=true;

    /**
     * 密码是否过期
     */
    @ApiModelProperty("密码是否过期")
    private Boolean isCredentialsNonExpired=true;

    /**
     * 账户是否可用
     */
    @ApiModelProperty("账户是否可用")
    private Boolean isEnabled=true;

    /**
     * 用户真实姓名
     */
    @ApiModelProperty("用户真实姓名")
    private String realname;

    /**
     * 用户昵称
     */
    @ApiModelProperty("用户昵称")
    private String nickname;

    /**
     * 所属部门id
     */
    @ApiModelProperty("所属部门id")
    private Integer deptId;

    /**
     * 所属部门名称
     */
    @ApiModelProperty("所属部门名称")
    private String deptName;

    /**
     * 性别
     */
    @ApiModelProperty("性别")
    private Boolean gender;

    /**
     * 联系电话
     */
    @ApiModelProperty("联系电话")
    private String phone;

    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String email;

    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String avatar;

    /**
     * 是否管理员
     */
    @ApiModelProperty("是否管理员")
    private Boolean isAdmin;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 是否删除
     */
    @ApiModelProperty("是否删除")
    private Boolean deleted;

  @TableField(exist = false)
  //获取权限
    public Collection<? extends GrantedAuthority> authorities ;


  @TableField(exist = false)
    private List<Permission> permissionList;




}
