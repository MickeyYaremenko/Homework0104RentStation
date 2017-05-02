package by.htp.parser;

import org.xml.sax.helpers.DefaultHandler;

import by.htp.equipment.EquipFactory;
import by.htp.rentstation.RentStation;

import java.util.ArrayList;

import org.xml.sax.*;

public class MyHandler extends DefaultHandler {
	private RentStation rentStation;
	private ArrayList<String> equip = new ArrayList<>();
	private String element;

	public MyHandler(RentStation rentStation) {
		this.rentStation = rentStation;
	}

	@Override
	public void startDocument() throws SAXException {

	}

	@Override
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
		this.element = qName;
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		if (element.contains("bike") || element.contains("rollers")) {
			equip.add(element);
		} else {
			String str = new String(ch, start, length);
			if (!str.contains("\n") || !str.contains("\t"))
				equip.add(str);
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.contains("bike") || qName.contains("rollers")) {
			this.rentStation.addNewEquip(EquipFactory.createEquip(equip.toArray(new String[0])));
			this.equip.clear();
		}
	}

}
