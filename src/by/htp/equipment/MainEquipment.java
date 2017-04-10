package by.htp.equipment;

import java.util.Arrays;

public abstract class MainEquipment extends Equipment{
	protected Accessory[] accesories;
	
	public MainEquipment(Category category, String title, Accessory[] access) {
		super(category, title);
		accesories = access;
	}
	
	public MainEquipment(Category category, String title) {
		super(category, title);
	}

	public Accessory[] getAccesories() {
		return accesories;
	}

	public void setAccesories(Accessory[] accesories) {
		this.accesories = accesories;
	}

	@Override
	public String toString() {
		return "Main equip [title=" + super.title + ", category=" + super.category + ", id=" + super.id + 
	", Accesories=" + Arrays.toString(accesories) + "]";
	}
	
	

}
