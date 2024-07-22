package edu.wgu.d387_sample_code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.ZonedDateTime;
import java.util.Properties;

@SpringBootApplication
public class D387SampleCodeApplication {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");

    public static void main(String[] args) {
        SpringApplication.run(D387SampleCodeApplication.class, args);
    }

        public static String getMessage(String propertiesFileName) {
            try {
                InputStream stream = new ClassPathResource(propertiesFileName).getInputStream();
                Properties properties = new Properties();
                properties.load(stream);
                return properties.getProperty("message");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public static String convertTimeZones(LocalDateTime localDateTime, ZoneId currentZone, ZoneId targetZone) {
        ZonedDateTime zonedDateTime = localDateTime.atZone(currentZone).withZoneSameInstant(targetZone);
        return dateTimeFormatter.format(zonedDateTime);
        }

    }

