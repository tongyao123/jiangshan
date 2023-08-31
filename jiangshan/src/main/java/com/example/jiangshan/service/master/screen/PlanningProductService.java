package com.example.jiangshan.service.master.screen;

import com.example.jiangshan.mapper.master.PlanningProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class PlanningProductService {
    @Autowired
    private PlanningProductMapper planningProductMapper;

    public List getStatistics(@Param("typeInFuture") String typeInFuture, @Param("town") String town, @Param("village") String village) {
        return planningProductMapper.getAttractInvestmentStatistics(typeInFuture, town, village);
    }

    public List getList() {
        return planningProductMapper.getAttractInvestmentList();
    }

    public HashMap planningProductStatistics(@Param("town") String town, @Param("village") String village) {
        HashMap AttractInvestment = new HashMap();
        AttractInvestment.put("planProject", this.getStatistics("1", town, village));
        AttractInvestment.put("completedProject", this.getStatistics("3", town, village));
        AttractInvestment.put("ongoingProject", this.getStatistics("2", town, village));
        AttractInvestment.put("AttractInvestmentList", this.getList());
        return AttractInvestment;
    }
}
