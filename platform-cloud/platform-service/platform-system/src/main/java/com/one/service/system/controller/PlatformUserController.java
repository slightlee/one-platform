package com.one.service.system.controller;


import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.one.platform.base.result.Result;
import com.one.platform.base.util.BeanCopierUtils;
import com.one.service.system.api.entity.PlatformUser;
import com.one.service.system.api.entity.dto.AddUserDTO;
import com.one.service.system.api.entity.dto.UpdateUserDTO;
import com.one.service.system.service.PlatformUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 明天
 * @since 2021-08-04
 */
@RestController
@RequestMapping("/platform-user")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Api(tags = "用户相关")
@ApiSupport(order = 10)
public class PlatformUserController {


    private final PlatformUserService userService;

    /**
     * 用户列表
     */
    @GetMapping("/list")
    @ApiOperation(value = "用户列表")
    @ApiOperationSupport(order = 1)
    public Result<List<PlatformUser>> list() {
        List<PlatformUser> list = userService.list();
        return Result.data(list);
    }


    /**
     * 添加用户
     */
    @PostMapping("/create")
    @ApiOperation(value = "添加用户")
    @ApiOperationSupport(order =2)
    public Result create(@RequestBody AddUserDTO addUserDTO) {

        PlatformUser user = BeanCopierUtils.copyByClass(addUserDTO, PlatformUser.class);
        return Result.status(userService.save(user));
    }

    /**
     * 修改用户
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改用户")
    @ApiOperationSupport(order = 3)
    public Result update(@RequestBody UpdateUserDTO updateUserDTO) {

        PlatformUser user = BeanCopierUtils.copyByClass(updateUserDTO, PlatformUser.class);
        return Result.status(userService.updateById(user));
    }


    // TODO 待完善 增加校验
    /**
     * 删除用户
     */
    @DeleteMapping("/delete/{userId}")
    @ApiOperation(value = "删除用户")
    @ApiOperationSupport(order = 4)
    @ApiImplicitParam(paramType = "path", name = "userId", value = "用户ID", required = true, dataType = "Long")
    public Result delete(@PathVariable("userId") Long userId) {
        if (null == userId) {
            return Result.error("用户ID不能为空");
        }
        return Result.status(userService.removeById(userId));
    }

}

