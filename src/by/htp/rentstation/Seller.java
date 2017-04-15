package by.htp.rentstation;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Random;

import by.htp.client.Client;
import by.htp.client.Order;
import by.htp.client.RentUnit;
import by.htp.equipment.Accessory;

public final class Seller {

	private String name;
	private RentStation rentStation;

	public Seller(String name, RentStation rentStation) {
		this.name = name;
		this.rentStation = rentStation;
	}

	public void showAllMainEquip() {
		System.out.println("All main equip:");
		int position = 1;
		for (int i = 0; i < rentStation.getMainEquipment().length; i++) {
			for (int j = 0; j < rentStation.getMainEquipment()[i].length; j++) {
				if (j == 0) {
					if (rentStation.getMainEquipment()[i][j] != null) {
						System.out
								.println("" + position + ". " + rentStation.getMainEquipment()[i][j] + " is on base.");
						position++;
					}
				} else {
					if (rentStation.getMainEquipment()[i][j] != null) {
						System.out.println("" + position + ". " + rentStation.getMainEquipment()[i][j] + " is rented.");
						position++;
					}
				}
			}
		}
	}

	public void showAllAccessories() {
		System.out.println("All accessories:");
		int position = 1;
		for (int i = 0; i < rentStation.getAccessories().length; i++) {
			for (int j = 0; j < rentStation.getAccessories()[i].length; j++) {
				if (j == 0) {
					if (rentStation.getAccessories()[i][j] != null) {
						System.out.println("" + position + ". " + rentStation.getAccessories()[i][j] + " is on base.");
						position++;
					}
				} else {
					if (rentStation.getAccessories()[i][j] != null) {
						System.out.println("" + position + ". " + rentStation.getAccessories()[i][j] + " is rented.");
						position++;
					}
				}
			}
		}
	}

	public void showAvailableMainEquip() {
		System.out.println("All available main equip:");
		int position = 1;
		for (int i = 0; i < rentStation.getMainEquipment().length; i++) {

			if (rentStation.getMainEquipment()[i][0] != null) {
				System.out.println("" + position + ". " + rentStation.getMainEquipment()[i][0] + " is on base.");
				position++;
			}

		}
	}

	public void showAvailableAccess() {
		System.out.println("All available main equip:");
		int position = 1;
		for (int i = 0; i < rentStation.getAccessories().length; i++) {

			if (rentStation.getAccessories()[i][0] != null) {
				System.out.println("" + position + ". " + rentStation.getAccessories()[i][0] + " is on base.");
				position++;
			}

		}
	}

	private boolean checkForAvailableMainEquip(String title) {
		if (title != null) {
			for (int i = 0; i < rentStation.getMainEquipment().length; i++) {
				if (rentStation.getMainEquipment()[i][0] != null) {
					if (title.equalsIgnoreCase(rentStation.getMainEquipment()[i][0].getTitle())) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private int positionInStationMainEquip(String title) {
		int position = 0;
		for (int i = 0; i < rentStation.getMainEquipment().length; i++) {
			for (int j = 0; j < rentStation.getMainEquipment()[i].length; j++) {
				if (rentStation.getMainEquipment()[i][j] != null) {
					if (title.equalsIgnoreCase(rentStation.getMainEquipment()[i][j].getTitle())) {
						position = i;
					}
				}
			}
		}
		return position;
	}

	private boolean checkForAvailableAccess(String title) {
		if (title != null) {
			for (int i = 0; i < rentStation.getAccessories().length; i++) {
				if (rentStation.getAccessories()[i][0] != null) {
					if (title.equalsIgnoreCase(rentStation.getAccessories()[i][0].getTitle())) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private int positionInStationAccess(String title) {
		int position = 0;
		for (int i = 0; i < rentStation.getAccessories().length; i++) {
			for (int j = 0; j < rentStation.getAccessories()[i].length; j++) {
				if (rentStation.getAccessories()[i][j] != null) {
					if (rentStation.getAccessories()[i][j].getTitle().equalsIgnoreCase(title)) {
						position = i;
					}
				}
			}
		}
		return position;
	}

	public void serveOrder(Client client) {
		if (client == null) {
			System.out.println("Something went wrong, check entered data.");
			return;
		}
		rentStation.trimAll();
		if (checkClient(client)) {
			LocalDateTime time = LocalDateTime.now().plusHours((new Random().nextInt(8)));
			LocalDateTime clientRentTime = client.getRentUnit().getReturnTime();
			if (time.isAfter(clientRentTime)) {
				System.out.println("Sorry but equipment rent time is greater than allowed."
						+ "You had to return this order by: " + clientRentTime + ". Current time is : " + time
						+ ". You need to close order first!");
				return;
			}
			showClientInventory(client);
			returnEquipment(client);
			RentUnit rentUnit = client.getRentUnit();
			client.setOrder(checkOrderSize(client.getOrder(), rentUnit));
			rentUnit = rentMainEquip(rentUnit, client.getOrder());
			rentUnit = rentAccessories(rentUnit, client.getOrder());
			client.setRentUnit(rentUnit);
			client.getOrder().getMainEquipmentOrder();
		} else {
			this.rentStation.newClient(client);
			RentUnit rentUnit = new RentUnit();
			client.setOrder(checkOrderSize(client.getOrder(), rentUnit));
			rentUnit = rentMainEquip(rentUnit, client.getOrder());
			rentUnit = rentAccessories(rentUnit, client.getOrder());
			rentUnit.setReturnTime(3); // TODO add constant for rent time
			client.setRentUnit(rentUnit);
			client.closeOrder();
		}
	}

	private Order checkOrderSize(Order order, RentUnit rentUnit) {
		Order tempOrder = new Order(order);
		if (order.getMainEquipmentOrder().length >= rentUnit.checkEmptyRoom()) {
			tempOrder.setMainEq(Arrays.copyOfRange(order.getMainEquipmentOrder(), 0, rentUnit.checkEmptyRoom()));
			showExtraMainEquip(order, rentUnit);
		}

		if (order.getAccessoryOrder().length >= order.getMainEquipmentOrder().length) {
			tempOrder.setAccess(
					Arrays.copyOfRange(order.getAccessoryOrder(), 0, tempOrder.getMainEquipmentOrder().length));
			showExtraAccessory(order, rentUnit);
		}
		return tempOrder;
	}

	private void showExtraMainEquip(Order order, RentUnit rentUnit) {
		String[] extraMain = Arrays.copyOfRange(order.getMainEquipmentOrder(), rentUnit.checkEmptyRoom(),
				order.getMainEquipmentOrder().length);
//		if (extraMain.length != 0){
		System.out.println(Arrays.toString(extraMain) + " will be left on base.");
//		}
	}

	private void showExtraAccessory(Order order, RentUnit rentUnit) {
		String[][] extraAccess = Arrays.copyOfRange(order.getAccessoryOrder(), order.getMainEquipmentOrder().length,
				order.getAccessoryOrder().length);
		for (int i = 0; i < extraAccess.length; i++) {
			if (extraAccess[i] != null) {
				System.out.println(Arrays.toString(extraAccess[i]) + " will be left on base.");
			}
		}
	}

	private RentUnit rentMainEquip(RentUnit rentUnit, Order order) {
		for (int i = 0; i < order.getMainEquipmentOrder().length; i++) {
			if (checkForAvailableMainEquip(order.getMainEquipmentOrder()[i])) {
				int position = positionInStationMainEquip(order.getMainEquipmentOrder()[i]);
				rentUnit.addMainEquip(rentStation.getMainEquipment()[position][0]);
				rentStation.changeMainEquipStatus(position);
			}
		}
		return rentUnit;
	}

	private RentUnit rentAccessories(RentUnit rentUnit, Order order) {
		for (int i = 0; i < order.getAccessoryOrder().length; i++) {
			if (order.getAccessoryOrder()[i] != null) {
				Accessory[] accessoriesForRent = new Accessory[order.getAccessoryOrder()[i].length];
				for (int j = 0; j < order.getAccessoryOrder()[i].length; j++) {
					if (checkForAvailableAccess(order.getAccessoryOrder()[i][j])) {
						int position = positionInStationAccess(order.getAccessoryOrder()[i][j]);
						accessoriesForRent[j] = rentStation.getAccessories()[position][0];
						rentStation.changeAccessoryStatus(position);
					}
				}
				rentUnit.rentAccessories(i, accessoriesForRent);
			}
		}

		return rentUnit;
	}

	private void showClientInventory(Client client) {
		for (int i = 0; i < client.getRentUnit().getUnits().length; i++) {
			if (client.getRentUnit().getUnits()[i] != null) {
				System.out.println(client.getRentUnit().getUnits()[i]);
			}
		}
	}

	private boolean checkClient(Client client) {
		for (int i = 0; i < rentStation.getClientBase().length; i++) {
			if (rentStation.getClientBase()[i] != null) {
				if (client.getPassportID() == rentStation.getClientBase()[i].getPassportID()) {
					return true;
				}
			}
		}
		return false;
	}

	public void returnEquipment(Client client) {
		RentUnit tempRentUnit = client.getRentUnit();
		for (int i = 0; i < tempRentUnit.getUnits().length; i++) {
			if (tempRentUnit.getUnits()[i].getAccesories() != null) {
				for (int j = 0; j < tempRentUnit.getUnits()[i].getAccesories().length; j++) {
					int position = positionInStationAccess(tempRentUnit.getUnits()[i].getAccesories()[j].getTitle());
					this.rentStation.changeAccessoryStatus(position);
				}
			}
		}

		for (int i = 0; i < tempRentUnit.getUnits().length; i++) {
			if (tempRentUnit.getUnits()[i] != null) {
				int position = positionInStationMainEquip(tempRentUnit.getUnits()[i].getTitle());
				this.rentStation.changeMainEquipStatus(position);
			}
		}
		client.setRentUnit(new RentUnit());
	}
}
