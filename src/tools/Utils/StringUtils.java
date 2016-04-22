package tools.Utils;

public class StringUtils {

	public static String splitDestinationString(String text, String type) {
		String[] textSplit = text.split(" to ");
		String textSplited = "";
		switch (type) {
		case "departing":
			textSplited = textSplit[0];
			break;

		case "arriving":
			textSplited = textSplit[0];
			break;
		}
		return textSplited;
	}
	
	
	public void main(String args[]){
		splitDestinationString("New York to Boston", "departing");
	}

}
