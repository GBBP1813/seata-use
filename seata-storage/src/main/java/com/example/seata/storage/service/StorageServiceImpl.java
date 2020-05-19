package com.example.seata.storage.service;

import com.example.dto.CommodityDTO;
import com.example.enums.ResponseCodeEnum;
import com.example.response.DubboResponse;
import com.example.seata.storage.mapper.StorageMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author boomboompow
 * @date 2020/5/19 2:00 PM
 */
@Service
@Slf4j
public class StorageServiceImpl  implements StorageService{

    @Resource
    private StorageMapper storageMapper;

    @Override
    public DubboResponse decreaseStorage(CommodityDTO commodityDTO) {


        log.info("开始扣减库存，commodityDTO:{}", commodityDTO);
        int count = storageMapper.decreaseStorage(commodityDTO.getCommodityCode(), commodityDTO.getCount());

        if (count > 0) {
            log.info("扣减库存成功");
            return DubboResponse.success(null);
        } else {
            log.error("扣减库存失败");
            return DubboResponse.fail(ResponseCodeEnum.FAIL);
        }

    }
}
