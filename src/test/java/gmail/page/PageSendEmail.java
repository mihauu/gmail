package gmail.page;


import java.util.concurrent.TimeUnit;

import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;

import gmail.data.Email;

public class PageSendEmail extends GmailPage {

	@FindBy(xpath = "//div[contains(text(),\"UTWÓRZ\")][contains(@role,\"button\")]")
	private FluentWebElement create;

	private FluentWebElement to;
	private FluentWebElement subjectbox;

	private String sendButtonXpath = "//div[contains(@role,'button')][text()='Wyślij']";

	@FindBy(xpath = "//div[contains(@role,'button')][text()='Wyślij'][last()]")
	private FluentWebElement sendButton;

	@FindBy(css = "[role=\"textbox\"]")
	private FluentWebElement message;

	@FindBy(xpath = "//div[contains(.,'Wiadomość została wysłana.')]")
	private FluentWebElement messageSended;

	public void clickCreate() {
		int numberWindow = getCounterCreateWindow();
		create.click();
		// hack
		await().atMost(15, TimeUnit.SECONDS).untilPredicate((fl) -> $(By.xpath(sendButtonXpath)).size() == numberWindow+1);

	}

	private int getCounterCreateWindow() {
		return $(By.xpath(sendButtonXpath)).size();
	}

	public void sendEmail(Email email) {
		to.fill().withText(email.getRecipient());
		subjectbox.fill().withText(email.getSubject());
		message.fill().withText(email.getMessage());
		sendButton.click();
	}

	public boolean isEmailSended() {
		try {
			await().until(messageSended).displayed();
		} catch (TimeoutException e) {
			return false;
		}
		return true;
	}
}
