package by.htp.client;

import java.time.LocalDateTime;
import java.util.Arrays;

import by.htp.equipment.Accessory;
import by.htp.equipment.Equipment;
import by.htp.equipment.MainEquipment;
import by.htp.rentstation.TimeCounter;

public class RentUnit implements TimeCounter {

	private MainEquipment[] units;
	private LocalDateTime returnTime;
	private LocalDateTime rentTime;

	public RentUnit() {
		this.units = new MainEquipment[3];
	}

	public MainEquipment[] getUnits() {
		return units;
	}

	public void addMainEquip(MainEquipment equip) {
		if (equip == null) {
			System.out.println("Incorrect equipment entered");
		} else if (checkEmptyRoom() > 0) {
			int position = 0;
			while (units[position] != null) {
				position++;
			}
			units[position] = equip;
		} else {
			System.out.println("You can't rent more than 3 main items.");
		}

	}

	public void rentAccessories(int position, Accessory[] accessories) {
		if (units[position] != null) {
			units[position].setAccesories(accessories);
		} else {
			System.out.println("You want to add accessories to unexisting equip.");
		}
	}

	public int checkEmptyRoom() {
		int emptyRoom = 0;
		for (Equipment unit : units) {
			if (unit == null) {
				emptyRoom++;
			}
		}
		return emptyRoom;
	}

	@Override
	public void setReturnTime(LocalDateTime current, int hours) {
		returnTime = current.plusHours(hours);
	}

	public LocalDateTime getReturnTime() {
		return returnTime;
	}

	public LocalDateTime getRentTime() {
		return rentTime;
	}

	
	public void setRentTime(LocalDateTime rentTime) {
		this.rentTime = rentTime;
	}

	@Override
	public String toString() {
		return "RentUnit [units=" + Arrays.toString(units) + "]";
	}
}
