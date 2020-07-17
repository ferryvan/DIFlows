package com.diflows.backend.controller;

import com.diflows.backend.aspect.DiFlowsLog;
import com.diflows.backend.model.FlowsMsg;
import com.diflows.backend.service.IFlowsMsgService;
import com.diflows.backend.service.Impl.FlowsMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MyController {

    private final IFlowsMsgService flowsMsgService;

    @Autowired
    public MyController(IFlowsMsgService flowsMsgService) {
        this.flowsMsgService = flowsMsgService;
    }

    @DiFlowsLog
    @GetMapping("/")
    public FlowsMsg sayHello(){
        return flowsMsgService.getOne(2);
    }
}
