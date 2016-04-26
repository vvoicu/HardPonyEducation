package tools.Utils;

public class StringUtils {

	public static String splitDestinationString(String text, String type) {
		String[] textSplit = text.split(" to ");
		String textSplited = "";
		switch (type) {
		case "from":
			textSplited = textSplit[0];
			break;

		case "to":
			textSplited = textSplit[0];
			break;
		}
		return textSplited;
	}

	public static String splitPassengersNumber(String passengersString) {
		String[] passengersSplit = passengersString.split(" ");
		String stringNumber = passengersSplit[0];
		return stringNumber;
	}

}
