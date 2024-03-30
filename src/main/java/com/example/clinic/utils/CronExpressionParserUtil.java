package com.example.clinic.utils;



import lombok.experimental.UtilityClass;
import org.springframework.scheduling.support.CronExpression;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@UtilityClass
public class CronExpressionParserUtil {


    //TODO should be discussed
    private static LocalDateTime END_TIME = LocalDateTime.now().plusYears(100);


    public static List<LocalDateTime> getLocalDateTimesFromCronBetween(LocalDateTime startTime, LocalDateTime endTime, String cronExpression) {

        List<LocalDateTime> times = new ArrayList<>();
        CronExpression expression = CronExpression.parse(cronExpression);
        LocalDateTime from = startTime;

        while (from.isBefore(getEndTime(endTime))) {

            LocalDateTime nextExecution = expression.next(from);
            from = nextExecution;
            times.add(nextExecution);
        }
        return times;
    }


    private static LocalDateTime getEndTime(LocalDateTime time) {
        return time != null ? time : END_TIME;
    }


}
