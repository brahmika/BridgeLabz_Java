//Object L104
/* Create an Item class with attributes itemCode, itemName, and price. Add a method to display item details and calculate the total cost for a given quantity.
*/
class Item{
	String itemCode;
	String itemName;
	double price;
	
	public Item(String itemCode, String itemName, double price){
		this.itemCode = itemCode;
		this.itemName = itemName; 
		this.price = price;
	}
	public void displayDetails(){
		System.out.println(itemCode);
		System.out.println(itemName);
		System.out.println(price);
	}
	public void calculate(int quantity){
		double totalSum = price * quantity;
		System.out.println(totalSum);
		
	}
	
	public static void main(String[] args){
		Item item = new Item("1EAD312", "Chips", 20);
		item.displayDetails();
		item.calculate(5);
	}
	
}