package gmail.page;

import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import gmail.data.User;
@PageUrl("/")
@FindBy(id = "identifierId")
public class PageLoginStep1 extends GmailPage {
	FluentWebElement identifierId;
	FluentWebElement identifierNext;
	
	public void sendLogin(User user)
	{
		identifierId.fill().with(user.getEmail());
		identifierNext.click();
	}
}
