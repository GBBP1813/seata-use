package com.example.seata.order.controller;

import com.alibaba.fastjson.JSON;
import com.example.dto.OrderDTO;
import com.example.response.DubboResponse;
import com.example.seata.order.service.OrderService;
import com.sun.org.apache.regexp.internal.RE;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author boomboompow
 * @date 2020/5/19 2:00 PM
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public DubboResponse createOrder(@RequestBody OrderDTO orderDTO) {

        log.info("请求创建订单，request:{}", JSON.toJSONString(orderDTO));
        return  orderService.createOrder(orderDTO);

    }
}
