package com.family.dubbo.sentinel.provider;

import java.util.List;
import java.util.Random;

import org.apache.dubbo.config.annotation.DubboService;

import com.family.dubbo.sentinel.api.Sms;
import com.family.dubbo.sentinel.api.SmsSendServiceApi;

@DubboService
public class SmsSendServiceApiImpl implements SmsSendServiceApi {

    @Override
    public void send(List<Sms> smsList) {
        int m = new Random().nextInt(20);
        try {
            System.out.println(200+m);
            Thread.sleep(200+m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("send sms size:" + smsList.size());
    }
}
