package gmail.page;


import java.util.concurrent.TimeUnit;

import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.annotation.PageUrl;

import org.fluentlenium.core.domain.FluentWebElement;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.*;


@PageUrl("/mail/u/0/#inbox")
public class PageInbox extends GmailPage {
	@Page
	public PageSendEmail pageSend;

	@FindBy(xpath="//div[@role='navigation']//div[contains(@class,\"ain\")]//a[contains(.,\"Odebrane\")]")
	FluentWebElement inboxLink;

	public void isAt() {
		try {
			await().atMost(15, TimeUnit.SECONDS).until(inboxLink).present();
		} catch (TimeoutException e) {
			fail("Page Inbox didn't load.");
		}
		waitForPageLoad();
	}
}
