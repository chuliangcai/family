package com.family.dubbo.provider;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;

import com.family.dubbo.api.UserDto;
import com.family.dubbo.api.UserServiceApi;
import com.google.common.collect.Lists;

@DubboService
public class UserServiceApiImpl implements UserServiceApi {

    @Override
    public List<UserDto> findTop20User() {
        return Lists.newArrayList(new UserDto(), new UserDto());
    }
}
