package com.example.jiangshan.service.master.screen;

import com.example.jiangshan.mapper.master.AttractInvestmentMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AttractInvestmentService {
    @Autowired
    private AttractInvestmentMapper attractInvestmentMapper;

    public List getStatistics(String typeInFuture,@Param("town")String town, @Param("village") String village) {
        return attractInvestmentMapper.attractInvestmentStatistics(typeInFuture,town,village);
    }

    public List getList(@Param("town")String town, @Param("village") String village) {
        return attractInvestmentMapper.attractInvestmentList(town,village);
    }

    public List attractInvestmentDetailList(@Param("town")String town, @Param("village") String village) {
        return attractInvestmentMapper.attractInvestmentDetailList(town,village);
    }
    public List villageAttractInvestmentCoordinate(String village) {
        return attractInvestmentMapper.villageAttractInvestmentCoordinate(village);
    }
    public List villageList() {
        return attractInvestmentMapper.villageList();
    }
    public HashMap attractInvestmentStatistics(@Param("town")String town, @Param("village") String village) {
        HashMap AttractInvestment = new HashMap();
        AttractInvestment.put("planProject", this.getStatistics("1",town,village));
        AttractInvestment.put("completedProject", this.getStatistics("3",town,village));
        AttractInvestment.put("ongoingProject", this.getStatistics("2",town,village));
        AttractInvestment.put("AttractInvestmentList", this.getList(town,village));
        return AttractInvestment;
    }

}
