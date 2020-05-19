package com.example.seata.storage.controller;


import com.alibaba.fastjson.JSON;
import com.example.dto.CommodityDTO;
import com.example.response.DubboResponse;
import com.example.seata.storage.service.StorageService;
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
@RequestMapping("/storage")
@Slf4j
public class StorageController {

    @Autowired
    private StorageService storageService;


    @PostMapping("/duct")
    public DubboResponse decreaseStorageCount(@RequestBody CommodityDTO commodityDTO){
        log.info("扣减库存, commodity", JSON.toJSONString(commodityDTO));
        return storageService.decreaseStorage(commodityDTO);
    }


}
