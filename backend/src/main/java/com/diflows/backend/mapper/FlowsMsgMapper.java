package com.diflows.backend.mapper;

import com.diflows.backend.model.FlowsMsg;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface FlowsMsgMapper {

    @Select("SELECT * FROM flowsmsg ")
    List<FlowsMsg> getAll();

    @Insert("INSERT INTO flowsmsg(timestamps) VALUES(#{timestamps})")
    void insert(FlowsMsg flowsMsg);

    @Select("SELECT DISTINCT * FROM flowsmsg where timestamps = #{timestamps}")
    FlowsMsg getOne(int timestamps);

    @Delete("DELETE FROM flowsmsg where timestamps = #{timestamps}")
    void delete(int timestamps);

    @Update("UPDATE flowsmsg SET timestamps = #{newtimestamps} WHERE timestamps = #{timestamps}")
    void update(int timestamps, @Param("newtimestamps") int newtimestamps);

}
