package com.Email;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailServer
{
	public  boolean sendEmail(String receiver,String subject,String message_body)  
	{
		try
		{
			final String sender="anbarasancse2019@mvit.edu.in";
			FileInputStream fis=new FileInputStream("src/main/java/com/Email/config.properties");
			Properties prop=new Properties();
			prop.load(fis);
			final String password=prop.getProperty("PASSWORD");
			Properties props=new Properties();

		    props.put("mail.smtp.host","smtp.gmail.com");
	        props.put("mail.smtp.port", "465");
	        props.put("mail.smtp.ssl.enable", "true");
	        props.put("mail.smtp.auth", "true");
			
			Session session = Session.getDefaultInstance(props,  
					new javax.mail.Authenticator() { 
				protected PasswordAuthentication getPasswordAuthentication() {  
					return new PasswordAuthentication(sender,password);  
				}  
			});  
			
			
			System.out.println("Message sending...");  
			MimeMessage message = new MimeMessage(session);  
			message.setFrom(new InternetAddress(sender));  
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(receiver));  
			message.setSubject(subject);
			message.setText(message_body);
			Transport.send(message);  
			System.out.println("Message sent successfully..."); 
			return true;
		}
		catch(Exception ex)
		{
			System.out.println("Exception in sendemail "+ex);
			return false;
		}
			
		}
}