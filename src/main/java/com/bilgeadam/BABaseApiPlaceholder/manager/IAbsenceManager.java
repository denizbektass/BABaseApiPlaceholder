package com.bilgeadam.BABaseApiPlaceholder.manager;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(url = "http://localhost:4042/api/v1/card/absence",name = "base-absence")
public interface IAbsenceManager {

}
