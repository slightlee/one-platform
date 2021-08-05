package com.one.service.system.api.entity;

import com.one.mybatis.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author 明天
 * @since 2021-08-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="PlatformResource对象", description="权限表")
public class PlatformResource extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "父id")
    private Long parentId;

    @ApiModelProperty(value = "资源名称")
    private String resourceName;

    @ApiModelProperty(value = "资源标识")
    private String resourceKey;

    @ApiModelProperty(value = "资源类型 1、模块 2、菜单 3、按钮 4、链接")
    private String resourceType;

    @ApiModelProperty(value = "资源图标")
    private String resourceIcon;

    @ApiModelProperty(value = "资源路径")
    private String resourcePath;

    @ApiModelProperty(value = "资料链接")
    private String resourceUrl;

    @ApiModelProperty(value = "资源级别")
    private Integer resourceLevel;

    @ApiModelProperty(value = "是否显示")
    private Boolean resourceShow;

    @ApiModelProperty(value = "是否缓存")
    private Boolean resourceCache;

    @ApiModelProperty(value = "资源页面名称")
    private String resourcePageName;

    @ApiModelProperty(value = "0 启用 1 禁用")
    private Integer resourceStatus;

    @ApiModelProperty(value = "备注")
    private String comments;


}
