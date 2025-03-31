package com.example.jiangshan.service.supply;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.jaxrs.FastJsonAutoDiscoverable;
import com.example.jiangshan.mapper.supply.FarmMapper;
import com.example.jiangshan.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional
@Service
public class FarmService implements FarmMapper {
    private static final List<String> COLOR_LIST = Arrays.asList(
            "#FFFFEE", "#0099CC", "#AA66CC", "#50F350", "#99CC00", "#669900", "#FFBB33", "#FF8800", "#FF4444", "#CC0000", "#BF00FF", "#DA9669", "#E3CEF6"
    );
    @Autowired
    private FarmMapper FarmMapper;

    @Override
    public List<HashMap> selectFarmBasisList(String town, String village) {

//        List<HashMap> FarmList = FarmMapper.selectFarmBasisList(town, village);

        return FarmMapper.selectFarmBasisList(town, village);
    }

    @Override
    public List<String> selectFarmPicture(String farm_code) {
        return FarmMapper.selectFarmPicture(farm_code);
    }

    @Override
    public List<List> selectFarmCoordinate(String code, String partition_code) {
        return FarmMapper.selectFarmCoordinate(code, partition_code);
    }

    @Override
    public HashMap selectFarmStatistics(String farm_type, String town, String village) {
        return FarmMapper.selectFarmStatistics(farm_type, town, village);

    }

    public List<HashMap> selectFarmList(String town, String village) {
        List<HashMap> FarmList = this.selectFarmBasisList(town, village);
        //int colorIndex = 0;
        for (int colorIndex = 0; colorIndex < FarmList.size(); colorIndex++) {
            HashMap features = FarmList.get(colorIndex);
            features.put("color", COLOR_LIST.get(colorIndex % 13));//框线颜色
            features.put("pesticideDosag", "12.6kg");//农药用量
            features.put("fertilizerConsumption", "586.6kg");//化肥用量
            features.put("organicFertilizerConsumption", "396.4kg");//有机肥用量
            features.put("agriculturalInspectionReport", "合格");//农检报告
//            features.put("agriculturalInspectionReportPics",selectFarmPicture(features.get("farm_id").toString()));
            ArrayList picList = new ArrayList<>();
            picList.addAll(Arrays.asList(features.get("shop_head")));
            picList.addAll(selectFarmPicture(features.get("farm_id").toString()));
            features.put("agriculturalInspectionReportPics", picList);
            String partitionCode = features.get("partitionCode") + "";
            List list = selectFarmCoordinate(features.get("id").toString(), partitionCode);
            String result = (String) features.get("garden_range");
            String pointsCode = result.substring(result.indexOf("\"points\"") + 9, result.indexOf("}"));
            pointsCode = pointsCode.replace("\"", "");
//            Map<String, Object> resultMap  = JSONObject.parseObject(result);
//            String pointsCode =resultMap.get("drawingData").toString();
//            JSONObject  points = JSONObject.parseObject(pointsCode);
            features.put("result", list);
            features.put("list", pointsCode);
        }
        return FarmList;
    }


//    for(index=0;index<8;index++) {
//        List<HashMap<String, Object>> longitudeLatitudeData =#
//        db.selectMapList("select cast(longitude as DECIMAL(20,15)) as lng,cast(latitude as DECIMAL(20,15)) as lat from longitude_latitude_data where code='" + features.get(index).get("id") + "' and partition_code=" + features.get(index).get("partitionCode") + " and type='01' order by index_");
//        if (longitudeLatitudeData.size() > 0) {
//            ArrayList dot = new ArrayList([longitudeLatitudeData.get(0).get("lng"), longitudeLatitudeData.
//            get(0).get("lat")]);
//            features.get(index).put("dot", dot);//经纬度
//            features.get(index).put("list", longitudeLatitudeData);//区域经纬度数据
//        } else {
//            String coordinateData = features.get(index).get('latitude');
//            ArrayList dot = new ArrayList([#util.substrBefore(coordinateData, ','),#
//            util.substrAfterLast(coordinateData, ',')]);
//            features.get(index).put("dot", dot);//经纬度
//            HashMap coordinateMap = new HashMap();
//            coordinateMap.put("lng",#util.substrBefore(coordinateData, ','));
//            coordinateMap.put("lat",#util.substrAfterLast(coordinateData, ','));
//            ArrayList coordinateList = new ArrayList();
//            coordinateList.add(coordinateMap);
//            features.get(index).put("list", coordinateList);
//        }
//        //农检报告图
//        ArrayList agriculturalInspectionReportPics = new ArrayList();
//        //agriculturalInspectionReportPics=#db.selectList("select DISTINCT pp.produce_inspection_report from base_farm f left join base_produce p on f.farmer=p.produce_creator left join base_parameter_produce pp on p.produce_id=pp.produce_id where f.farm_code='"+features.get(index).get('id')+"' and NOT ISNULL(pp.produce_inspection_report)");
//        agriculturalInspectionReportPics =#
//        db.selectList("select  pp.picture_content from base_farm f left join base_picture pp on f.farmer=pp.create_user  where pp.all_type='95' and f.farm_code='" + features.get(index).get('id') + "' and NOT ISNULL(pp.picture_content)");
//        int colorIndex = index % 13;
//        features.get(index).put("color", COLOR_LIST.get(colorIndex));//框线颜色
//        features.get(index).put("pesticideDosag", "12.6kg");//农药用量
//        features.get(index).put("fertilizerConsumption", "586.6kg");//化肥用量
//        features.get(index).put("organicFertilizerConsumption", "396.4kg");//有机肥用量
//        features.get(index).put("agriculturalInspectionReport", "合格");//农检报告
//        features.get(index).put("agriculturalInspectionReportPics", (agriculturalInspectionReportPics.isEmpty()) ? "" : agriculturalInspectionReportPics);//农检报告图
//
//    }
//
//    var supplyList=#db.selectMapList("select supply_name,supply_api_type,supply_id as id,supply_people,supply_main,supply_estate,supply_tom,supply_address,concat(supply_longitude,',',supply_latitude) as latitude,supply_video as supplyVideo  from base_supply");
//
//    for(var supplyIndex = 0;supplyIndex<supplyList.size();supplyIndex++){
//        var longitudeLatitudeData=#db.selectMapList("select cast(longitude as DECIMAL(20,15)) as lng,cast(latitude as DECIMAL(20,15)) as lat from longitude_latitude_data where code='"+supplyList.get(supplyIndex).get('id').toString()+"'  and type='02' order by index_");
//        if(longitudeLatitudeData.size()>0){
//            var dot=new ArrayList([longitudeLatitudeData.get(0).get("lng"),longitudeLatitudeData.get(0).get("lat")]);
//            supplyList.get(supplyIndex).put("dot",dot);//经纬度
//            supplyList.get(supplyIndex).put("list",longitudeLatitudeData);//区域经纬度数据
//        }else{
//            var coordinateData=supplyList.get(supplyIndex).get('latitude');
//            var dot=new ArrayList([#util.substrBefore(coordinateData,','),#util.substrAfterLast(coordinateData,',')]);
//            supplyList.get(supplyIndex).put("dot",dot);//经纬度
//            var coordinateMap= new HashMap();
//            coordinateMap.put("lng",#util.substrBefore(coordinateData,','));
//            coordinateMap.put("lat",#util.substrAfterLast(coordinateData,','));
//            var coordinateList=new ArrayList();
//            coordinateList.add(coordinateMap);
//        }
//        var colorIndex=supplyIndex%13;
//        supplyList.get(supplyIndex).put("color",$COLOR_LIST.get(colorIndex));//框线颜色
//        if(supplyList.get(supplyIndex).get('supply_api_type')=='02'){
//            supplyList.get(supplyIndex).put("supplyIcon","$708/FAME_DATA_PATH/FAME_DATA_PRIVATE/坐标 A.png");//icon图标
//        }else if(supplyList.get(supplyIndex).get('supply_api_type')=='03'){
//            supplyList.get(supplyIndex).put("supplyIcon","$708/FAME_DATA_PATH/FAME_DATA_PRIVATE/坐标 B.png");//icon图标
//        }else{
//            supplyList.get(supplyIndex).put("supplyIcon","$708/FAME_DATA_PATH/FAME_DATA_PRIVATE/坐标.png");//icon图标
//        }
//        if(isEmpty(supplyList.get(supplyIndex).get('supplyVideo'))){
//            supplyList.get(supplyIndex).put("supplyVideo","https://oos-cn.ctyunapi.cn/supply-video/%E9%BE%99%E5%B2%A9%E5%86%9C%E7%89%B9%E4%BA%A7%E5%93%81%E6%AD%A3%E7%89%87_1.mp4");//介绍视频
//        }
//        //supplyList.get(supplyIndex).put("supplyVideo","http://27.151.6.66:7999/apps/supply/shouye.mp4");//介绍视频
//    }
//
//    var centerData=#db.selectOne("select cast(longitude as DECIMAL(20,15)) as lng,cast(latitude as DECIMAL(20,15)) as lat from longitude_latitude_data where code='A051' and partition_code=1 and type='01' order by index_");
////code='A069'  江山中心定位
////code='A051'  新罗中心定位
//    $center=new ArrayList();
////return centerData[0];
//$center.addAll([centerData[0],centerData[1]]);
//    $mapMap=features;
//    $supplyMap=supplyList;
}
