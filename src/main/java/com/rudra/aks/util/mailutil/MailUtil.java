package com.rudra.aks.util.mailutil;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.rudra.aks.util.bo.AttachedMail;
import com.rudra.aks.util.bo.SimpleMail;

public class MailUtil {

	
	public void sendMail(SimpleMail	  simpleMail) {
		
		Session session = getMaiSession();
		try {
		  Message msg = new MimeMessage(session);
		  msg.setFrom(new InternetAddress(simpleMail.getFrom(), simpleMail.getFromName()));
		  msg.addRecipient(Message.RecipientType.TO, new InternetAddress(simpleMail.getTo()));
		  msg.setSubject(simpleMail.getSubject());
		 
		  msg.setText(simpleMail.getContent());
		  
		  Transport.send(msg);
		} catch (AddressException e) {
			System.err.println("Address Exception: " + e);
		} catch (MessagingException e) {
			System.err.println("Message Exception : " + e);
		} catch (UnsupportedEncodingException e) {
			System.err.println("Exception : " + e);

		}
	}
	
	
	public void sendMailWithAttachement(AttachedMail mailBO) {
		
		Session session = getMaiSession();

		
		
		String htmlBody = "";          // ...
		//byte[] attachmentData = null;  // ...
		Multipart mp = new MimeMultipart();

		try {
			MimeBodyPart htmlPart = new MimeBodyPart();
			htmlPart.setContent(htmlBody, "text/html");
			mp.addBodyPart(htmlPart);

			MimeBodyPart attachment = new MimeBodyPart();
			attachment.attachFile(new File(mailBO.getFileName()));
			
			/*InputStream attachmentDataStream = new ByteArrayInputStream(attachmentData);
			attachment.setFileName("testmail.pdf");
			attachment.setContent(attachmentDataStream, "application/pdf");*/
			mp.addBodyPart(attachment);

			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(mailBO.getFrom(), mailBO.getFromName()));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(mailBO.getTo()));
			msg.setSubject(mailBO.getSubject());
			msg.setContent(mp);
			
			Transport.send(msg);
		} catch (UnsupportedEncodingException | MessagingException e) {
			System.err.println("Exception : " + e);
		} catch (IOException e) {
			System.err.println("File Exception : " + e);
		}
		
		
	}
	
	private Session    getMaiSession() {
		
		Properties properties = new Properties();
	    properties.put("mail.smtp.host", "smtp.gmail.com");
	    properties.put("mail.smtp.port", "587");
	    properties.put("mail.smtp.auth", "true");
	    properties.put("mail.smtp.starttls.enable", "true");
	    //properties.put("mail.smtp.ssl.trust","mail.man.com");		
	    
	    Authenticator passAuth = new Authenticator(){
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("ankushjavatech", "IMprince@46");
			}
	    };
	    Session session = Session.getInstance(properties, passAuth);
	    return session;
	}
	
	
	
}
