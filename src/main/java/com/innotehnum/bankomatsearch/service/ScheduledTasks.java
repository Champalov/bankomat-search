package com.innotehnum.bankomatsearch.service;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@AllArgsConstructor
public class ScheduledTasks {
    private final DataService dataService;

    @Scheduled(cron = "0 0 0 * * ?")
    public void scheduledUrlDataLoad() {
        dataService.loadToBase(XmlLoadService.XmlSourceType.URL);
    }

}
