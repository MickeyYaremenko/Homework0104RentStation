package by.htp.smth;

public class Order {
	
	private String[] mainEq;
	private String[][] access;
	
	public Order(){
		
	}
	
	public Order(Order order){
		this.mainEq = order.mainEq;
		this.access = order.access;
	}
	
	public Order(String[] mainEq, String[]...access){
		this.mainEq = mainEq;
		this.access = access;
		
	}
	

	public void setMainEq(String[] mainEq) {
		this.mainEq = mainEq;
	}

	public void setAccess(String[][] access) {
		this.access = access;
	}

	public String[][] getAccessoryOrder() {
		return access;
	}
	
	public String[] getMainEquipmentOrder(){
		return mainEq;
	}
	
	public void orderTheseMainEquip(String... title){
		for (int i = 0; i < title.length; i++){
			mainEq[i] = title[i];
		}
	}

}
