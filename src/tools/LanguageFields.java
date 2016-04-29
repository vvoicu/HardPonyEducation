package tools;

/**
 * This model is used to switch the strings from FieldGenerators based on which
 * the fields are generated.
 * 
 * @author vladvoicu
 *
 */
public class LanguageFields {

	private String alpha;
	private String alphaNumeric;
	private String alphaNumericChar;
	private String numeric;

	public String getAlpha() {
		return alpha;
	}


	public String getAlphaNumeric() {
		return alphaNumeric;
	}

	public String getAlphaNumericChar() {
		return alphaNumericChar;
	}

	public String getNumeric() {
		return numeric;
	}


	public void setAlpha(String alpha) {
		this.alpha = alpha;
	}

	public void setAlphaNumeric(String alphaNumeric) {
		this.alphaNumeric = alphaNumeric;
	}

	public void setAlphaNumericChar(String alphaNumericChar) {
		this.alphaNumericChar = alphaNumericChar;
	}

	public void setNumeric(String numeric) {
		this.numeric = numeric;
	}

}
