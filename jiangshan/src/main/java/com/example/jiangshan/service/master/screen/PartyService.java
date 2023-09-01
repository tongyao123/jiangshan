package com.example.jiangshan.service.master.screen;

import com.example.jiangshan.mapper.master.PartyMapper;
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

    public Integer getPartyMembersNumber() {
        return partyMapper.getPartyMembersNumber();
    }

    public Integer getDevelopingPartyMembersNumber() {
        return partyMapper.getDevelopingPartyMembersNumber();
    }

    public Integer getTypeOfGloryNumber(String type) {
        return partyMapper.getTypeOfGloryNumber(type);
    }

    public List partyStatistics() {
        List PartyStatistics = new ArrayList();

        PartyStatistics.add(new HashMap<String, Object>() {{
            put("name", "党员总数");
            put("number", partyMapper.getPartyMembersNumber());
        }});
        PartyStatistics.add(new HashMap<String, Object>() {{
            put("name", "发展党员总数");
            put("number", partyMapper.getDevelopingPartyMembersNumber());
        }});
        PartyStatistics.add(new HashMap<String, Object>() {{
            put("name", "党员荣誉");
            put("number", partyMapper.getTypeOfGloryNumber("3"));
        }});
        PartyStatistics.add(new HashMap<String, Object>() {{
            put("name", "集体荣誉");
            put("number", partyMapper.getTypeOfGloryNumber("2"));
        }});
        return PartyStatistics;
    }

    public List partyCoordinate() {
        return partyMapper.partyCoordinate();
    }

    public  List  polictList(){

        return partyMapper.polictList();
    }

}
