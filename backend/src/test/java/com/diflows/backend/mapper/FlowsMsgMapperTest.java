package com.diflows.backend.mapper;

import com.diflows.backend.model.FlowsMsg;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class FlowsMsgMapperTest {

    @Autowired
    private FlowsMsgMapper flowsMsgMapper;

    @Test
    public void testAll() throws Exception {
        int countFlowsMsg=flowsMsgMapper.getAll().size();
        flowsMsgMapper.insert(new FlowsMsg(1));
        flowsMsgMapper.insert(new FlowsMsg(2));
        flowsMsgMapper.insert(new FlowsMsg(3));
        Assert.assertEquals(3, flowsMsgMapper.getAll().size()-countFlowsMsg);

        System.out.println(flowsMsgMapper.getAll());
        flowsMsgMapper.update(2,1);
        System.out.println(flowsMsgMapper.getAll());

        Assert.assertEquals(new FlowsMsg(1), flowsMsgMapper.getOne(1));

        flowsMsgMapper.delete(1);
        flowsMsgMapper.delete(2);
        flowsMsgMapper.delete(3);
        Assert.assertEquals(0, flowsMsgMapper.getAll().size());
    }

}
