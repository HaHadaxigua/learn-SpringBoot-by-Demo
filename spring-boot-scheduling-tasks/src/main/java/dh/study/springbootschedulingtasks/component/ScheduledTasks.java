package dh.study.springbootschedulingtasks.component;


import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {
    public static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    public static final SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)    // 从开始调用计算时间
    public void reportCurrentTime() {
        log.info("This time is now{}", dataFormat.format(new Date()));
    }
}
