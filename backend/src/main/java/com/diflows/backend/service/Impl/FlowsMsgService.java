package com.diflows.backend.service.Impl;

import com.diflows.backend.dao.IFlowsMsgDao;
import com.diflows.backend.model.FlowsMsg;
import com.diflows.backend.service.IFlowsMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FlowsMsgService implements IFlowsMsgService {

    private final IFlowsMsgDao flowsMsgDao;

    @Autowired
    public FlowsMsgService(IFlowsMsgDao flowsMsgDao) {
        this.flowsMsgDao = flowsMsgDao;
    }

    @Override
    public FlowsMsg getOne(int timestamps) {
        return flowsMsgDao.getOne(timestamps);
    }

}
