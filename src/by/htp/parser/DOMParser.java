package by.htp.parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import by.htp.equipment.EquipFactory;
import by.htp.rentstation.RentStation;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class DOMParser {

	public static void readXML(RentStation rentStation) {
		try {
			File xmlFile = new File("resources/products.xml");
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(xmlFile);
			document.getDocumentElement().normalize();

			NodeList nodeList = document.getDocumentElement().getChildNodes();

			for (int i = 0; i < nodeList.getLength(); i++) {
				ArrayList<String> equip = new ArrayList<>();
				Node node = nodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					equip.add(nodeList.item(i).getNodeName());
					equip.add(element.getElementsByTagName("category").item(0).getChildNodes().item(0).getNodeValue());
					equip.add(element.getElementsByTagName("title").item(0).getChildNodes().item(0).getNodeValue());

					rentStation.addNewEquip(EquipFactory.createEquip(equip.toArray(new String[0])));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
