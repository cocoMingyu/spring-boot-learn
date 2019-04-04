package com.kn.springbootlearn.service.impl;

import com.kn.springbootlearn.service.ScheduleService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/3/29 10:25
 * @ Modified By:
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {
    /**
     * second,min,hour,day,month,day of week
     * [0 0/5 1,2,3 * * ?]
     */
    @Override
    @Scheduled(cron = "30 * * * * ?")
    public void scheduler(){
        System.out.println("scheduler ...");
    }
}
