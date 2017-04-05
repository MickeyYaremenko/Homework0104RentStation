package by.htp.smth;

public class Seller {

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
					System.out.println("" + position + ". " + rentStation.getMainEquipment()[i][j] + " is on base");
					position++;
				} else {
					System.out.println("" + position + ". " + rentStation.getMainEquipment()[i][j] + " is rented");
					position++;
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
					System.out.println("" + position + ". " + rentStation.getAccessories()[i][j] + " is on base");
					position++;
				} else {
					System.out.println("" + position + ". " + rentStation.getAccessories()[i][j] + " is rented");
					position++;
				}
			}
		}
	}

	
	
}
