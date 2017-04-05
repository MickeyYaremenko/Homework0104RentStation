package by.htp.smth;

import by.htp.equipment.Accessory;
import by.htp.equipment.MainEquipment;

public class Client{
	private int passportID;
	private String name;
	private RentUnit rentUnit;
	private Order order;

	public Client(int passportID, String name) {
		this.passportID = passportID;
		this.name = name;
		this.rentUnit = new RentUnit();
	}

	public int getPassportID() {
		return passportID;
	}

	public String getName() {
		return name;
	}

	public RentUnit getRentUnit() {
		return rentUnit;
	}

	public void setRentUnit(RentUnit rentunit) {
		this.rentUnit = rentunit;
	}

//	@Override
//	public void makeAnOrderEquipment(String[][] mainEquipmentAccessories) {
//		this.order = new Order(mainEquipmentAccessories);
//		
//	}
//
//	public Order getOrder() {
//		return order;
//	}

	



}
