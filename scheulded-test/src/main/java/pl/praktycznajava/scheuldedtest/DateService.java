package pl.praktycznajava.scheuldedtest;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DateService {

    @Scheduled(fixedDelayString = "${fixedDelay.in.milliseconds}")
    public void printDate() {
        System.out.println("Today is: " + LocalDate.now());
    }

    public long getDelay() {
        return 12312;
    }
}


