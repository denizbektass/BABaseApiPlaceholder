package com.bilgeadam.BABaseApiPlaceholder.manager;

import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(url = "http://localhost:4041/api/v1/user",name = "base-user")
public interface IUserManager {

}
