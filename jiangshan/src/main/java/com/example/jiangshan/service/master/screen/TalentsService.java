package com.example.jiangshan.service.master.screen;

import com.example.jiangshan.mapper.master.TalentsMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/**
* @Date: 2023-09-07
* @Author: Xiao Lee
* @Param:
* @Return:
* @Description: TalentsService.java
*/
@Service
public class TalentsService {
    private final TalentsMapper talentsMapper;

    public TalentsService(TalentsMapper talentsMapper) {
        this.talentsMapper = talentsMapper;
    }

    public Integer getTalentsStatistics(@Param("town") String town,@Param("village") String village) {
        return talentsMapper.getTalentsStatistics(town, village);
    }

    public Integer getEmploymentTalentsStatistics(@Param("town") String town,@Param("village") String village) {
        return talentsMapper.getEmploymentTalentsStatistics(town, village);
    }

    public List<HashMap> getTalentsEducationStatistics(@Param("town") String town,@Param("village") String village) {
        return talentsMapper.getTalentsEducationStatistics(town, village);
    }

    public HashMap talentsStatistics(@Param("town") String town,@Param("village") String village){
        HashMap TalentsStatistics = new HashMap<>();
        TalentsStatistics.put("talentsStatistics", Arrays.asList(new HashMap<String, Object>() {{
                                                                     put("name", "总人才数");
                                                                     put("number", talentsMapper.getTalentsStatistics(town, village));
                                                                 }},
                new HashMap<String, Object>() {{
                    put("name", "总就业数");
                    put("number", talentsMapper.getEmploymentTalentsStatistics(town, village));
                }}));
        TalentsStatistics.put("talentsEducationStatistics", talentsMapper.getTalentsEducationStatistics(town, village));
        return TalentsStatistics;
    }
    public  List talentsCoordinate(@Param("town") String town,@Param("village") String village){
        return talentsMapper.talentsCoordinate(town, village);
    }

    public  List talentPolicyList(@Param("town") String town){
        return talentsMapper.talentPolicyList(town);
    }
}
