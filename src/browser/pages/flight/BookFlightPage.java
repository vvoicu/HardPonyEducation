package browser.pages.flight;

import com.hp.lft.sdk.web.Browser;

import browser.pages.BrowserAbstractPage;

public class BookFlightPage extends BrowserAbstractPage {

	public BookFlightPage(Browser browser) {
		super(browser);
	}

	private String inputPassagerFirstName = "input[name='passFirst0']";
	private String inputPassagerLastName = "input[name='passLast0']";
	private String meal = "select[name='pass.0.meal']";
	private String selectMeal = "select[name='pass.0.meal']";
	private String selectCard = "select[name='creditCard']";
	private String inputCardNumber = "input[name='creditnumber']";
	private String selectCardExpMonth = "select[name='cc_exp_dt_mn']";
	private String selectCardExpYear = "select[name='cc_exp_dt_yr']";
	private String inputCardFirstName = "input[name='cc_frst_name']";
	private String inputCardMiddleName = "input[name='cc_mid_name']";
	private String inputCardLastName = "input[name='cc_last_name']";
	private String SecurePurchaseButton = "input[name='buyFlights']";

}
