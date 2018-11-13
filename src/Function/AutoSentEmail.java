/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author Shado
 */
public class AutoSentEmail {
    
    public void sentEmail(String fromEmail, String password, String toEmail, String subject, String text) {
        // TODO
        // Change to configuration file      

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setReplyTo(InternetAddress.parse(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(text);

            Transport.send(message);
            System.out.println("Done!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
//    public static void main(String[] args) {
//        String fromEmail = "tripnetsp@gmail.com";
//        String password = "s25111211";
//        String toEmail = "suncho2511@gmail.com";
//        
//        new AutoSentEmail().sentEmail(fromEmail, password, toEmail, "Hello", new EmailContent().emailContent(null, fromEmail));
//    }
}
