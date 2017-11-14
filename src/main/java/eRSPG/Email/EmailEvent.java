package eRSPG.Email;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import eRSPG.model.form.BodyForm;
import eRSPG.model.form.DetailForm;

public class EmailEvent {

	
	
	public void sendEmail(DetailForm detailForm, BodyForm bodyForm, File file, String toUser) throws MessagingException {
		final String username = "erspgdonotreply@gmail.com";
		final String password = "msumlslqfyqdoekt";
		
		
	    Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
	  
		 
		
		 Session session = Session.getInstance(props,
		            new javax.mail.Authenticator() {
		                protected PasswordAuthentication getPasswordAuthentication() {
		                    return new PasswordAuthentication(username, password);
		                }
		            });

		    try {

		        Message message = new MimeMessage(session);
		        message.setFrom(new InternetAddress(username));
		        message.setRecipients(Message.RecipientType.TO,
		                InternetAddress.parse("nicholaslindquist@mail.weber.edu"));
		        message.setSubject("Message from eRSPG");
		        //message.setText("<li><ul>Test</ul></li>","utf-8", "html");
		        

		        MimeBodyPart messageBodyPart = new MimeBodyPart();

		        Multipart multipart = new MimeMultipart();

		        messageBodyPart = new MimeBodyPart();
		        String fileSource = file.getAbsolutePath();
		        String fileName = file.getName();
		        DataSource source = new FileDataSource(fileSource);
		        messageBodyPart.setDataHandler(new DataHandler(source));
		        messageBodyPart.setFileName(fileName);
		        //messageBodyPart.setContent("<html><li><ul>Test</ul></li></html>","text/html");
		        message.setText("<html><ul><li>Test</li></ul></html>");
		        multipart.addBodyPart(messageBodyPart);    
		        message.setContent(multipart);

		        System.out.println("Sending");

		        Transport.send(message);

		        System.out.println("Done");

		    } catch (MessagingException e) {
		        e.printStackTrace();
		    }
	}
	


}
