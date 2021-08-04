package com.one.service.system.controller;


import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.one.platform.base.enums.ResultCodeEnum;
import com.one.platform.base.result.Result;
import com.one.platform.base.util.BeanCopierUtils;
import com.one.service.system.api.entity.User;
import com.one.service.system.api.entity.dto.CreateUserDTO;
import com.one.service.system.api.entity.dto.UpdateUserDTO;
import com.one.service.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "user")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Api(tags = "UserController|用户相关前端控制器")
@ApiSupport(order = 10)
public class UserController {

    private final UserService userService;

    /**
     * 用户列表
     */
    @GetMapping("/list")
    @ApiOperation(value = "用户列表")
    @ApiOperationSupport(order = 1)
    public Result<List<User>> list() {
        List<User> list = userService.list();
        return Result.data(list);
    }


    /**
     * 添加用户
     */
    @PostMapping("/create")
    @ApiOperation(value = "添加用户")
    @ApiOperationSupport(order =2)
    public Result create(@RequestBody CreateUserDTO createUserDTO) {

        User user = BeanCopierUtils.copyByClass(createUserDTO, User.class);
        boolean result = userService.save(user);
        if (result) {
            return Result.success();
        } else {
            return Result.error(ResultCodeEnum.FAILED);
        }
    }

    /**
     * 修改用户
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改用户")
    @ApiOperationSupport(order = 3)
    public Result update(@RequestBody UpdateUserDTO updateUserDTO) {

        User user = BeanCopierUtils.copyByClass(updateUserDTO, User.class);
        boolean result = userService.updateById(user);
        if (result) {
            return Result.success();
        } else {
            return Result.error(ResultCodeEnum.FAILED);
        }
    }

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
        boolean result = userService.removeById(userId);
        if (result) {
            return Result.success();
        } else {
            return Result.error(ResultCodeEnum.FAILED);
        }
    }

}
