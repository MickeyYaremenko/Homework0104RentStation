package by.htp.equipment;

public class Bike extends MainEquipment{
	
	

	public Bike(Category category, String title, Accessory[] access) {
		super(category, title, access);
	}
	
	public Bike(Category category, String title) {
		super(category, title);
	}

	public Accessory[] getAccesories() {
		return super.getAccesories();
	}

	public void setAccesories(Accessory[] accesories) {
		super.accesories = accesories;
	}
	
	

}
