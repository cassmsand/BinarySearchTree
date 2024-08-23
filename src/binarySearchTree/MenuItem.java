package binarySearchTree;

import java.text.DecimalFormat;

public class MenuItem implements Comparable <MenuItem>{
	
	//Create Decimal Format object
	DecimalFormat f = new DecimalFormat("0.00");
	
	//instance variables
	private String name;
	private double price;
	private int quantity;
	
	//contructor
	public MenuItem(String name, double price, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	//Equals method
	public boolean equals(MenuItem one, MenuItem two) {
		if (one.getName().equalsIgnoreCase(two.getName()))
			return true;
		return false;
	}

	//getters and setters
	public String getName() {
		return name;
	}


	public double getPrice() {
		return price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	//toString
	public String toString() {
		String output = "";
		output += name +"\t";
		output += "$" + f.format(price) + "\t\t";
		output += quantity + "\t";
		output += "$" + f.format(price * quantity);
		
		return output;
	}

	//CompareTo method - returns 0 if the names are equal
	@Override
	public int compareTo(MenuItem item) {
		return name.compareToIgnoreCase(item.getName());
	}
	
	
	
}
