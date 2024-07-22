package edu.wgu.d387_sample_code.rest;


import edu.wgu.d387_sample_code.D387SampleCodeApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MessageController {

    @GetMapping("/messages")
    public List<String> getMessages() {
        List<String> messages = Collections.synchronizedList(new LinkedList<>());

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                String message = D387SampleCodeApplication.getMessage("welcome_fr_CA.properties") + "-thread1";
                messages.add(message);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                String message = D387SampleCodeApplication.getMessage("welcome_en_US.properties") + "-thread2";
                messages.add(message);
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                String message = D387SampleCodeApplication.getMessage("welcome_fr_CA.properties") + "-thread3";
                messages.add(message);
            }
        });

        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                String message = D387SampleCodeApplication.getMessage("welcome_en_US.properties") + "-thread4";
                messages.add(message);
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return messages;
    }
}
