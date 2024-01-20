package com.demo.msw.Config;

import com.demo.msw.Service.WebSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Scheduler {

    @Autowired
    WebSiteService webSiteService;


    @Scheduled(cron = "0 0/1 * * * ?")
    public void scheduleTask()
    {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
//
//        String strDate = dateFormat.format(new Date());
//
//        System.out.println( "Cron job Scheduler: Job running at - " + strDate);
//        webSiteService.CheckWebSiteStatus();
    }
}
