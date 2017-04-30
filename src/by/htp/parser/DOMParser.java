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

public class DOMParser {

	public static void readXML(RentStation rentStation){
		try {
			File xmlFile = new File("C:\\StJava\\New\\Homework0104RentStation\\resources\\products.xml");
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(xmlFile);
            document.getDocumentElement().normalize();
            
            NodeList nodeList = document.getElementsByTagName(document.getDocumentElement().getChildNodes().item(1).getNodeName());
            
            for(int i = 0; i < nodeList.getLength(); i++){
            	String[] equip = new String[3];
            	Node node = nodeList.item(i);
            	if (node.getNodeType() == Node.ELEMENT_NODE){
            		Element element = (Element)node;
            		equip[0] = nodeList.item(i).getNodeName();
            		equip[1] = element.getElementsByTagName("category").item(0).getChildNodes().item(0).getNodeValue();
            		equip[2] = element.getElementsByTagName("title").item(0).getChildNodes().item(0).getNodeValue();
            		rentStation.addNewEquip(EquipFactory.createEquip(equip));
            	}
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
