package com.example.jiangshan.open.util;

import java.net.URI;

import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author xuweidong
 * @date 2019/11/11 15:21
 */
public class HttpHelper {
    /**
     * 生成参数encodeUri后的URI，只编码=和&符号
     * @param uri
     * @param param
     * @return
     */
    public static URI buildURI(String uri,boolean needEncode,String... param){
        int paramIndex = uri.indexOf('?');
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(uri.substring(0,paramIndex));
        if(paramIndex >0){
            String paramStr=uri.substring(paramIndex+1);
            String[] split = paramStr.split("&");
            for(int i=0;i<split.length;i++){
                uriComponentsBuilder.queryParam(split[i].split("=")[0],param[i]);
            }
        }
        return uriComponentsBuilder.build(!needEncode).toUri();
    }

    /**
     * 生成参数encodeUri后的URI，只编码=和&符号
     * @param uri
     * @param param
     * @return
     */
    public static String buildURIStr(String uri,boolean needEncode,String... param){
        return buildURI(uri,needEncode,param).toString();
    }


}
