package com.example.jiangshan.service.master.screen;

import com.example.jiangshan.mapper.master.PartyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class PartyService {
    private final PartyMapper partyMapper;

    public PartyService(PartyMapper partyMapper) {
        this.partyMapper = partyMapper;
    }

    public Integer getPartyMembersNumber(@Param("town") String town, @Param("village") String village) {
        return partyMapper.getPartyMembersNumber(town, village);
    }

    public Integer getDevelopingPartyMembersNumber(@Param("town") String town,@Param("village") String village) {
        return partyMapper.getDevelopingPartyMembersNumber(town, village);
    }

    public Integer getTypeOfGloryNumber(String type,@Param("town") String town,@Param("village") String village) {
        return partyMapper.getTypeOfGloryNumber(type,town,village);
    }

    public List partyStatistics(@Param("town") String town,@Param("village") String village) {
        List PartyStatistics = new ArrayList();

        PartyStatistics.add(new HashMap<String, Object>() {{
            put("name", "党员总数");
            put("number", partyMapper.getPartyMembersNumber(town, village));
        }});
        PartyStatistics.add(new HashMap<String, Object>() {{
            put("name", "发展党员总数");
            put("number", partyMapper.getDevelopingPartyMembersNumber(town, village));
        }});
        PartyStatistics.add(new HashMap<String, Object>() {{
            put("name", "党员荣誉");
            put("number", partyMapper.getTypeOfGloryNumber("3",town,village));
        }});
        PartyStatistics.add(new HashMap<String, Object>() {{
            put("name", "集体荣誉");
            put("number", partyMapper.getTypeOfGloryNumber("2",town,village));
        }});
        return PartyStatistics;
    }

    public List partyCoordinate(@Param("town") String town, @Param("village") String village) {
        return partyMapper.partyCoordinate(town, village);
    }

    public  List  polictList(@Param("town") String town){

        return partyMapper.polictList(town);
    }

}
