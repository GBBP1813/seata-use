package com.example.seata.order.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.dto.OrderDTO;
import com.example.dubbo.OrderServiceFacade;
import com.example.response.DubboResponse;
import com.example.seata.order.service.OrderService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author boomboompow
 * @date 2020/5/19 2:00 PM
 */
@Service
@Slf4j
public class OrderServiceFacadeImpl implements OrderServiceFacade {

    @Autowired
    private OrderService orderService;

    @Override
    public DubboResponse createOrder(OrderDTO orderDTO) {
        log.info("全局事务Id{}", RootContext.getXID());
        return  orderService.createOrder(orderDTO);
    }
}
