package com.example.jiangshan.service.master.screen;


import com.example.jiangshan.mapper.master.AgricultureMapper;
import com.example.jiangshan.service.supply.FarmService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

import static com.example.jiangshan.config.BaseConfig.baseTown;
import static com.example.jiangshan.constant.MathUtils.getBigDecimal;

@Transactional
@Service
public class AgricultureService implements AgricultureMapper {
    private final AgricultureMapper agricultureMapper;
    private final ScreenService screenService;
    private final FarmService farmService;

    public AgricultureService(AgricultureMapper agricultureMapper, ScreenService screenService, FarmService farmService) {
        this.agricultureMapper = agricultureMapper;
        this.screenService = screenService;
        this.farmService = farmService;
    }

    @Override
    public HashMap<String,Object> plantation(String town, String village) {
        return agricultureMapper.plantation(town, village);
    }
    @Override
    public HashMap<String,Object> farm(String town, String village) {
        return agricultureMapper.farm(town, village);
    }
    @Override
    public HashMap<String,Object> tea(String town, String village) {
        return agricultureMapper.tea(town, village);
    }

    @Override
    public HashMap<String, Object> factory(String town, String village) {
        return agricultureMapper.factory(town, village);
    }

    public HashMap<String,Object>  agricultureStatistics(String town, String village) {
        if (town == null || town.length() == 0) {
            town=baseTown;
        }
        HashMap<String,Object> agricultureStatistics = new HashMap<>();
        HashMap<String,Object> plantation = this.plantation(town, village);
        HashMap<String,Object> farm = this.farm(town, village);
        HashMap<String,Object> tea = this.tea(town, village);
        HashMap<String,Object> factory = this.factory(town, village);

        HashMap farmPlantation=farmService.selectFarmStatistics("00",town, village);
        HashMap farmFarm=farmService.selectFarmStatistics("01",town, village);
        HashMap farmUnknown=farmService.selectFarmStatistics("",town, village);

        Long  plantationNumber =(Long)farmPlantation.get("quantity")+(Long)farmUnknown.get("quantity")+(Long)plantation.get("amount");
        Double  plantationArea =  getBigDecimal(farmPlantation.get("area")).doubleValue()+getBigDecimal(farmUnknown.get("area")).doubleValue()+getBigDecimal(plantation.get("area")).doubleValue();
        Long  plantationEmployeesNumber =(Long)farmPlantation.get("farm_scale")+(Long)farmUnknown.get("farm_scale")+(Long)plantation.get("worker_num");

        Long  farmNumber=(Long)farmFarm.get("quantity")+(Long)farm.get("amount");
        Double  farmArea= getBigDecimal(farmFarm.get("area")).doubleValue()+getBigDecimal(farm.get("area")).doubleValue();
        Long  farmEmployeesNumber=(Long)farmFarm.get("farm_scale")+(Long)farm.get("worker_num");

        agricultureStatistics.put("plantationNumber",plantationNumber);
        agricultureStatistics.put("plantationArea",plantationArea);
        agricultureStatistics.put("plantationEmployeesNumber",plantationEmployeesNumber);
        agricultureStatistics.put("farmNumber",farmNumber);
        agricultureStatistics.put("farmArea",farmArea);
        agricultureStatistics.put("farmEmployeesNumber",farmEmployeesNumber);
        agricultureStatistics.put("factoryNumber",factory.get("amount"));
        agricultureStatistics.put("factoryArea",factory.get("area"));
        agricultureStatistics.put("factoryEmployeesNumber",factory.get("worker_num"));
        agricultureStatistics.put("teaNumber",tea.get("amount"));
        agricultureStatistics.put("teaArea",tea.get("area"));
        agricultureStatistics.put("teaEstimatedOutput",tea.get("yield"));
        agricultureStatistics.put("teaName",screenService.selectTownProduct(town));
        return agricultureStatistics;


    }

    public List<HashMap> selectAgricultureDetailList(@Param("town")String town, @Param("village") String village)  throws Exception {
        return agricultureMapper.selectAgricultureDetailList(town,village);
    }


}
