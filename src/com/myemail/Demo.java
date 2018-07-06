package com.myemail;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Demo {

    public static void main(String[] args) throws Exception{
        Properties props = new Properties();
        props.setProperty("mail.smtp.auth","true");//认证
        props.setProperty("mail.transport.protocol","smtp");//使用协议
        Session session = Session.getInstance(props);
        session.setDebug(true);
        Message msg = new MimeMessage(session);
        msg.setText("hello my first email!");
        msg.setFrom(new InternetAddress("itmonkey_test@sohu.com"));
        Transport transport = session.getTransport();
        transport.connect("smtp.sohu.com",25,"itmonkey_test","JZ19920610");
        transport.sendMessage(msg,new Address[]{new InternetAddress("itmonkey_test@sina.com")});
        transport.close();
    }
}
