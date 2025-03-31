//package com.example.jiangshan.function;
//
//import com.alibaba.fastjson.JSONObject;
//
//import java.util.HashMap;
//import java.util.Iterator;
//
//public class JsonToHashMap {
//    //2.将json字符串转换成HashMap<String,String>
//    public static HashMap<String, String> JsonToHashMap(String JsonStrin){
//        HashMap<String, String> data = new HashMap<String, String>();
//        try{
//            // 将json字符串转换成jsonObject
//            JSONObject jsonObject = JSONObject.fromObject(JsonStrin);
//            @SuppressWarnings("rawtypes")
//            Iterator it = jsonObject.keys();
//            // 遍历jsonObject数据，添加到Map对象
//            while (it.hasNext())
//            {
//                String key = String.valueOf(it.next()).toString();
//                String value = (String) jsonObject.get(key).toString();
//                data.put(key, value);
//            }
//        }catch (Exception e) {
//            e.printStackTrace();
//            //JOptionPane.showMessageDialog(null,"ERROR:["+e+"]");
//        }
//        System.out.println(data);
//        return data;
//    }
//
//}
