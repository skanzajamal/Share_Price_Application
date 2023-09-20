package com.config;

import com.service.SharePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class Scheduler {

    @Autowired
    SharePriceService sharePriceService;

    @PostConstruct
    public void onStartup() throws IOException {
        sharePriceService.getList();
    }

    @Scheduled(fixedRate = 900000)
    public void onSchedule() throws IOException {
        sharePriceService.getList();
    }

} //ENDCLASS
