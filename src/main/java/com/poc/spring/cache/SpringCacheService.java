package com.poc.spring.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SpringCacheService {

    @Cacheable("names")
    public String fetchName() {
        log.info(">>>>>>>>>>> In Service");
        return "Some Name";
    }
}
