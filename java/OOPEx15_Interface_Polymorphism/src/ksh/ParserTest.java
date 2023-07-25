package ksh;

public class ParserTest {

	public static void main(String[] args) {
		Parseable parser = ParserManager.getParser("xml");
		parser.parse("tour.xml");
		
		parser = ParserManager.getParser("json");
		parser.parse("tour.json");
	}

}
