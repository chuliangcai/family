package com.family.dubbo.api;

import java.util.List;

public interface UserServiceApi {

    List<UserDto> findTop20User();
}
