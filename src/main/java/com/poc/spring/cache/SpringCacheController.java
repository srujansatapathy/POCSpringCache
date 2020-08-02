package com.poc.spring.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SpringCacheController {

    @Autowired
    private SpringCacheService springCacheService;

    @GetMapping("/api/cache/name")
    public String fetchName() {
        log.info(">>>>>>>>>>> In Controller");
        return springCacheService.fetchName();
    }
}
