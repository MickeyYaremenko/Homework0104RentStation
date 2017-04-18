package by.htp.io;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import by.htp.client.Client;

public abstract class MyWriter {
	
	public static void printReport(Client client){
	String file = "C:\\StJava\\New\\Homework0104RentStation\\src\\by\\htp\\io\\RentReport.txt";
	try (BufferedWriter bw = new BufferedWriter(new FileWriter(
			file, true))){
		bw.write("" + client.getName() + System.lineSeparator() + client.getRentUnit().toString() + System.lineSeparator());
//		for (int i = 0; )
	} catch (IOException e) {
		e.printStackTrace();
	}
	}


}
