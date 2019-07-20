package com.yidong.microservices.user.microservicesuser.controller;

import main.java.com.yidong.microservices.basic.vo.UserVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class UserController {

    private final Logger logger = Logger.getLogger(UserController.class.getName());

    private static int id = 0;

    private static List<UserVO> list = new ArrayList<>();

    @GetMapping("/user/list")
    public List<UserVO> list() {
        logger.info(String.format("[%s] list size is %d", "user.list", list.size()));
        return list;
    }

    @PostMapping("/user/add")
    public UserVO add(@RequestBody UserVO userVO) {
        userVO.setId(++id);
        logger.info(String.format("[%s] user id %d,user name is %s", "user.add", userVO.getId(), userVO.getName()));
        list.add(userVO);
        logger.info(String.format("[%s] list size is %d", "user.add", list.size()));
        return userVO;
    }

}
