package com.family.dubbo.sentinel.api;

import java.io.Serializable;

public class Sms implements Serializable {
    private String mobile;
    private String content;

    public Sms(String mobile,String content){
        this.content = content;
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
