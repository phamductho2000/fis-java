package fis.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fis.training.config.MyConstants;

@Controller
public class SimpleEmailExampleController {

    @Autowired
    public JavaMailSender emailSender;

    @ResponseBody
    @RequestMapping(value = "/sendSimpleEmail", method = RequestMethod.GET)
    public String sendSimpleEmail() {

        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();
        
        message.setTo(MyConstants.FRIEND_EMAIL);
        message.setSubject("Test Simple Email");
        message.setText("Hello, Im testing Simple Email");

        // Send Message!
        emailSender.send(message);

        return "Email Sent!";
    }

}