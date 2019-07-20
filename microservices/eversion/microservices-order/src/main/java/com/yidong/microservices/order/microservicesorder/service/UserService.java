package com.yidong.microservices.order.microservicesorder.service;

import com.yidong.microservices.user.microservicesuser.vo.UserVO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("user-service")
public interface UserService {

    @GetMapping("/user/list")
    List<UserVO> list();

    @PostMapping("/user/add")
    UserVO add(@RequestBody UserVO userVO);

}
