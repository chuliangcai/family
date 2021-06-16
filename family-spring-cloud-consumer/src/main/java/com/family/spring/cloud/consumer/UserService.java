package com.family.spring.cloud.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("service-provider")
public interface UserService {

    @GetMapping("/api/user/hi")
    String hi();
}
