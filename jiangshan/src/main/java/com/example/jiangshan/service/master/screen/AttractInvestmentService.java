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

    public List selectAttractInvestmentStatistics(String typeInFuture,@Param("town")String town, @Param("village") String village) {
        return attractInvestmentMapper.selectAttractInvestmentStatistics(typeInFuture,town,village);
    }

    public List selectAttractInvestmentList(@Param("town")String town, @Param("village") String village) {
        return attractInvestmentMapper.selectAttractInvestmentList(town,village);
    }

   //根据村镇获取
    public List selectAttractInvestmentDetailList(@Param("town")String town, @Param("village") String village) {
        return attractInvestmentMapper.selectAttractInvestmentDetailList(town,village);
    }

    //根据村获取对应的招商资产详情数据及地图坐标点位，尽量停止使用
    public List villageAttractInvestmentCoordinate(String village) {
        return attractInvestmentMapper.villageAttractInvestmentCoordinate(village);
    }

    // 获取招商资产中的村庄列表
    public List selectVillageList() {
        return attractInvestmentMapper.selectVillageList();
    }

    // 查看招商资产的统计数据
    public HashMap<String,Object>  attractInvestmentStatistics(@Param("town")String town, @Param("village") String village) {
        HashMap<String,Object>  AttractInvestment = new HashMap<>();
        AttractInvestment.put("planProject", this.selectAttractInvestmentStatistics("1",town,village));
        AttractInvestment.put("completedProject", this.selectAttractInvestmentStatistics("3",town,village));
        AttractInvestment.put("ongoingProject", this.selectAttractInvestmentStatistics("2",town,village));
        AttractInvestment.put("AttractInvestmentList", this.selectAttractInvestmentList(town,village));
        return AttractInvestment;
    }

}
