package by.htp.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import by.htp.equipment.Bike;
import by.htp.equipment.Category;
import by.htp.equipment.EquipFactory;
import by.htp.rentstation.RentStation;

public abstract class MyReader {
	public static RentStation initialize(){
	RentStation rentStation = new RentStation();
	
	String file = "C:\\StJava\\New\\Homework0104RentStation\\src\\by\\htp\\io\\equipment.txt";
	String line = "";
	String splitter = ",";
	try (BufferedReader br = new BufferedReader(new FileReader(file))){
		while ((line = br.readLine()) != null){
			String[] equip = line.split(splitter);
			rentStation.addNewEquip(EquipFactory.createEquip(equip));
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	return rentStation;
	}
}
