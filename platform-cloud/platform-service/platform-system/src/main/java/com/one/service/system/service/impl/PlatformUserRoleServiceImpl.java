package com.one.service.system.service.impl;

import com.one.service.system.api.entity.PlatformUserRole;
import com.one.service.system.mapper.PlatformUserRoleMapper;
import com.one.service.system.service.PlatformUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户和角色关联表 服务实现类
 * </p>
 *
 * @author 明天
 * @since 2021-08-04
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PlatformUserRoleServiceImpl extends ServiceImpl<PlatformUserRoleMapper, PlatformUserRole> implements PlatformUserRoleService {

}
