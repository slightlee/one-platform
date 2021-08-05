package com.one.service.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.one.platform.base.enums.ResultCodeEnum;
import com.one.platform.base.exception.PlatformException;
import com.one.platform.base.util.BeanCopierUtils;
import com.one.service.system.api.entity.PlatformRole;
import com.one.service.system.api.entity.dto.AddRoleDTO;
import com.one.service.system.api.entity.dto.UpdateRoleDTO;
import com.one.service.system.mapper.PlatformRoleMapper;
import com.one.service.system.service.PlatformRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author 明天
 * @since 2021-08-04
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PlatformRoleServiceImpl extends ServiceImpl<PlatformRoleMapper, PlatformRole> implements PlatformRoleService {


    @Override
    public Page<PlatformRole> roleList(Page<PlatformRole> page, PlatformRole role) {
        Page<PlatformRole> rolePage = this.baseMapper.selectPage(page, null);
        return rolePage;
    }

    @Override
    public boolean saveRole(AddRoleDTO roleDTO) {

        listByRoleNameOrRoleKey(roleDTO.getRoleName(), roleDTO.getRoleKey());
        PlatformRole platformRole = BeanCopierUtils.copyByClass(roleDTO, PlatformRole.class);
        return save(platformRole);

    }

    @Override
    public boolean updateRole(UpdateRoleDTO roleDTO) {
        listByRoleNameOrRoleKey(roleDTO.getRoleName(), roleDTO.getRoleKey());
        PlatformRole platformRole = BeanCopierUtils.copyByClass(roleDTO, PlatformRole.class);
        return updateById(platformRole);
    }

    /**
     * 根据角色名字 或 角色key 查询 角色是否存在
     * @param roleName
     * @param roleKey
     */
    private void listByRoleNameOrRoleKey(String roleName, String roleKey) {
        List<PlatformRole> list = this.baseMapper.selectList(new LambdaQueryWrapper<PlatformRole>()
                .eq(PlatformRole::getRoleName, roleName)
                .or().eq(PlatformRole::getRoleKey, roleKey));

        if(list.size() > 0){
            throw new PlatformException(ResultCodeEnum.DATA_IS_EXIST);
        }
    }
}
