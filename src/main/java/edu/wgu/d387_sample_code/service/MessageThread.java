package edu.wgu.d387_sample_code.service;

import java.util.Locale;

public class MessageThread extends Thread {
    private final MessageService messageService;
    private final Locale locale;
    private final int threadNumber;

    public MessageThread(MessageService messageService, Locale locale, int threadNumber) {
        this.messageService = messageService;
        this.locale = locale;
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        String message = messageService.getMessage(locale);
        System.out.println(message + " from thread " + threadNumber + " ");
    }
}
