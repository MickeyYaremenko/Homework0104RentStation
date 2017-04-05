package by.htp.smth;

import by.htp.equipment.MainEquipment;

public class RentUnit {
	
	private MainEquipment[] units;
	private int emptySlots;
	
	public RentUnit() {
		this.units = new MainEquipment[3];
		this.emptySlots = 3;
	}

	public MainEquipment[] getUnits() {
		return units;
	}
	
	public int checkEmptySlotsNumber(){
		this.emptySlots = this.units.length;
		for (int i = 0; i < this.units.length; i++){
			if (this.units[i] != null){
			this.emptySlots--;
			}
		}
		return this.emptySlots;
	}

}
