package it.xpug.birthday_greetings;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SmtpMailService implements IMessageService {
	java.util.Properties props = new java.util.Properties();

	public SmtpMailService(String smtpHost, int smtpPort) {
		this.props.put("mail.smtp.host", smtpHost);
		this.props.put("mail.smtp.port", "" + smtpPort);
	}
	
		@Override
		public void sendMessage(String sender, String subject, String body, String recipient) throws AddressException, MessagingException {
		// Create a mail session
				
		Session session = Session.getInstance(props, null);

		// Construct the message
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(sender));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
		msg.setSubject(subject);
		msg.setText(body);

		// Send the message
		Transport.send(msg);
	}
}
