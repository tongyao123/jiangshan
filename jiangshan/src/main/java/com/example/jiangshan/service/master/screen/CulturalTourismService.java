package com.example.jiangshan.service.master.screen;

import com.example.jiangshan.entity.CulturalTourismStatistics;
import com.example.jiangshan.mapper.master.CulturalTourismMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public class CulturalTourismService {
    private final CulturalTourismMapper culturalTourismMapper;

    public CulturalTourismService(CulturalTourismMapper culturalTourismMapper) {
        this.culturalTourismMapper = culturalTourismMapper;
    }

    public Integer getCulturalTourismCount(String productType,@Param("town")String town, @Param("village") String village) {
        return culturalTourismMapper.CulturalTourismCount(productType,town,village);
    }

    public  List<HashMap> getTurnoverList(@Param("town")String town, @Param("village") String village){
        return culturalTourismMapper.getTurnoverList(town,village);

    }

    public CulturalTourismStatistics culturalTourismStatistics(@Param("town")String town, @Param("village") String village){
        CulturalTourismStatistics culturalTourismStatistics = new CulturalTourismStatistics();
        culturalTourismStatistics.setAttractionsNumber(this.getCulturalTourismCount("9",town,village));
        culturalTourismStatistics.setHomestayNumber(this.getCulturalTourismCount("6",town,village));
        culturalTourismStatistics.setRestaurantNumber(this.getCulturalTourismCount("7",town,village));
        culturalTourismStatistics.setTurnoverList(this.getTurnoverList(town,village));
        return culturalTourismStatistics;
    }
    public List<HashMap> culturalDetailList(@Param("town")String town, @Param("village") String village){
        return culturalTourismMapper.culturalDetailList(town,village);
    }

    public List<HashMap> tourismDetailList(@Param("town")String town, @Param("village") String village){
        return culturalTourismMapper.tourismDetailList(town,village);
    }

}
