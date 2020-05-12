package it.xpug.birthday_greetings;

import java.io.*;
import java.text.ParseException;

import javax.mail.*;
import javax.mail.internet.*;

public class Main {

	public static void main(String[] args) throws AddressException, IOException, ParseException, MessagingException {
		IMessageService messageService=new SmtpMailService("localhost",25);
		BirthdayService service = new BirthdayService(messageService);
		service.sendGreetings("employee_data.txt", new XDate());
	}

}
