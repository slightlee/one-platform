package com.one.service.system.api.entity;

import java.time.LocalDateTime;

import com.one.mybatis.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色和权限关联表
 * </p>
 *
 * @author 明天
 * @since 2021-08-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="PlatformRoleResource对象", description="角色和权限关联表")
public class PlatformRoleResource extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "租户id")
    private Long tenantId;

    @ApiModelProperty(value = "角色id")
    private Long roleId;

    @ApiModelProperty(value = "资源id")
    private Long resourceId;

}
