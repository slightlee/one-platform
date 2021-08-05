package com.one.service.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.one.service.system.api.entity.PlatformRole;
import com.one.service.system.api.entity.dto.AddRoleDTO;
import com.one.service.system.api.entity.dto.UpdateRoleDTO;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author 明天
 * @since 2021-08-04
 */
public interface PlatformRoleService extends IService<PlatformRole> {


    /**
     * 角色列表
     * @param page
     * @param role
     * @return
     */
    Page<PlatformRole> roleList(Page<PlatformRole> page, PlatformRole role);

    /**
     * 添加角色
     */
    boolean saveRole(AddRoleDTO roleDTO);

    boolean updateRole(UpdateRoleDTO roleDTO);
}
