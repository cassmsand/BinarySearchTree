package binarySearchTree;

import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) {
		
		//Create Decimal Format object
		DecimalFormat f = new DecimalFormat("0.00");
		
		MenuItem rice = new MenuItem("Rice", 2.50, 1);
		MenuItem chicken = new MenuItem("Chicken", 10, 2);
		MenuItem salad = new MenuItem("Salad", 12, 1);
		MenuItem bacon = new MenuItem("Bacon", 5.50, 1);
		MenuItem pasta = new MenuItem("Pasta", 15, 3);
		MenuItem fries = new MenuItem("Fries", 7, 5);
		MenuItem burger = new MenuItem("Burger", 10, 2);
		MenuItem pickles = new MenuItem("Pickles", 12, 2);
		
		//create order 1
		Order order1 = new Order("1");
		
		//test insert
		order1.insert(rice);
		order1.insert(chicken);
		order1.insert(salad);
		order1.insert(bacon);
		order1.insert(pasta);
		order1.insert(fries);
		order1.insert(burger);
		order1.insert(pickles);
		
		//create order 2
		Order order2 = new Order("2");
		MenuItem pasta2 = new MenuItem("Pasta", 15, 5);
		MenuItem fries2 = new MenuItem("Fries", 7, 2);
		MenuItem burger2 = new MenuItem("Burger", 10, 1);
		MenuItem pickles2 = new MenuItem("Pickles", 12, 6);
		MenuItem rice2 = new MenuItem("Rice", 2.50, 3);
		MenuItem chicken2 = new MenuItem("Chicken", 10, 2);
		MenuItem salad2 = new MenuItem("Salad", 12, 4);
		MenuItem bacon2 = new MenuItem("Bacon", 5.50, 8);
		
		order2.insert(pasta2);
		order2.insert(fries2);
		order2.insert(burger2);
		order2.insert(pickles2);
		order2.insert(rice2);
		order2.insert(chicken2);
		order2.insert(salad2);
		order2.insert(bacon2);

		
		System.out.println("PREORDER RESULT:");
		order1.preorder();
		System.out.println();
		
		System.out.println("INORDER RESULT:");
		order1.inorder();
		System.out.println();
		
		System.out.println("POSTORDER RESULT:");
		order1.postorder();
		System.out.println();
		
		System.out.println("Number of menu items in order one: " + order1.size() );
		System.out.println("Height of order one tree: " + order1.depth());
		System.out.println("Total Quantity of all items: " + order1.getTotalQty());
		
		System.out.println();
		
		System.out.println("Print 'Burger' details if found in order one: " + order1.search("Burger"));
		
		System.out.println();
		
		System.out.println("Total of order one before tax: $" +f.format(order1.getTotalBeforeTax()));
		System.out.println("Total tax of order one: $" + f.format(order1.getTotalTax(0.08)));
		System.out.println("Total tip of order one: $" + f.format(order1.getTip(0.20)));
		
		System.out.println();
		System.out.println(order1.toString());
		
		System.out.println();
		System.out.println(order2.toString());
		
		
		
		
		
	}

}
