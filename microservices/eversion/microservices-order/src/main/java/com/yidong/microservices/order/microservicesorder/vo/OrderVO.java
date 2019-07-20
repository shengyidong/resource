package com.yidong.microservices.order.microservicesorder.vo;

import java.io.Serializable;

public class OrderVO implements Serializable {

    private String name;

    public OrderVO() {
    }

    public OrderVO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
