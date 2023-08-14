package com.example.jiangshan.service.master.screen;

import com.example.jiangshan.entity.CulturalTourismStatistics;
import com.example.jiangshan.mapper.master.CulturalTourismMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public class CulturalTourismService {
    @Autowired
    private CulturalTourismMapper culturalTourismMapper;

    public Integer getCulturalTourismCount(String productType) {
        return culturalTourismMapper.CulturalTourismCount(productType);
    }

    public  List<HashMap> getTurnoverList(){
        return culturalTourismMapper.getTurnoverList();

    }

    public CulturalTourismStatistics culturalTourismStatistics(){
        CulturalTourismStatistics culturalTourismStatistics = new CulturalTourismStatistics();
        culturalTourismStatistics.setAttractionsNumber(this.getCulturalTourismCount("9"));
        culturalTourismStatistics.setHomestayNumber(this.getCulturalTourismCount("6"));
        culturalTourismStatistics.setRestaurantNumber(this.getCulturalTourismCount("7"));
        culturalTourismStatistics.setTurnoverList(this.getTurnoverList());
        return culturalTourismStatistics;
    }
    public List<HashMap> culturalDetailList(){
        return culturalTourismMapper.culturalDetailList();
    }

    public List<HashMap> tourismDetailList(){
        return culturalTourismMapper.tourismDetailList();
    }

}
