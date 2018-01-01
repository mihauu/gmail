package gmail.page;


import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import gmail.data.User;


public class PageLoginStep2 extends GmailPage {
	@FindBy(name = "password")
	FluentWebElement password;
	FluentWebElement passwordNext;
	FluentWebElement profileIdentifier;

	public void isAt() {
		await().until(password).displayed();
	}

	public void sendPassword(User user) {
		password.fill().with(user.getPassword());
		passwordNext.click();
	}

	public String getEmail() {
		return profileIdentifier.text();
	}
}
