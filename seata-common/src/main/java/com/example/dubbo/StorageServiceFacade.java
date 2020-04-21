package com.example.dubbo;

import com.example.dto.CommodityDTO;
import com.example.response.DubboResponse;

/**
 * 库存dubbo接口
 * @author boomboompow
 */
public interface StorageServiceFacade {

    /**
     * 扣减库存
     * @param commodityDTO
     * @return
     */
    DubboResponse decreaseStorage (CommodityDTO commodityDTO);
}
