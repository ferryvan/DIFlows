package com.diflows.backend.dao.Impl;

import com.diflows.backend.dao.IFlowsMsgDao;
import com.diflows.backend.mapper.FlowsMsgMapper;
import com.diflows.backend.model.FlowsMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class FlowsMsgDaoImpl implements IFlowsMsgDao {
    
    private final FlowsMsgMapper flowsMsgMapper;

    @Autowired
    public FlowsMsgDaoImpl(FlowsMsgMapper flowsMsgMapper) {
        this.flowsMsgMapper = flowsMsgMapper;
    }

    @Override
    public FlowsMsg getOne(int timestamps) {
        flowsMsgMapper.insert(new FlowsMsg(timestamps));
        return flowsMsgMapper.getOne(timestamps);
    }
}
