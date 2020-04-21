package com.example.dubbo;

import com.example.dto.OrderDTO;
import com.example.response.DubboResponse;

/**
 * 订单dubbo接口
 * @author boomboompow
 */
public interface OrderServiceFacade {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    DubboResponse createOrder(OrderDTO orderDTO);
}
