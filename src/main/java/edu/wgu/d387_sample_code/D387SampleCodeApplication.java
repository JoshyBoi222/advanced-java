package edu.wgu.d387_sample_code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.Properties;

@SpringBootApplication
public class D387SampleCodeApplication {

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
    }

