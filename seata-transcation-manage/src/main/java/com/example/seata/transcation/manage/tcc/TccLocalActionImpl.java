package com.example.seata.transcation.manage.tcc;

import io.seata.core.context.RootContext;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TccLocalActionImpl implements TccLocalAction {

    @Override
    public boolean prepare(BusinessActionContext actionContext, String businessParam) {
        log.info("TccLocalAction prepare, xid:{}, bussinessParam:{}", actionContext.getXid(),businessParam);
        return true;
    }

    @Override
    public boolean commit(BusinessActionContext actionContext) {
        log.info("TccLocalAction commit, xid:{}", actionContext.getXid());
        return true;
    }

    @Override
    public boolean rollback(BusinessActionContext actionContext) {
        log.info("TccLocalAction rollback, xid:{}", actionContext.getXid());
        return true;
    }
}
