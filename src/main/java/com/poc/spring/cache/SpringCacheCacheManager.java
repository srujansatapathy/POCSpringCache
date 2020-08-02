package com.poc.spring.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cache.CacheManager;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
@Slf4j
public class SpringCacheCacheManager {

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private SpringCacheService springCacheService;

    @Scheduled(cron = "${cache.refresh.interval}")
    public void refreshCache() {
        log.info("\n");
        log.info(">>>>>>>>>>> ReLoading Cache START @ " + ZonedDateTime.now() + " .........");
        cacheManager.getCache("names").clear();
        springCacheService.fetchName();
        log.info(">>>>>>>>>>> ReLoading Cache END @ " + ZonedDateTime.now() + " .........");
        log.info("\n");
    }


    @EventListener(ApplicationReadyEvent.class)
    public void loadCacheWhileStartUp() {
        log.info("\n");
        log.info(">>>>>>>>>>> Loading Cache during start up START @ " + ZonedDateTime.now() + " .........");
        springCacheService.fetchName();
        log.info(">>>>>>>>>>> Loading Cache during start up END @ " + ZonedDateTime.now() + " .........");
        log.info("\n");
    }
}
