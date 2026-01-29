//Objects L103
/*Write a program to create a Book class with attributes title, author, and price. Add a method to display the book details.
*/
class bookHandle{
	String title;
	String author;
	double price;
	
	bookHandle(String title, String author, double price){
		this.title = title;
		this.author = author;
		this.price = price;
	}
	public void displayDetails(){
		System.out.println(title);
		System.out.println(author);
		System.out.println(price);
	}
	
	public static void main(String[] args){
		bookHandle bookhandle = new bookHandle("Butter", "Asako Yuzuki", 500
		);
		bookhandle.displayDetails();
		
	}
}