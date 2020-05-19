package com.example.seata.order.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.dto.AccountDTO;
import com.example.dto.OrderDTO;
import com.example.dubbo.AccountServiceFacade;
import com.example.enums.ResponseCodeEnum;
import com.example.response.DubboResponse;
import com.example.seata.order.entity.OrderDO;
import com.example.seata.order.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author boomboompow
 * @date 2020/5/19 2:00 PM
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Reference(check = false)
    private AccountServiceFacade accountServiceFacade;

    @Resource
    private OrderMapper orderMapper;

    @Override
    public DubboResponse createOrder(OrderDTO orderDTO) {

        //扣减用户余额
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUserId(orderDTO.getUserId());
        accountDTO.setAmount(orderDTO.getOrderAmount());
        DubboResponse response = accountServiceFacade.decreaseAccount(accountDTO);
        log.info("扣减余额结果：result{}",response);

        //创建订单
        OrderDO order = new OrderDO();
        order.setCommodityCode(orderDTO.getCommodityCode())
                .setUserId(orderDTO.getUserId())
                .setAmount(orderDTO.getOrderAmount())
                .setCount(orderDTO.getOrderCount())
                .setOrderNo(UUID.randomUUID().toString().replace("-","").substring(0,10));
        try {
            orderMapper.createOrder(order);
            log.info("创建订单成功, OrderDO:{}", orderDTO);
            return DubboResponse.success(null);
        } catch (Exception e) {
            log.info("创建订单失败");
            return DubboResponse.fail(ResponseCodeEnum.FAIL);
        }


    }
}
