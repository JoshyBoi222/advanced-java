package edu.wgu.d387_sample_code.service;

import org.springframework.stereotype.Service;
import java.util.Locale;
import java.util.ResourceBundle;

@Service
public class MessageServiceImpl implements MessageService {

    @Override
    public String getMessage(Locale locale) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("welcome", locale);
        return resourceBundle.getString("message");
    }

}
