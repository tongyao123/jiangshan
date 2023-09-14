package com.example.jiangshan.service.master.screen;

import com.example.jiangshan.mapper.master.AttractInvestmentMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

@Service
public class AttractInvestmentService implements AttractInvestmentMapper {
    private final AttractInvestmentMapper attractInvestmentMapper;

    public AttractInvestmentService(AttractInvestmentMapper attractInvestmentMapper) {
        this.attractInvestmentMapper = attractInvestmentMapper;
    }

    public List attractInvestmentStatistics(String typeInFuture,@Param("town")String town, @Param("village") String village) {
        return attractInvestmentMapper.attractInvestmentStatistics(typeInFuture,town,village);
    }

    public List attractInvestmentList(@Param("town")String town, @Param("village") String village) {
        return attractInvestmentMapper.attractInvestmentList(town,village);
    }

   //根据村镇获取
    public List attractInvestmentDetailList(@Param("town")String town, @Param("village") String village) {
        return attractInvestmentMapper.attractInvestmentDetailList(town,village);
    }

    //根据村获取对应的招商资产详情数据及地图坐标点位，尽量停止使用
    public List villageAttractInvestmentCoordinate(String village) {
        return attractInvestmentMapper.villageAttractInvestmentCoordinate(village);
    }

    // 获取招商资产中的村庄列表
    public List villageList() {
        return attractInvestmentMapper.villageList();
    }

    // 查看招商资产的统计数据
    public HashMap<String,Object>  attractInvestmentStatistics(@Param("town")String town, @Param("village") String village) {
        HashMap<String,Object>  AttractInvestment = new HashMap<>();
        AttractInvestment.put("planProject", this.attractInvestmentStatistics("1",town,village));
        AttractInvestment.put("completedProject", this.attractInvestmentStatistics("3",town,village));
        AttractInvestment.put("ongoingProject", this.attractInvestmentStatistics("2",town,village));
        AttractInvestment.put("AttractInvestmentList", this.attractInvestmentList(town,village));
        return AttractInvestment;
    }

}
