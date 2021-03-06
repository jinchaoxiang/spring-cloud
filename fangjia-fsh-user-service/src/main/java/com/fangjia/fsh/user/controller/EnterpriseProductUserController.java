package com.fangjia.fsh.user.controller;

import com.fangjia.common.base.ResponseData;
import com.fangjia.fsh.user.query.LoginQuery;
import com.fangjia.fsh.user.service.EnterpriseProductUserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 企业用户控制器
 *
 * @author yinjihuan
 * @create 2017-11-22 14:48
 **/
@RestController
@RequestMapping("/user")
public class EnterpriseProductUserController {

    @Autowired
    private EnterpriseProductUserService enterpriseProductUserService;

    /**
     * 用户登录
     * @param query
     * @return
     */
    @ApiOperation(value = "用户登录", notes = "企业用户认证接口，参数为必填项")
    @PostMapping("/login")
    public ResponseData login(@ApiParam(value = "登录参数", required = true) @RequestBody LoginQuery query) {
        if (query == null || query.getEid() == null || StringUtils.isBlank(query.getUid())) {
            return ResponseData.failByParam("eid和uid不能为空");
        }
        return ResponseData.ok(enterpriseProductUserService.login(query.getEid(), query.getUid()));
    }

}
