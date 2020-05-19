package com.example.seata.order.service;

import com.example.dto.OrderDTO;
import com.example.response.DubboResponse;

/**
 * 订单服务
 * @author boomboompow
 * @date 2020/5/19 2:00 PM
 */
public interface OrderService {

    DubboResponse createOrder(OrderDTO orderDTO);
}
