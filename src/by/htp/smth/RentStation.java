package by.htp.smth;

import by.htp.equipment.Accessory;
import by.htp.equipment.Equipment;
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
		if (clientCounter == clientBase.length) {
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

	public Accessory[][] getAccessories() {
		return accessories;
	}

	public Client[] getClientBase() {
		return clientBase;
	}

	public int getClientCounter() {
		return clientCounter;
	}

	public void addNewEquip(Equipment... equipment) {
		for (int i = 0; i < equipment.length; i++) {
			if (equipment[i] != null) {
				if (equipment[i] instanceof MainEquipment) {
					addMainEquip((MainEquipment) equipment[i]);
				} else if (equipment[i] instanceof Accessory) {
					addAccessory((Accessory) equipment[i]);
				}
			}
		}
	}

	private void addMainEquip(MainEquipment equip) {
		ensureMainEquipCapacity();
		mainEquipment[mainEquipment.length - emptySlotsInMain()][0] = equip;
	}

	private void addAccessory(Accessory equip) {
		ensureAcessoriesCapacity();
		accessories[accessories.length - emptySlotsInAccesories()][0] = equip;
	}

	private void ensureMainEquipCapacity() {
		if (emptySlotsInMain() <= 0) {
			MainEquipment[][] tempMain = new MainEquipment[this.mainEquipment.length * 3 / 2][2];
			for (int i = 0; i < this.mainEquipment.length; i++) {
				for (int j = 0; j < this.mainEquipment[i].length; j++) {
					tempMain[i][j] = this.mainEquipment[i][j];
				}
			}
			this.mainEquipment = tempMain;
		}
	}

	private int emptySlotsInMain() {
		int voidPlaceCounter = 0;
		for (int i = 0; i < this.mainEquipment.length; i++) {
			if (this.mainEquipment[i][0] == null && this.mainEquipment[i][1] == null) {
				voidPlaceCounter++;
			}
		}
		return voidPlaceCounter;
	}

	private void ensureAcessoriesCapacity() {
		if (emptySlotsInAccesories() <= 0) {
			Accessory[][] tempAccess = new Accessory[this.accessories.length * 3 / 2][2];
			for (int i = 0; i < this.accessories.length; i++) {
				for (int j = 0; j < this.accessories[i].length; j++) {
					tempAccess[i][j] = this.accessories[i][j];
				}
			}
			this.accessories = tempAccess;
		}
	}

	private int emptySlotsInAccesories() {
		int voidPlaceCounter = 0;
		for (int i = 0; i < this.accessories.length; i++) {
			if (this.accessories[i][0] == null && this.accessories[i][1] == null) {
				voidPlaceCounter++;
			}
		}
		return voidPlaceCounter;
	}

	public void changeMainEquipStatus(int position) {
		if (mainEquipment[position][0] != null) {
			mainEquipment[position][1] = mainEquipment[position][0];
			mainEquipment[position][0] = null;
		} else {
			mainEquipment[position][0] = mainEquipment[position][1];
			mainEquipment[position][1] = null;
		}
	}

	public void changeAccessoryStatus(int position) {
		if (accessories[position][0] != null) {
			accessories[position][1] = accessories[position][0];
			accessories[position][0] = null;
		} else {
			accessories[position][0] = accessories[position][1];
			accessories[position][1] = null;
		}
	}

	public void trimAll() {
		trimMain();
		trimAccess();
	}
	
	private void trimMain() {
		MainEquipment[][] tempMainEq = new MainEquipment[mainEquipment.length - emptySlotsInMain()][2];
		for (int i = 0; i < tempMainEq.length; i++) {
			tempMainEq[i][0] = mainEquipment[i][0];
			tempMainEq[i][1] = mainEquipment[i][1];
		}
		mainEquipment = tempMainEq;
	}
	
	private void trimAccess() {
		Accessory[][] tempAccess = new Accessory[accessories.length - emptySlotsInAccesories()][2];
		for (int i = 0; i < tempAccess.length; i++) {
			tempAccess[i][0] = accessories[i][0];
			tempAccess[i][1] = accessories[i][1];
		}
		accessories = tempAccess;
	}
	
}
