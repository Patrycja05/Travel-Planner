package com.project.travelplanner.scheduler;

import com.project.travelplanner.config.AdminConfig;
import com.project.travelplanner.domain.Mail;
import com.project.travelplanner.repository.OrderRepository;
import com.project.travelplanner.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {

    private static final String SUBJECT = "Number of orders per day.";
    private static final String MESSAGE = "Currently in database you got: ";

    @Autowired
    private EmailService emailService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AdminConfig adminConfig;

    @Scheduled(cron = "0 0 23 * * *")
    public void sendInformationEmail(){
        long size = orderRepository.count();
        emailService.send(new Mail(adminConfig.getAdminMail(), SUBJECT, MESSAGE + size + ((size != 1) ? " orders" : " order")));
    }
}
