package com.one.system.controller;


import com.one.platform.base.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "user")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Api(tags = "UserController|用户相关前端控制器")
public class UserController {


    /**
     * 测试
     */
    @GetMapping("/list")
    @ApiOperation(value = "测试")
    public Result list() {
        return Result.data("测试！！！！！！！！");
    }

}
