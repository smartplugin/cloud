package com.leyou.user.controller;

import com.leyou.common.base.Result;
import com.leyou.user.bean.UserInfoBean;
import com.leyou.user.service.IUserInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author chendong
 * @date 2018-07-03
 * @description
 */
@RestController
public class UserInfoController {

    @Autowired
    private IUserInfoService userInfoService;

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Result queryUserById(@PathVariable Long id) {
        if (id == null) {
            return new Result(Result.SUCCESS_CODE, "请输入正确的id");
        }
        UserInfoBean user = userInfoService.queryUserById(id);
        if (user == null) {
            return new Result(Result.SUCCESS_CODE, "查无此人");
        }
        return new Result(Result.SUCCESS_CODE, "查询成功", user);
    }

    @PostMapping
    @ResponseBody
    public Result queryUser(
            @RequestParam("mobile") String mobile,
            @RequestParam("password") String password) {
        if (StringUtils.isBlank(mobile) || StringUtils.isBlank(password)) {
            return new Result(Result.SUCCESS_CODE, "账号或密码输入有误");
        }
        UserInfoBean user = userInfoService.queryUser(mobile, password);
        if (user == null) {
            return new Result(Result.SUCCESS_CODE, "账号或密码错误");
        }
        return new Result(Result.SUCCESS_CODE, "查询成功", user);
    }

}
