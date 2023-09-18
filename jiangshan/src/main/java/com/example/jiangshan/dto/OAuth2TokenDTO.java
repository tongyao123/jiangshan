package com.example.jiangshan.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class OAuth2TokenDTO {
    @ApiModelProperty(value = "访问token", required = true, example = "301bc8ca-7ec2-47c8-a481-b327bf87f9a0")
    private String access_token;
    @ApiModelProperty(value = "token类型", required = true, example = "固定值bearer")
    private String token_type;
    @ApiModelProperty(value = "刷新token", required = true, example = "66f2f9d9-3ee7-42b1-88f3-371ee1ff69ab")
    private String refresh_token;
    @ApiModelProperty(value = "token作用范围", required = true, example = "固定值app")
    private String scope;
    @ApiModelProperty(value = "还剩多久过期（秒）", required = true, example = "12345")
    private int expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    @Override
    public String toString() {
        return "OAuth2TokenDTO [access_token=" + access_token + ", token_type=" + token_type + ", refresh_token=" + refresh_token + ", scope=" + scope
                + ", expires_in=" + expires_in + "]";
    }
}
