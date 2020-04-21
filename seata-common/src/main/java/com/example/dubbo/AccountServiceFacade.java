package com.example.dubbo;

import com.example.dto.AccountDTO;
import com.example.response.DubboResponse;

import java.util.List;

/**
 * 账户服务接口
 * @author boomboompow
 */
public interface AccountServiceFacade {

    /**
     * 从账户扣钱
     * @param accountDTO
     * @return
     */
    DubboResponse decreaseAccount(AccountDTO accountDTO);

    DubboResponse<Boolean> callTccAction(String b, List<String> list);
}
