package com.diflows.backend.dao;

import com.diflows.backend.model.FlowsMsg;

public interface IFlowsMsgDao {
    FlowsMsg getOne(int timestamps);
}
