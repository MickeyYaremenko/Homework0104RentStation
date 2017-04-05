package by.htp.equipment;

public abstract class Accessory extends Equipment{

	public Accessory(Category category, String title) {
		super(category, title);
	}

	@Override
	public String toString() {
		return "Accesory [category=" + super.category + ", title=" + super.title + ", id=" + super.id + "]";
	}
	
	

}
