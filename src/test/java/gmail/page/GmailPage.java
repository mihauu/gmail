package gmail.page;


import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

public class GmailPage extends FluentPage {
	@FindBy(xpath = "//span[contains(@class,'v1')][contains(text(),'Ładuję...')]")
	FluentWebElement loading;

	protected void waitForPageLoad() {
		await().until(loading).not().displayed();
	}
}
