package com.tjgd.rental.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@TableName("busi_maintain")
@ApiModel(value = "Maintain对象", description = "")
public class Maintain implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 保养id
     */
    @ApiModelProperty("保养id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 车辆id
     */
    @ApiModelProperty("车辆id")
    private Integer autoId;

    /**
     * 车牌号码
     */
    @ApiModelProperty("车牌号码")
    private String autoNum;

    /**
     * 维保时间
     */
    @ApiModelProperty("维保时间")
    private LocalDateTime maintainTime;

    /**
     * 维保地点
     */
    @ApiModelProperty("维保地点")
    private String location;

    /**
     * 维保项目
     */
    @ApiModelProperty("维保项目")
    private String item;

    /**
     * 维保费用
     */
    @ApiModelProperty("维保费用")
    private Integer cost;

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
     * 是否删除
     */
    @ApiModelProperty("是否删除")
    private Boolean deleted;
}
