package com.example.jiangshan.service.master.screen;

import com.example.jiangshan.mapper.master.AttractInvestmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AttractInvestmentService {
    @Autowired
    private AttractInvestmentMapper attractInvestmentMapper;

    public List getStatistics(String typeInFuture) {
        return attractInvestmentMapper.attractInvestmentStatistics(typeInFuture);
    }

    public List getList() {
        return attractInvestmentMapper.attractInvestmentList();
    }

    public List attractInvestmentDetailList() {
        return attractInvestmentMapper.attractInvestmentDetailList();
    }
    public List villageAttractInvestmentCoordinate(String village) {
        return attractInvestmentMapper.villageAttractInvestmentCoordinate(village);
    }
    public List villageList() {
        return attractInvestmentMapper.villageList();
    }
    public HashMap attractInvestmentStatistics() {
        HashMap AttractInvestment = new HashMap();
        AttractInvestment.put("planProject", this.getStatistics("1"));
        AttractInvestment.put("completedProject", this.getStatistics("3"));
        AttractInvestment.put("ongoingProject", this.getStatistics("2"));
        AttractInvestment.put("AttractInvestmentList", this.getList());
        return AttractInvestment;
    }

}
