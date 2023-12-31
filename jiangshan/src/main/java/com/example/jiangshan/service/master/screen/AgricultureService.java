package com.example.jiangshan.service.master.screen;


import com.example.jiangshan.mapper.master.AgricultureMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Transactional
@Service
public class AgricultureService implements AgricultureMapper {
    private final AgricultureMapper agricultureMapper;

    public AgricultureService(AgricultureMapper agricultureMapper) {
        this.agricultureMapper = agricultureMapper;
    }

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

    public HashMap<String,Object>  agricultureStatistics(String town, String village) {

        HashMap<String,Object> agricultureStatistics = new HashMap();
        HashMap<String,Object>  plantation = this.plantation(town, village);
        HashMap<String,Object>  farm = this.farm(town, village);
        HashMap<String,Object>  tea = this.tea(town, village);
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

    public List<HashMap> selectAgricultureDetailList(@Param("town")String town, @Param("village") String village)  throws Exception {
        return agricultureMapper.selectAgricultureDetailList(town,village);
    }


}
