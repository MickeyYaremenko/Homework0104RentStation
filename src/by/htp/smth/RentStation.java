package by.htp.smth;

import by.htp.equipment.Accessory;
import by.htp.equipment.MainEquipment;

public class RentStation {

	private MainEquipment[][] mainEquipment;
	private Accessory[][] accessories;
	private Client[] clientBase;
	private int clientCounter;

	{
		mainEquipment = new MainEquipment[10][2];
		accessories = new Accessory[10][2];
		clientBase = new Client[10];
		clientCounter = 0;
	}

	public void newClient(Client client) {
		if (client != null) {
			checkClientBaseCapacity();
			clientBase[clientCounter] = client;
			clientCounter++;
		}
	}

	private void checkClientBaseCapacity() {
		if (clientCounter == clientBase.length + 1) {
			Client[] tempBase = new Client[clientBase.length * 3 / 2];
			for (int i = 0; i < clientBase.length; i++) {
				tempBase[i] = clientBase[i];
				clientBase = tempBase;
			}
		}
	}

	public MainEquipment[][] getMainEquipment() {
		return mainEquipment;
	}

	public void setMainEquipment(MainEquipment[][] mainEquipment) {
		this.mainEquipment = mainEquipment;
	}

	public Accessory[][] getAccessories() {
		return accessories;
	}

	public void setAccessories(Accessory[][] accessories) {
		this.accessories = accessories;
	}

	public Client[] getClientBase() {
		return clientBase;
	}

	public int getClientCounter() {
		return clientCounter;
	}
	
	
	
	

}
