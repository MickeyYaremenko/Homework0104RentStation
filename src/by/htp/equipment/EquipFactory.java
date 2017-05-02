package by.htp.equipment;

public abstract class EquipFactory {
	
//	public EquipFactory(){}
	
	public static Equipment createEquip(String[] read){
		String equipType = read[0].toLowerCase();
		String category = read[1];
		String title = read[2];
		switch (equipType){
			case "bike":
				Equipment bike = new Bike(Category.valueOf(category.toUpperCase()), title);
				return bike;
			case "rollers":
				Equipment rollers = new Rollers(Category.valueOf(category.toUpperCase()), title);
				return rollers;
			case "skateboard":
				Equipment skate = new Skateboard(Category.valueOf(category.toUpperCase()), title);
				return skate;
			case "glasses":
				Equipment glasses = new Glasses(Category.valueOf(category.toUpperCase()), title);
				return glasses;
			case "gloves":
				Equipment gloves = new Gloves(Category.valueOf(category.toUpperCase()), title);
				return gloves;
			case "helmet":
				Equipment helmet = new Helmet(Category.valueOf(category.toUpperCase()), title);
				return helmet;
			case "kneepad":
				Equipment kneePad = new KneePad(Category.valueOf(category.toUpperCase()), title);
				return kneePad;
			default:
				System.out.println("You've enetred some wrong data");
		}
		return null;
	}

}
