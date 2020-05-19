package com.example.seata.transcation.manage.tcc;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

/**
 * @author boomboompow
 * @date 2020/5/19 2:00 PM
 */
@LocalTCC
public interface TccLocalAction {

    @TwoPhaseBusinessAction(name = "TccActionOne", commitMethod = "commit", rollbackMethod = "rollback")
    boolean prepare(BusinessActionContext actionContext, String businessParam);

    boolean commit (BusinessActionContext actionContext);

    boolean rollback(BusinessActionContext actionContext);


}
