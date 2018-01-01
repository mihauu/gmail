package gmail.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import gmail.data.Email;
import gmail.data.User;

public class SendEmail extends GmailTest {
	@Before
	public void prepare() {
		window().maximize();
	}

	@Test
	public void sendEmailTest() {
		login(generateUser());
		Email email = generateEmail();
		sendEmail(email);
		assertThat(pageInbox.pageSend.isEmailSended()).as("Email didn't send.").isTrue();
	}

	private Email generateEmail() {
		Email email = new Email();
		email.setRecipient("michal@lkh.pl");
		email.setSubject("test email");
		email.setMessage("Hello world!");
		return email;
	}

	private User generateUser() {
		User user = new User();
		user.setEmail("andrzejniewiadomski336@gmail.com");
		user.setPassword("9WLqmCpA");
		return user;
	}
}
