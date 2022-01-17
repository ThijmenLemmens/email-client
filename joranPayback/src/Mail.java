import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mail {

    private String messageUser;
    private String title;

    public void sendMessage(String recepient) {
        System.out.println("preparing to send!");
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "outlook.office365.com");
        properties.put("mail.smtp.port", "587");

        String username = ""; // hier je outlook email
        String password = ""; // wacht woord

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Message message = prepareMessage(session, username, recepient);

        try {
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        System.out.println("message send!");
    }

    private Message prepareMessage(Session session, String username, String recepient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject(title);
            message.setText(messageUser);
            return message;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setMessage(String message) {
        this.messageUser = message;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
