package com.example.jiangshan.controller;

import com.example.jiangshan.entity.CulturalTourismStatistics;
import com.example.jiangshan.service.master.screen.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@Scope()
@RequestMapping("/screenMessage")
@CrossOrigin
public class ScreenMessageController {

    private final AgricultureService agricultureService;
    private final CulturalTourismService culturalTourismService;
    private final AttractInvestmentService attractInvestmentService;
    private final PartyService partyService;
    private final TalentsService talentsService;
    private final PlanningProductService planningProductService;
    private final ScreenService screenService;

    public ScreenMessageController(AgricultureService agricultureService, CulturalTourismService culturalTourismService, AttractInvestmentService attractInvestmentService, PartyService partyService, TalentsService talentsService, PlanningProductService planningProductService, ScreenService screenService) {
        this.agricultureService = agricultureService;
        this.culturalTourismService = culturalTourismService;
        this.attractInvestmentService = attractInvestmentService;
        this.partyService = partyService;
        this.talentsService = talentsService;
        this.planningProductService = planningProductService;
        this.screenService = screenService;
    }

    @ResponseBody
    @RequestMapping(value = "/getAgricultureStatistics")
    public HashMap getAgricultureStatistics(@RequestParam(required=false,value="town") String town, @RequestParam(required=false,value="village") String village){
        return agricultureService.agricultureStatistics(town, village);
    }

    @ResponseBody
    @RequestMapping(value = "/getCulturalTourismStatistics")
    public CulturalTourismStatistics getCulturalTourismStatistics(@RequestParam(required=false,value="town") String town, @RequestParam(required=false,value="village") String village){
        return culturalTourismService.culturalTourismStatistics(town, village);
    }

    @ResponseBody
    @RequestMapping(value = "/getAttractInvestmentStatistics")
    public HashMap getAttractInvestmentStatistics(@RequestParam(required=false,value="town") String town, @RequestParam(required=false,value="village") String village) {
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
    public HashMap getPlanningProductStatistics(@RequestParam(required = false,value = "town") String town, @RequestParam(required = false,value ="village") String village) {
        return planningProductService.planningProductStatistics(town, village);
    }

    @ResponseBody
    @RequestMapping(value = "/getAgricultureCoordinate")
    public List getAgricultureDetailList(@RequestParam(required = false,value = "town") String town, @RequestParam(required = false,value ="village") String village) throws Exception {
        System.out.println("begin--------------------------------------------------------------");
        System.out.println(town+"---------------------------------"+village);
        System.out.println("end----------------------------------------------------------------");
        return agricultureService.agricultureDetailList(town, village);
    }

    @ResponseBody
    @RequestMapping(value = "/getCulturalCoordinate")
    public List getCulturalDetailList(@RequestParam(required=false,value="town") String town, @RequestParam(required=false,value="village") String village) {
        return culturalTourismService.culturalDetailList(town, village);
    }

    @ResponseBody
    @RequestMapping(value = "/getTourismCoordinate")
    public List getTourismDetailList(@RequestParam(required=false,value="town") String town, @RequestParam(required=false,value="village") String village) {
        return culturalTourismService.tourismDetailList(town, village);
    }

    @ResponseBody
    @RequestMapping(value = "/getAttractInvestmentCoordinate")
    public List getAttractInvestmentCoordinate(@RequestParam(required=false,value="town") String town, @RequestParam(required=false,value="village") String village) {
        return attractInvestmentService.attractInvestmentDetailList(town, village);
    }

    @ResponseBody
    @RequestMapping(value = "/getVillageAttractInvestmentCoordinate")
    public List getAttractInvestmentCoordinate(@RequestBody Map village){
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


