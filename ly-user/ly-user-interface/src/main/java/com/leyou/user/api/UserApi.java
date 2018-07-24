package com.leyou.user.api;

import com.leyou.common.base.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @author chendong
 * @date 2018-07-11
 * @description 对外提供的服务的接口
 */

public interface UserApi {

    @GetMapping("/{id}")
    Result queryUserById(@PathVariable("id") Long id);

    @PostMapping
    Result queryUser(@RequestParam("mobile") String mobile,
                     @RequestParam("password") String password);

}
