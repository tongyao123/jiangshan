package com.example.jiangshan.service.master.screen;


import com.example.jiangshan.entity.AgricultureStatistics;
import com.example.jiangshan.mapper.master.AgricultureMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static com.example.jiangshan.function.NumericalConversion.LongToInteger;
@Transactional
@Service
public class AgricultureService implements AgricultureMapper {
    @Autowired
    private AgricultureMapper agricultureMapper;

    @Override
    public HashMap plantation(String town, String village) {
        return agricultureMapper.plantation(town, village);
    }
    @Override
    public HashMap farm(String town, String village) {
        return agricultureMapper.farm(town, village);
    }
    @Override
    public HashMap tea(String town, String village) {

        return agricultureMapper.tea(town, village);
    }

    public HashMap agricultureStatistics(String town, String village) throws Exception {

        HashMap agricultureStatistics = new HashMap();
        HashMap plantation = this.plantation(town, village);
        HashMap farm = this.farm(town, village);
        HashMap tea = this.tea(town, village);
        agricultureStatistics.put("plantationNumber",plantation.get("amount"));
        agricultureStatistics.put("plantationArea",plantation.get("area"));
        agricultureStatistics.put("plantationEmployeesNumber",plantation.get("worker_num"));
        agricultureStatistics.put("farmNumber",farm.get("amount"));
        agricultureStatistics.put("farmArea",farm.get("area"));
        agricultureStatistics.put("farmEmployeesNumber",farm.get("worker_num"));
        agricultureStatistics.put("teaNumber",tea.get("amount"));
        agricultureStatistics.put("teaArea",tea.get("area"));
        agricultureStatistics.put("teaEstimatedOutput",tea.get("yield"));
        return agricultureStatistics;


    }

    public List<HashMap> agricultureDetailList(@Param("town")String town, @Param("village") String village)  throws Exception {
        return agricultureMapper.agricultureDetailList(town,village);
    }


}
