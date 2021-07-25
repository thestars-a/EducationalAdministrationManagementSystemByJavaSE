package Util;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.MessagingException;
import java.security.GeneralSecurityException;
import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendMail {
    private String sendMailID;
    public SendMail(String mailID){
        this.sendMailID = mailID;
    }
    public void send(String stringBuilder) throws MessagingException, GeneralSecurityException {
        Properties properties = new Properties();
        properties.setProperty("mail.host", "smtp.qq.com");
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.auth", "true");
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("2579623115@qq.com", "lbpmtzgbetuhechc");
            }
        });
        //session.setDebug(true);
        Transport transport = session.getTransport();
        transport.connect("smtp.qq.com", "2579623115@qq.com", "lbpmtzgbetuhechc");
        MimeMessage mimeMessage = new MimeMessage(session);
        mimeMessage.setFrom(new InternetAddress("2579623115@qq.com"));
        mimeMessage.setRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress(sendMailID)});
        mimeMessage.setSubject("豪公子学生管理系统账号注册");
        mimeMessage.setContent("<h1>欢迎您注册豪公子学生管理系统,账号注册验证码为:"
                + stringBuilder + "(三分钟有效),请勿回复此邮箱<h1>", "text/html;charset=UTF-8");
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        transport.close();
    }
}
