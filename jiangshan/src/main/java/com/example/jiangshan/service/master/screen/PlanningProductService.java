package com.example.jiangshan.service.master.screen;

import com.example.jiangshan.mapper.master.PlanningProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class PlanningProductService {
    private final PlanningProductMapper planningProductMapper;

    public PlanningProductService(PlanningProductMapper planningProductMapper) {
        this.planningProductMapper = planningProductMapper;
    }

    public List getStatistics(@Param("typeInFuture") String typeInFuture, @Param("town") String town, @Param("village") String village) {
        return planningProductMapper.getAttractInvestmentStatistics(typeInFuture, town, village);
    }

    public List getList(@Param("town") String town, @Param("village") String village) {
        return planningProductMapper.getAttractInvestmentList(town, village);
    }

    public HashMap planningProductStatistics(@Param("town") String town, @Param("village") String village) {
        HashMap<String,List> planningProduct = new HashMap();
        planningProduct.put("planProject", this.getStatistics("1",town,village));
        planningProduct.put("completedProject", this.getStatistics("3",town,village));
        planningProduct.put("ongoingProject", this.getStatistics("2",town,village));
        planningProduct.put("AttractInvestmentList", this.getList(town,village));
        return planningProduct;
    }
}
