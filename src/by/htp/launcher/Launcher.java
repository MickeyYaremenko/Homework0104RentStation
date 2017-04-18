package by.htp.launcher;


import by.htp.client.Client;
import by.htp.io.MyReader;
import by.htp.rentstation.RentStation;
import by.htp.rentstation.Seller;

public class Launcher {

	public static void main(String[] args) {
		
		
		RentStation rentStation = MyReader.initialize();
		
		Seller alex = new Seller("Alex", rentStation);
		
		Client maxim = new Client(1543, "Maxim");
		

		alex.showAllMainEquip();
		alex.showAllAccessories();
		
		String[] main = {"Bike Giant Alfa", "Bike Kelis", "Rollers Blades", "Bike Stels 420"};
		String[][] access = {null, null, {"Helmet Adio", "Gloves DC"}, null, {"Gloves Quicksilver", "KneePad Element"}};
		maxim.createOrder(main, access);
		
		Client fedor = new Client(18769, "Fedor");
		String[] main2 = {"Bike Stels 420"};
		String[][] access2 = {{"Helmet Giant"},{}};
		fedor.createOrder(main2, access2);
		
		alex.serveOrder(maxim);
		
		maxim.createOrder(main, access);
		alex.serveOrder(maxim);
		
//		alex.showAllMainEquip();
//		alex.showAvailableMainEquip();
//		alex.showAllAccessories();
		alex.serveOrder(fedor);
		
		alex.reportForDaysRange(2);
		
	}
	// TODO сделать добавление всего из файликов
	// TODO create report about rented equip
}