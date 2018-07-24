package com.leyou.auth.client;

import com.leyou.user.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author chendong
 * @date 2018-07-11
 * @description
 */

@FeignClient(value = "user-service")
public interface UserClient extends UserApi {
}
