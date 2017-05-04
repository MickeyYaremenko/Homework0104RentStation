package by.htp.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import by.htp.client.Client;
import by.htp.equipment.Accessory;
import by.htp.equipment.MainEquipment;

public abstract class MyWriter {

	public static void printReport(Client client) {
		String file = "C:\\StJava\\New\\Homework0104RentStation\\src\\by\\htp\\io\\RentReport.txt";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
			bw.write("Client name:" + client.getName() + System.lineSeparator()
					+ /* client.getRentUnit().toString() */ servicePrintRentUnit(client));
			// for (int i = 0; )
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String servicePrintRentUnit(Client client) {
		String str;
		// if ()
		str = client.getRentUnit().getRentTime().toString() + System.lineSeparator();
		for (MainEquipment equip : client.getRentUnit().getUnits()) {
			if (equip != null) {
				str += equip.getTitle() + System.lineSeparator();
				if (equip.getAccesories() != null) {
					for (Accessory access : equip.getAccesories()) {

						str += access.getTitle() + System.lineSeparator();

					}
				}
			}
		}
		return str;
		// str = client.getRentUnit().getUnits().;
	}

}
