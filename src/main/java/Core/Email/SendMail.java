package Core.Email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import static Core.readDocs.ReadXMLFile.readXML;
import static Core.utils.Constants.*;


public class SendMail {


    public void sendMail(String Body) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        System.out.println(EMAIL_SENDER+"  "+PASS_EMAIL);
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(EMAIL_SENDER, PASS_EMAIL);
                    }
                });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAIL_SENDER));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(readXML("notification","emailList")));
            message.setSubject("TEST RESULT ");
            message.setText(Body,"UTF-8","html");
            SimpleDateFormat format = new SimpleDateFormat("HH");
            Calendar cal = Calendar.getInstance();
            Date dateTime = cal.getTime();
            format.format(dateTime);
            Date date = new Date();
            //System.out.println(date);
            Transport.send(message);

            //System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}