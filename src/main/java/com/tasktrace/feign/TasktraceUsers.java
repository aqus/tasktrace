package com.tasktrace.feign;

import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("tasktrace-users")
public interface TasktraceUsers {

    @GetMapping("api/v1/users/{username}")
    List<UserRepresentation> searchByUsername(@PathVariable("username") String username);
}
