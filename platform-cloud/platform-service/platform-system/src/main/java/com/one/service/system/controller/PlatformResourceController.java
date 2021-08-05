package com.one.service.system.controller;


import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 权限表 前端控制器
 * </p>
 *
 * @author 明天
 * @since 2021-08-04
 */
@RestController
@RequestMapping("/platform-resource")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Api(tags = "权限相关")
@ApiSupport(order = 30)
public class PlatformResourceController {

}

