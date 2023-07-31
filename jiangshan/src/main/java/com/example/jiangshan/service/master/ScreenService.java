package com.example.jiangshan.service.master;


import com.example.jiangshan.mapper.master.ScreenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class ScreenService {
    @Autowired
    private ScreenMapper screenMapper;
    @Autowired
    public static final String[] CONTEXT_TYPE_LIST = {"first", "second", "third", "fourth", "fifth", "sixth"};
    @Autowired
    public static final List<String> COLOR_LIST = Arrays.asList(
            "#0099CC", "#FFFFEE", "#AA66CC", "#50F350", "#99CC00", "#669900",
            "#FFBB33", "#FF8800", "#FF4444", "#CC0000", "#BF00FF", "#DA9669",
            "#E3CEF6", "#73c0de", "#fc8452", "#9a60b4", "#ea7ccc"
    );

    public HashMap<String, Object> screenContent(String contentType) throws Exception {
        if (!Arrays.asList(CONTEXT_TYPE_LIST).contains(contentType)) {
            throw new RuntimeException("Error contentType input! Please check what you entered!");
        }

        contentType = contentType + "_content";
        return screenMapper.selectScreenContent(contentType);
    }
/*
    public final static ArrayList<String> COLOR_LIST = new ArrayList<> (Arrays.asList("#0099CC","#FFFFEE","#AA66CC","#50F350","#99CC00","#669900","#FFBB33","#FF8800","#FF4444","#CC0000","#BF00FF","#DA9669","#E3CEF6","#73c0de","#fc8452","#9a60b4","#ea7ccc"));
    public HashMap screenContent(String contentType) throws Exception {
        if (!Arrays.asList(CONTEXT_TYPE_LIST).contains(contentType)) {
            throw new RuntimeException("Error contentType input! Please check what you entered!");
        }
            contentType = contentType + "_content";
            return screenMapper.selectScreenContent(contentType);

    }*/

    public List selectScreenCoordinate() {
        List<HashMap> screenCoordinate = screenMapper.selectScreenCoordinate();
       /*for(HashMap screenCoordinateItem : screenCoordinate){
           int index= LongToInteger(screenCoordinateItem.get("type"));
           screenCoordinateItem.put("color",COLOR_LIST.get(index));
       }*/
        return screenCoordinate;
    }
}
