package com.example.jiangshan.controller;

import com.example.jiangshan.entity.AgricultureStatistics;
import com.example.jiangshan.entity.CulturalTourismStatistics;
import com.example.jiangshan.service.master.screen.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@Scope()
@RequestMapping("/screenMessage")
@CrossOrigin
public class ScreenMessageController {

    @Autowired
    private AgricultureService agricultureService;
    @Autowired
    private CulturalTourismService culturalTourismService;
    @Autowired
    private AttractInvestmentService attractInvestmentService;
    @Autowired
    private PartyService partyService;
    @Autowired
    private TalentsService talentsService;
    @Autowired
    private PlanningProductService planningProductService;

    @Autowired
    private ScreenService screenService;

    @ResponseBody
    @RequestMapping(value = "/getAgricultureStatistics")
    public HashMap getAgricultureStatistics(@PathVariable @RequestParam("town") String town, @PathVariable @RequestParam("village") String village) throws Exception {
        return agricultureService.agricultureStatistics(town, village);
    }

    @ResponseBody
    @RequestMapping(value = "/getCulturalTourismStatistics")
    public CulturalTourismStatistics getCulturalTourismStatistics(@Param("town") String town, @Param("village") String village) throws Exception {
        return culturalTourismService.culturalTourismStatistics(town, village);
    }

    @ResponseBody
    @RequestMapping(value = "/getAttractInvestmentStatistics")
    public HashMap getAttractInvestmentStatistics(@Param("town") String town, @Param("village") String village) throws Exception {
        return attractInvestmentService.attractInvestmentStatistics(town, village);
    }

    @ResponseBody
    @RequestMapping(value = "/getPartyStatistics")
    public List getPartyStatistics() {
        return partyService.partyStatistics();
    }

    @ResponseBody
    @RequestMapping(value = "/getTalentsStatistics")
    public HashMap getTalentsStatistics() {
        return talentsService.talentsStatistics();
    }

    @ResponseBody
    @RequestMapping(value = "/getPlanningProductStatistics")
    public HashMap getPlanningProductStatistics(@RequestParam("town") String town, @RequestParam("village") String village) {
        return planningProductService.planningProductStatistics(town, village);
    }

    @ResponseBody
    @RequestMapping(value = "/getAgricultureCoordinate")
    public List getAgricultureDetailList(@RequestParam("town") String town, @RequestParam("village") String village) throws Exception {
        return agricultureService.agricultureDetailList(town, village);
    }

    @ResponseBody
    @RequestMapping(value = "/getCulturalCoordinate")
    public List getCulturalDetailList(@Param("town") String town, @Param("village") String village) {
        return culturalTourismService.culturalDetailList(town, village);
    }

    @ResponseBody
    @RequestMapping(value = "/getTourismCoordinate")
    public List getTourismDetailList(@Param("town") String town, @Param("village") String village) {
        return culturalTourismService.tourismDetailList(town, village);
    }

    @ResponseBody
    @RequestMapping(value = "/getAttractInvestmentCoordinate")
    public List getAttractInvestmentCoordinate(@Param("town") String town, @Param("village") String village) {
        return attractInvestmentService.attractInvestmentDetailList(town, village);
    }

    @ResponseBody
    @RequestMapping(value = "/getVillageAttractInvestmentCoordinate")
    public List getAttractInvestmentCoordinate(@RequestBody Map village) throws Exception {
        String villageCode = village.get("village").toString();
        return attractInvestmentService.villageAttractInvestmentCoordinate(villageCode);
    }

    @ResponseBody
    @RequestMapping(value = "/getVillageStatistics")
    public List getVillageList() {
        return attractInvestmentService.villageList();
    }


    @ResponseBody
    @RequestMapping(value = "/getPartyCoordinate")
    public List getPartyCoordinate() {
        return partyService.partyCoordinate();
    }

    @ResponseBody
    @RequestMapping(value = "/getPolict")
    public List getPolict() {
        return partyService.polictList();
    }

    @ResponseBody
    @RequestMapping(value = "/getTalentsCoordinate")
    public List getTalentsCoordinate() {
        return talentsService.talentsCoordinate();
    }

    @ResponseBody
    @RequestMapping(value = "/getTalentPolicyList")
    public List getTalentPolicyList() {
        return talentsService.talentPolicyList();
    }

    @ResponseBody
    @PostMapping(value = "/getScreenContent")
    public HashMap getScreenContent(@RequestBody Map contentType) throws Exception {
        String type = contentType.get("contentType").toString();
        return screenService.screenContent(type);
    }

    @ResponseBody
    @RequestMapping(value = "/getScreenCoordinate")
    public List getScreenCoordinate() throws Exception {
        return screenService.selectScreenCoordinate();
    }


    @ResponseBody
    @RequestMapping("/struggle")
    public String doIt() {
        return "I will try !";
    }


}


