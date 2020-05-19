package com.example.seata.storage.service;

import com.example.dto.CommodityDTO;
import com.example.response.DubboResponse;

/**
 * 库存服务
 * @author boomboompow
 * @date 2020/5/19 2:00 PM
 */
public interface StorageService {

    /**
     * 扣减库存
     * @param commodityDTO
     * @return
     */
    DubboResponse decreaseStorage(CommodityDTO commodityDTO);
}
