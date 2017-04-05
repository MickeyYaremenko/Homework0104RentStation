package by.htp.equipment;

public class Skateboard extends MainEquipment{

	public Skateboard(Category category, String title, Accessory[] access) {
		super(category, title, access);
	}
	
	public Skateboard(Category category, String title) {
		super(category, title);
	}

	public Accessory[] getAccesories() {
		return super.getAccesories();
	}

	public void setAccesories(Accessory[] accesories) {
		super.accesories = accesories;
	}
}
