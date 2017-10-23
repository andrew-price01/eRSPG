package eRSPG.Email;

import java.io.File;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import eRSPG.model.form.BodyForm;
import eRSPG.model.form.DetailForm;

public class EmailEvent {
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
	
	
	public void sendEmail(DetailForm detailForm, BodyForm bodyForm, File file) throws MessagingException {
		final String username = "erspgdonotreply@gmail.com";
		final String password = "msumlslqfyqdoekt";

		
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		 
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("nicholaslindquist@mail.weber.edu"));
		generateMailMessage.setSubject("A proposal has been submitted through eRSPG");
		
		String emailBody = "<b>Proposal Details</b>:\n"
				+ "<li>\n"
				+ "<ul>Project Director: " + detailForm.getProjectDirector() + "</ul>\n"
				+ "<ul>Email: " + detailForm.getProposalEmail() + "</ul>\n"
				+ "<ul>Proposal Title: " + detailForm.getProposalTitle() + "</ul>\n"
				+ "<ul>Summary: " + bodyForm.getSummary() + "</ul>\n"
				+ "</li>";
		
		generateMailMessage.setContent(emailBody, "text/html");

		Transport transport = getMailSession.getTransport("smtp");
		 
		// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
		transport.connect("smtp.gmail.com", username, password);
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}

}
