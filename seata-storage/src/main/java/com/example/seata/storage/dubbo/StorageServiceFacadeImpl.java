package com.example.seata.storage.dubbo;


import com.alibaba.dubbo.config.annotation.Service;
import com.example.dto.CommodityDTO;
import com.example.dubbo.StorageServiceFacade;
import com.example.response.DubboResponse;
import com.example.seata.storage.service.StorageService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Slf4j
public class StorageServiceFacadeImpl  implements StorageServiceFacade {

    @Autowired
    private StorageService storageService;

    @Override
    public DubboResponse decreaseStorage(CommodityDTO commodityDTO) {
        log.info("全局事务id：{}", RootContext.getXID());
        return storageService.decreaseStorage(commodityDTO);
    }
}
