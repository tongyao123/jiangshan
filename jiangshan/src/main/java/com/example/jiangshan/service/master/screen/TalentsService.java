package com.example.jiangshan.service.master.screen;

import com.example.jiangshan.mapper.master.TalentsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class TalentsService {
    private final TalentsMapper talentsMapper;

    public TalentsService(TalentsMapper talentsMapper) {
        this.talentsMapper = talentsMapper;
    }

    public Integer getTalentsStatistics() {
        return talentsMapper.getTalentsStatistics();
    }

    public Integer getEmploymentTalentsStatistics() {
        return talentsMapper.getEmploymentTalentsStatistics();
    }

    public List<HashMap> getTalentsEducationStatistics() {
        return talentsMapper.getTalentsEducationStatistics();
    }

    public HashMap talentsStatistics(){
        HashMap TalentsStatistics = new HashMap<>();
        /*TalentsStatistics.put("talentsStatistics", Arrays.asList(new HashMap<String, Object>() {{
                                                                     put("name", "总人才数");
                                                                     put("number", talentsStatisticsMapper.getTalentsStatistics().get(0).get("总人才数"));
                                                                 }},
                new HashMap<String, Object>() {{
                    put("name", "总就业数");
                    put("number", talentsStatisticsMapper.getTalentsStatistics().get(0).get("总就业数"));
                }}));*/
        TalentsStatistics.put("talentsStatistics", Arrays.asList(new HashMap<String, Object>() {{
                                                                     put("name", "总人才数");
                                                                     put("number", talentsMapper.getTalentsStatistics());
                                                                 }},
                new HashMap<String, Object>() {{
                    put("name", "总就业数");
                    put("number", talentsMapper.getEmploymentTalentsStatistics());
                }}));
        TalentsStatistics.put("talentsEducationStatistics", talentsMapper.getTalentsEducationStatistics());
        return TalentsStatistics;
    }
    public  List talentsCoordinate(){
        return talentsMapper.talentsCoordinate();
    }

    public  List talentPolicyList(){
        return talentsMapper.talentPolicyList();
    }
}
