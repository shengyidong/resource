package com.yidong.microservices.order.microservicesorder.controller;

import com.yidong.microservices.order.microservicesorder.service.UserService;
import com.yidong.microservices.user.microservicesuser.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class OrderController {

    private final Logger logger = Logger.getLogger(OrderController.class.getName());

    @Autowired
    private UserService userService;

    @GetMapping("/order/list")
    public List<UserVO> list() {
        logger.info(String.format("[%s]", "order.list"));
        return userService.list();
    }

    @PostMapping("/order/add")
    public UserVO add(@RequestBody UserVO userVO) {
        logger.info(String.format("[%s] name is %s", "order.add", userVO.getName()));
        return userService.add(userVO);
    }

}
