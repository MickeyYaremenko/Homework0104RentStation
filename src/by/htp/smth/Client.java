package by.htp.smth;

public class Client {
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void createOrder(String[] mainEq, String[]... access) {
		this.order = new Order(mainEq, access);
	}

	public void closeOrder() {
		this.order = null;
	}

}
