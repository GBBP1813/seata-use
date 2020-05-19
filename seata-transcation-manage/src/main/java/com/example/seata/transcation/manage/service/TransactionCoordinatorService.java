package com.example.seata.transcation.manage.service;


import com.alibaba.dubbo.config.annotation.Reference;
import com.example.dto.BusinessDTO;
import com.example.dto.CommodityDTO;
import com.example.dto.OrderDTO;
import com.example.dubbo.OrderServiceFacade;
import com.example.dubbo.StorageServiceFacade;
import com.example.response.DubboResponse;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author boomboompow
 * @date 2020/5/19 2:00 PM
 */
@Slf4j
@Service
public class TransactionCoordinatorService {

    @Reference
    private StorageServiceFacade storageServiceFacade;

    @Reference
    private OrderServiceFacade orderServiceFacade;


    @GlobalTransactional(name = "mock-tx",timeoutMills = 300000)
    public DubboResponse mockDistributedTransaction(BusinessDTO businessDTO, boolean  throwException) {
        log.info("开启全局事务，XID:{}", RootContext.getXID());


        //扣减库存
        CommodityDTO commodityDTO = new CommodityDTO();
        commodityDTO.setCommodityCode(businessDTO.getCommodityCode())
                .setCount(businessDTO.getCount());
        DubboResponse response = storageServiceFacade.decreaseStorage(commodityDTO);

        //创建订单，并扣除用户账户金额
        OrderDTO orderDTO= new OrderDTO();
        orderDTO.setCommodityCode(businessDTO.getCommodityCode())
                .setOrderAmount(businessDTO.getAmount())
                .setOrderCount(businessDTO.getCount())
                .setUserId(businessDTO.getUserId());
        DubboResponse dubboResponse = orderServiceFacade.createOrder(orderDTO);

        if (!response.isSuccess() || !dubboResponse.isSuccess()) {
            throw new RuntimeException("dubbo接口出险异常");
        }

        if (throwException) {
            throw new RuntimeException("mock出险异常，分布式事务回滚");
        }

        return DubboResponse.success(null);

    }
}
