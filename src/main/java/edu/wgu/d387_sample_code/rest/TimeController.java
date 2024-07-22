package edu.wgu.d387_sample_code.rest;


import edu.wgu.d387_sample_code.D387SampleCodeApplication;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;


@RestController
@CrossOrigin("http://localhost:4200")
public class TimeController {

    @GetMapping("timeZones")
    public Map<String, String> getTimeInTimeZones() {
        LocalDateTime currentTime = LocalDateTime.now();
        ZoneId easternZone = ZoneId.of("America/New_York");
        ZoneId mountainZone = ZoneId.of("America/Denver");
        ZoneId utcZone = ZoneId.of("UTC");

        String easternTime = D387SampleCodeApplication.convertTimeZones(currentTime, ZoneId.systemDefault(), easternZone) + " Eastern Time";
        String mountainTime = D387SampleCodeApplication.convertTimeZones(currentTime, ZoneId.systemDefault(), mountainZone) + " Mountain Time";
        String utcTime = D387SampleCodeApplication.convertTimeZones(currentTime, ZoneId.systemDefault(), utcZone) + " UTC";


        Map<String, String> timeMap = new HashMap<>();
        timeMap.put("easternTime", easternTime);
        timeMap.put("mountainTime", mountainTime);
        timeMap.put("utcTime", utcTime);

        return timeMap;
    }

}
