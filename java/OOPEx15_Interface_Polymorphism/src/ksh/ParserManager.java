package ksh;

public class ParserManager {
	public static Parseable getParser(String ext) {
		Parseable result = null;
		
		if(ext.toLowerCase().equals("xml")) {
			result = new XMLParser();
		} else if(ext.toLowerCase().equals("json")) {
			result = new JSONParser();
		}
		
		return result;
	}
}
