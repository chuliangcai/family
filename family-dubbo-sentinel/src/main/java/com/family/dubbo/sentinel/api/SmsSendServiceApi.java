package com.family.dubbo.sentinel.api;

import java.util.List;

public interface SmsSendServiceApi {
    void send(List<Sms> smsList);
}
