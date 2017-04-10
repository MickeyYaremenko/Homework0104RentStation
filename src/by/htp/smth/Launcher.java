package by.htp.smth;

import by.htp.equipment.Bike;
import by.htp.equipment.Category;
import by.htp.equipment.Gloves;
import by.htp.equipment.Helmet;
import by.htp.equipment.KneePad;
import by.htp.equipment.Rollers;
import by.htp.equipment.Skateboard;

public class Launcher {

	public static void main(String[] args) {
		
		
		RentStation rentStation = new RentStation();
		Seller alex = new Seller("Alex", rentStation);

		Client maxim = new Client(1543, "Maxim");
		Category summer = new Category("Summer");

		Bike bikeStels = new Bike(summer, "Bike Stels 420");
		Bike bikeMerida = new Bike(summer, "Bike Merida OP");
		Rollers rollersIDK = new Rollers(summer, "Roller Blades");
		Skateboard skateAdio = new Skateboard(summer, "Skateboard Adio");

		Helmet giant = new Helmet(summer, "Helmet Giant");
		KneePad element = new KneePad(summer, "KneePad Element");
		Gloves quicksilver = new Gloves(summer, "Gloves Quicksilver");

		rentStation.addNewEquip(bikeStels, bikeMerida, rollersIDK, skateAdio, giant, element, quicksilver);

		alex.showAllMainEquip();
		alex.showAllAccessories();
		String[] main = {"Bike Merida OP", "Skateboard Adio", "Roller Blades", "Bike Stels 420"};
		String[][] access = {null, null, {"Helmet Giant", "KneePad Element"}, null, {"Gloves Quicksilver", "KneePad Element"}};
		maxim.createOrder(main, access);
		Client fedor = new Client(18769, "Fedor");
		String[] main2 = {"Bike Stels 420"};
		String[][] access2 = {{"Helmet Giant"},{}};
		fedor.createOrder(main2, access2);
		alex.serveOrder(maxim);
		maxim.createOrder(main, access);
		alex.serveOrder(maxim);
//		alex.showAllMainEquip();
		alex.showAvailableMainEquip();
		alex.showAllAccessories();
		alex.serveOrder(fedor);
	}

}