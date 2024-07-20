package edu.wgu.d387_sample_code;

import edu.wgu.d387_sample_code.service.MessageService;
import edu.wgu.d387_sample_code.service.MessageThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.context.ApplicationContext;

import java.io.InputStream;
import java.util.Properties;
import java.util.Locale;

@SpringBootApplication
public class D387SampleCodeApplication {

    @Autowired
    private TaskExecutor taskExecutor;

    @Autowired
    private MessageService messageService;

    public static void main(String[] args) {
        SpringApplication.run(D387SampleCodeApplication.class, args);
    }

    public void startThreads(ApplicationContext applicationContext) {
        Locale[] locales = {Locale.ENGLISH, Locale.FRENCH};
        for (int i = 0; i < 5; i++) {
            for (Locale locale : locales) {
                taskExecutor.execute(new MessageThread(messageService, locale, i));
            }
        }
    }

}
