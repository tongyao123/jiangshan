package com.example.jiangshan.service.master;


import com.example.jiangshan.entity.AgricultureStatistics;
import com.example.jiangshan.mapper.master.AgricultureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.example.jiangshan.function.NumericalConversion.LongToInteger;

@Service
public class AgricultureService {
    @Autowired
    private AgricultureMapper agricultureMapper;

    /*public List<Integer> plantation = agricultureStatisticsMapper.plantation();

    public List<Integer> farm = agricultureStatisticsMapper.farm();

    public  List<Integer> tea = agricultureStatisticsMapper.tea();*/

    public List<HashMap> plantation() {
        return agricultureMapper.plantation();
    }

    public List<HashMap> farm() {
        return agricultureMapper.farm();
    }

    public List<HashMap> tea() {
        return agricultureMapper.tea();
    }

    public AgricultureStatistics agricultureStatistics() throws Exception {

        AgricultureStatistics agricultureStatistics=new AgricultureStatistics();
        /*List<HashMap> agricultureStatistics = new ArrayList<>();

        agricultureStatistics.add( new HashMap<String, String>() {{
            put("code", "plantationNumber");
            put("name", "种植场数量");
            put("number", LongToInteger(agricultureMapper.plantation().get(0).get("amount")).toString());
        }});
        agricultureStatistics.add(new HashMap<String, String>() {{
            put("code", "plantationArea");
            put("name", "种植场面积");
            put("number", LongToInteger(agricultureMapper.plantation().get(0).get("area")).toString());
        }});agricultureStatistics.add(new HashMap<String, String>() {{
            put("code", "plantationEmployeesNumber");
            put("name", "种植场员工数量");
            put("number", LongToInteger(agricultureMapper.plantation().get(0).get("worker_num")).toString());
        }});

        agricultureStatistics.add(new HashMap<String, String>() {{
            put("code", "farmNumber");
            put("name", "养殖场数量");
            put("number", LongToInteger(agricultureMapper.farm().get(0).get("amount")).toString());
        }});agricultureStatistics.add(new HashMap<String, String>() {{
            put("code", "farmArea");
            put("name", "养殖场面积");
            put("number", LongToInteger(agricultureMapper.farm().get(0).get("area")).toString());
        }});agricultureStatistics.add(new HashMap<String, String>() {{
            put("code", "farmEmployeesNumber");
            put("name", "养殖场员工数量");
            put("number", LongToInteger(agricultureMapper.farm().get(0).get("worker_num")).toString());
        }});

        agricultureStatistics.add(new HashMap<String, String>() {{
            put("code", "teaNumber");
            put("name", "茶基地数量");
            put("number", LongToInteger(agricultureMapper.tea().get(0).get("amount")).toString());
        }});agricultureStatistics.add(new HashMap<String, String>() {{
            put("code", "teaArea");
            put("name", "茶基地面积");
            put("number", LongToInteger(agricultureMapper.tea().get(0).get("area")).toString());
        }});agricultureStatistics.add(new HashMap<String, String>() {{
            put("code", "teaEstimatedOutput");
            put("name", "茶基地预计产量");
            put("number", LongToInteger(agricultureMapper.tea().get(0).get("yield")).toString());
        }});

*/
        agricultureStatistics.setPlantationNumber(LongToInteger(this.plantation().get(0).get("amount")));
        agricultureStatistics.setPlantationArea(LongToInteger(this.plantation().get(0).get("area")));
        agricultureStatistics.setPlantationEmployeesNumber(LongToInteger(this.plantation().get(0).get("worker_num")));
        agricultureStatistics.setFarmNumber(LongToInteger(this.farm().get(0).get("amount")));
        agricultureStatistics.setFarmArea(LongToInteger(this.farm().get(0).get("area")));
        agricultureStatistics.setFarmEmployeesNumber(LongToInteger(this.farm().get(0).get("worker_num")));
        agricultureStatistics.setTeaNumber(LongToInteger(this.tea().get(0).get("amount")));
        agricultureStatistics.setTeaArea(LongToInteger(this.tea().get(0).get("area")));
        agricultureStatistics.setTeaEstimatedOutput(LongToInteger(this.tea().get(0).get("yield")));
        return agricultureStatistics;


    }

    public List<HashMap> agricultureDetailList() {
        return agricultureMapper.agricultureDetailList();
    }


}
