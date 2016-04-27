package browser.pages.flight;

import java.util.List;

import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.EditField;
import com.hp.lft.sdk.web.EditFieldDescription;
import com.hp.lft.sdk.web.Image;
import com.hp.lft.sdk.web.ImageDescription;
import com.hp.lft.sdk.web.ListBox;
import com.hp.lft.sdk.web.ListBoxDescription;

import browser.pages.BrowserAbstractPage;
import tools.models.flight.CustomerModel;

public class BookFlightPage extends BrowserAbstractPage {

	public BookFlightPage(Browser browser) {
		super(browser);
	}

	private String cardNumberInput = "input[name='creditnumber']";
	private String securePurchaseButton = "input[name='buyFlights']";

	public void fillCustomerList(List<CustomerModel> customerList) throws GeneralLeanFtException {
		int uCount = 0;
		for (CustomerModel customerModel : customerList) {
			typePassengerFirstName(customerModel.getFirstName(), String.valueOf(uCount));
			typePassengerLastName(customerModel.getLastName(), String.valueOf(uCount));
			selectPassengerMeal(customerModel.getMeal(), String.valueOf(uCount));
			uCount++;
		}
	}

	public void typePassengerFirstName(String passangerFirstName, String uCount) throws GeneralLeanFtException {
		browser.describe(EditField.class,
				new EditFieldDescription.Builder().cssSelector("input[name='passFirst" + uCount + "']").build())
				.setValue(passangerFirstName);
	}

	public void typePassengerLastName(String passangerLastName, String uCount) throws GeneralLeanFtException {
		browser.describe(EditField.class,
				new EditFieldDescription.Builder().cssSelector("input[name='passLast" + uCount + "']").build())
				.setValue(passangerLastName);
	}

	public void selectPassengerMeal(String passangerMeal, String uCount) throws GeneralLeanFtException {
		browser.describe(ListBox.class,
				new ListBoxDescription.Builder().cssSelector("select[name='pass." + uCount + ".meal']").build())
				.select(passangerMeal);
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
