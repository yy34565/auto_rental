package com.tjgd.rental.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author WU
 * @since 2026-04-10
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@TableName("sys_permission")
@ApiModel(value = "Permission对象", description = "")
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 权限id
     */
    @ApiModelProperty("权限id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 权限名称
     */
    @ApiModelProperty("权限名称")
    private String permissionLabel;

    /**
     * 父权限id
     */
    @ApiModelProperty("父权限id")
    private Integer pid;

    /**
     * 父权限名称
     */
    @ApiModelProperty("父权限名称")
    private String parentLabel;

    /**
     * 权限标识
     */
    @ApiModelProperty("权限标识")
    private String permissionCode;

    /**
     * 权限路由地址
     */
    @ApiModelProperty("权限路由地址")
    private String routePath;

    /**
     * 权限路由名称
     */
    @ApiModelProperty("权限路由名称")
    private String routeName;

    /**
     * 权限路径
     */
    @ApiModelProperty("权限路径")
    private String routeUrl;

    /**
     * 权限类型 0-根目录  1-子目录  2-按钮级别
     */
    @ApiModelProperty("权限类型 0-根目录  1-子目录  2-按钮级别")
    private Boolean permissionType;

    /**
     * 图标地址
     */
    @ApiModelProperty("图标地址")
    private String icon;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer orderNum;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;

    /**
     * 是否删除
     */
    @ApiModelProperty("是否删除")
    private Boolean deleted;


    @TableField(exist = false)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Permission> children;



}
