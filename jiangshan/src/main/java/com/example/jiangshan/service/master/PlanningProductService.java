package com.example.jiangshan.service.master;

import com.example.jiangshan.mapper.master.PlanningProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class PlanningProductService {
    @Autowired
    private PlanningProductMapper planningProductMapper;
    public List getStatistics(String typeInFuture){
        return planningProductMapper.getAttractInvestmentStatistics(typeInFuture);
    }

    public  List getList(){
        return planningProductMapper.getAttractInvestmentList();
    }

    public HashMap planningProductStatistics() {
        HashMap AttractInvestment = new HashMap();
        AttractInvestment.put("planProject", this.getStatistics("1"));
        AttractInvestment.put("completedProject", this.getStatistics("3"));
        AttractInvestment.put("ongoingProject", this.getStatistics("2"));
        AttractInvestment.put("AttractInvestmentList", this.getList());
        return AttractInvestment;
    }
}
