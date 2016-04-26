package browser.pages.flight;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.EditField;
import com.hp.lft.sdk.web.EditFieldDescription;
import com.hp.lft.sdk.web.Image;
import com.hp.lft.sdk.web.ImageDescription;
import com.hp.lft.sdk.web.ListBox;
import com.hp.lft.sdk.web.ListBoxDescription;

import browser.pages.BrowserAbstractPage;

public class BookFlightPage extends BrowserAbstractPage {

	public BookFlightPage(Browser browser) {
		super(browser);
	}

	private String cardNumberInput = "input[name='creditnumber']";
	private String securePurchaseButton = "input[name='buyFlights']";

	public void typePassengerFirstName(String... passangerFirstName) throws GeneralLeanFtException {
		int i = 0;
		for (String name : passangerFirstName) {
			String u = Integer.toString(i);
			browser.describe(EditField.class,
					new EditFieldDescription.Builder().cssSelector("input[name='passFirst" + u + "']").build())
					.setValue(name);
			i++;
		}
	}

	public void typePassengerLastName(String... passangerLastName) throws GeneralLeanFtException {
		int i = 0;
		for (String name : passangerLastName) {
			String u = Integer.toString(i);
			browser.describe(EditField.class,
					new EditFieldDescription.Builder().cssSelector("input[name='passLast" + u + "']").build())
					.setValue(name);
			i++;
		}
	}

	public void selectPassengerMeal(String... passangerMeal) throws GeneralLeanFtException {
		int i = 0;
		for (String meal : passangerMeal) {
			String u = Integer.toString(i);
			browser.describe(ListBox.class,
					new ListBoxDescription.Builder().cssSelector("select[name='pass." + u + ".meal']").build())
					.select(meal);
			i++;
		}
	}

	public void typeCardNumber(String cardNumber) throws GeneralLeanFtException {
		browser.describe(EditField.class, new EditFieldDescription.Builder().cssSelector(cardNumberInput).build())
				.setValue(cardNumber);
	}

	public void clickSecurePurchase() throws GeneralLeanFtException {
		browser.describe(Image.class, new ImageDescription.Builder().cssSelector(securePurchaseButton).build()).click();
		browser.sync();
	}

}
