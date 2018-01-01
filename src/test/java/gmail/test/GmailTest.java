package gmail.test;

import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.configuration.ConfigurationProperties;
import org.fluentlenium.configuration.FluentConfiguration;
import org.fluentlenium.core.annotation.Page;

import gmail.data.Email;
import gmail.data.User;
import gmail.page.PageInbox;
import gmail.page.PageLoginStep1;
import gmail.page.PageLoginStep2;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@FluentConfiguration(webDriver = "chrome", baseUrl = "https://gmail.com", driverLifecycle = ConfigurationProperties.DriverLifecycle.THREAD)
public class GmailTest extends FluentTest {
	
	@Page
	protected PageLoginStep1 pageLoginStep1;
	@Page
	protected PageLoginStep2 pageLoginStep2;
	@Page
	protected PageInbox pageInbox;

	public GmailTest() {
		if (System.getProperty("os.name").equals("Linux"))
			System.setProperty("webdriver.chrome.driver", "drivers/chrome/linux/chromedriver");
		else if(System.getProperty("os.name").equals("Win"))
			System.setProperty("webdriver.chrome.driver", "drivers/chrome/win/chromedriver.exe");
		else if(System.getProperty("os.name").equals("iOS"))
			System.setProperty("webdriver.chrome.driver", "drivers/chrome/mac/chromedriver");
		
	}

	protected void login(User user) {
		
		goTo(pageLoginStep1);
		pageLoginStep1.sendLogin(user);
		pageLoginStep2.isAt();
		assertThat(pageLoginStep2.getEmail()).as("There isn't email user on step 2.").isEqualTo(user.getEmail());
		pageLoginStep2.sendPassword(user);
		//TODO other scenarios (captcha, login from other place, different device, different browser)
		pageInbox.isAt();
	}

	protected void sendEmail(Email email) {
		pageInbox.pageSend.clickCreate();
		pageInbox.pageSend.sendEmail(email);
	}

}
