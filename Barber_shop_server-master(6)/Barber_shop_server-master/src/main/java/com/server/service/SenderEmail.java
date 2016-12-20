package com.server.service;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SenderEmail {

    public static final String EMAIL_FROM = "underground.barbershop.mgn@gmail.com";
    public static final String PASS_FROM = "barberMGNshop574682";

    public static void send(String recipientEmail, String message,String title) throws MessagingException {
        //Get the session object
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(EMAIL_FROM,PASS_FROM);
                    }
                });

        //Compose the message
        try {
            MimeMessage mes = new MimeMessage(session);
            mes.setFrom(new InternetAddress(EMAIL_FROM));
            mes.addRecipient(Message.RecipientType.TO,new InternetAddress(recipientEmail));
            mes.setSubject(title);
            mes.setText(message);

            //send the message
            Transport.send(mes);

            System.out.println("message sent successfully...");

        } catch (MessagingException e) {e.printStackTrace();}
    }
}
