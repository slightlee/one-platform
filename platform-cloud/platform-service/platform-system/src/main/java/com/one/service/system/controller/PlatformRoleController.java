package com.one.service.system.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.one.platform.base.result.PageResult;
import com.one.platform.base.result.Result;
import com.one.platform.base.util.BeanCopierUtils;
import com.one.service.system.api.entity.PlatformRole;
import com.one.service.system.api.entity.dto.AddRoleDTO;
import com.one.service.system.api.entity.dto.UpdateRoleDTO;
import com.one.service.system.service.PlatformRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author 明天
 * @since 2021-08-04
 */
@RestController
@RequestMapping("/platform-role")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Api(tags = "角色相关")
@ApiSupport(order = 20)
public class PlatformRoleController {

    private final PlatformRoleService roleService;


    // TODO 角色列表 条件查询待完善
    /**
     * 角色列表
     */
    @GetMapping("/list")
    @ApiOperation(value = "角色列表")
    @ApiOperationSupport(order = 1)
    public PageResult<PlatformRole> list(PlatformRole role, Page<PlatformRole> page) {
        Page<PlatformRole> pageRole = roleService.roleList(page, role);
        return PageResult.data(pageRole.getTotal(), pageRole.getRecords());
    }


    // TODO 添加角色 待完善
    /**
     * 添加角色
     */
    @PostMapping("/create")
    @ApiOperation(value = "添加角色")
    @ApiOperationSupport(order = 2)
    public Result saveRole(@RequestBody AddRoleDTO addRoleDTO) {
        boolean result = roleService.saveRole(addRoleDTO);
        return Result.status(result);
    }

    // TODO 修改角色 待完善
    /**
     * 修改角色
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改角色")
    @ApiOperationSupport(order = 3)
    public Result updateRole(@RequestBody UpdateRoleDTO updateRoleDTO) {
        return Result.status(roleService.updateRole(updateRoleDTO));
    }

    /**
     * 删除角色
     */
    @PostMapping("/delete/{roleId}")
    @ApiOperation(value = "删除角色")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "roleId", value = "角色ID", required = true, paramType = "path", dataType = "Long")
    })
    @ApiOperationSupport(order = 4)
    public Result delete(@PathVariable("roleId") Long roleId) {
        return Result.status(roleService.removeById(roleId));
    }
}

