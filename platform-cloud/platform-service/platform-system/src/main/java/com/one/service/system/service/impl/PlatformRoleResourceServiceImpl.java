package com.one.service.system.service.impl;

import com.one.service.system.api.entity.PlatformRoleResource;
import com.one.service.system.mapper.PlatformRoleResourceMapper;
import com.one.service.system.service.PlatformRoleResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色和权限关联表 服务实现类
 * </p>
 *
 * @author 明天
 * @since 2021-08-04
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PlatformRoleResourceServiceImpl extends ServiceImpl<PlatformRoleResourceMapper, PlatformRoleResource> implements PlatformRoleResourceService {

}
