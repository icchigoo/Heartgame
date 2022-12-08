package service;

import model.ModelMessage;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ServiceMail {

    // this is the package i used for sending code to gmail 
    // its very useful and easy to use

    public ModelMessage sendMain(String toEmail, String code) {
        ModelMessage ms = new ModelMessage(false, "");
        String from = "******@gmail.com";
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        // here i am using college id to sedn code to other user
        String username = "ajaya.chhetri@patancollege.edu.np";
        String password = "Muzan@01";    //  Your email password here
        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject("Verify Code");
            message.setText(code);
            Transport.send(message);
            ms.setSuccess(true);

            // if the user id is invalid or wrong then i will get the error message in my gmail
        } catch (MessagingException e) {
            if (e.getMessage().equals("Invalid Addresses")) {
                ms.setMessage("Invalid email");
            } else {
                ms.setMessage("Error");
            }
        }
        return ms;
    }
}
