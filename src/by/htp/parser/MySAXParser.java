package by.htp.parser;

import java.io.File;

import javax.xml.parsers.SAXParserFactory;

import by.htp.rentstation.RentStation;

import javax.xml.parsers.SAXParser;

public class MySAXParser {

	public static void parse(RentStation rentStation) {
		try {
			File inputFile = new File("resources/products.xml");
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			MyHandler userhandler = new MyHandler(rentStation);
			saxParser.parse(inputFile, userhandler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
