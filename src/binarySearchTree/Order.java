package binarySearchTree;

import java.text.DecimalFormat;

public class Order{

	// instance variables
	private BSTNode<MenuItem> root;
	private String tableNumber;

	// static variable
	private static String restaurantName = "Fancy Town";

	// Constructor
	public Order(String tableNumber) {
		root = null;
		this.tableNumber = tableNumber;
	}
	
	//Create Decimal Format object
	DecimalFormat f = new DecimalFormat("0.00");

	// insert method
	public void insert(MenuItem element) {
		if (root == null) {
			root = new BSTNode<MenuItem>(element, null, null);
		} else {
			insert(root, element);
		}
	}

	// private insert method
	private void insert(BSTNode<MenuItem> current, MenuItem element) {
		// element is less than current node
		if (element.compareTo(current.getData()) < 0) {
			// move left
			if (current.getLeft() == null) {
				current.setLeft(new BSTNode<MenuItem>(element, null, null));
			} else {
				// Node has a child, keep going down the tree
				insert(current.getLeft(), element);
			}
			// element is greater than current node
		} else if (element.compareTo((MenuItem) current.getData()) > 0) {
			// move right
			if (current.getRight() == null) {
				current.setRight(new BSTNode<MenuItem>(element, null, null));
			} else {
				// Node has a child, keep going down the tree
				insert(current.getRight(), element);
			}
		}
		// element is equal to current node
		else {
			if (element.compareTo((MenuItem) current.getData()) == 0) {
				(current.getData()).setQuantity((current.getData()).getQuantity() + 1);
			}
		}
	}

	// traverses the tree in pre-order
	public void preorder() {
		preorder(root);
	}

	// private helper method
	private void preorder(BSTNode<MenuItem> current) {
		if (current != null) {
			System.out.println((current.getData()).getName());
			preorder(current.getLeft());
			preorder(current.getRight());
		}
	}

	// traverses the tree in in-order
	public void inorder() {
		inorder(root);
	}

	// private helper method
	private void inorder(BSTNode<MenuItem> current) {
		if (current != null) {
			inorder(current.getLeft());
			System.out.println((current.getData()).getName());
			inorder(current.getRight());
		}
	}

	// traverses the tree in post-order
	public void postorder() {
		postorder(root);
	}

	// private helper method
	private void postorder(BSTNode<MenuItem> current) {
		if (current != null) {
			postorder(current.getLeft());
			postorder(current.getRight());
			System.out.println((current.getData()).getName());
		}

	}

	// size method
	public int size() {
		return size(root);

	}

	// Size helper method
	private int size(BSTNode<MenuItem> current) {
		if (current == null) {
			return 0;
		} else {
			return (size(current.getLeft()) + size(current.getRight()) + 1);
		}
	}

	// height of the tree
	public int depth() {
		return depth(root);
	}

	// private helper method for depth
	private int depth(BSTNode<MenuItem> current) {
		// base case - tree is empty, depth is zero
		if (current == null)
			return 0;
		else {
			// Find the depth of the left branch
			int ldepth = depth(current.getLeft());
			// Find the depth of the right branch
			int rdepth = depth(current.getRight());

			// if left branch depth is greater return + 1
			if (ldepth > rdepth)
				return ldepth + 1;
			// if right branch depth is greater return + 1
			else
				return rdepth + 1;
		}
	}

	// Get total quantity method
	public int getTotalQty() {
		int sum = getTotalQty(root, 0, 0);
		sum += (root.getData()).getQuantity();
		return sum;
	}

	// private helper method to get total quantity
	private int getTotalQty(BSTNode<MenuItem> current, int lQuantity, int rQuantity) {
		int sum = 0;
		int leftSum = lQuantity;
		int rightSum = rQuantity;
		if (current == null)
			return 0;
		else {
			// calculate the sum of nodes in left subtree
			if (current.getLeft() != null) {
				leftSum += (current.getLeft().getData()).getQuantity();
				leftSum = getTotalQty(current.getLeft(), leftSum, rightSum);
			}
			// calculate the sum of nodes in right subtree
			if (current.getRight() != null) {
				rightSum += (current.getRight().getData()).getQuantity();
				getTotalQty(current.getRight(), leftSum, rightSum);
			}
			sum = leftSum + rightSum;
		}

		return sum;
	}

	// search for a menu item name
	public MenuItem search(String name) {
		return search(root, name);
	}

	// help method for search
	private MenuItem search(BSTNode<MenuItem> current, String name) {
		// get menuItem from node
		MenuItem item = current.getData();
		// get menuItem NAME from menuItem
		String itemName = item.getName();

		if (current != null) {
			// if current EQUALS name
			if (itemName.equalsIgnoreCase(name)) {
				return item;
			}
			// continue searching left
			else if (itemName.compareToIgnoreCase(name) < 0) {
				return search(current.getRight(), name);
			}
			// continue searching right
			else if(itemName.compareToIgnoreCase(name) > 0) {
				return search(current.getLeft(), name);
			}
		}

		// return null if current is null
		return null;
	}
	
	//get the total amount before tax
	public double getTotalBeforeTax() {
		return getTotalBeforeTax(root);
	}

	//private total amount before tax helper
	private double getTotalBeforeTax(BSTNode<MenuItem> current){
		double total = 0; 
		double totalLeft = 0;
		double totalRight = 0;  
          
        //return 0 if the tree is empty
        if(root == null) {   
            return 0;  
        }  
        else {  
            //Calculate left subtree  
            if(current.getLeft() != null)  
                totalLeft = getTotalBeforeTax(current.getLeft());  
              
            //Calculate right subtree  
            if(current.getRight() != null)  
                totalRight = getTotalBeforeTax(current.getRight());  
              
            //Calculate the total
            total = (current.getData().getPrice() * current.getData().getQuantity()) + totalLeft + totalRight;   
            return total; 
        }
	}
	
	//get the total amount before tax
	public double getTotalTax(double taxAmount) {
		return getTotalTax(root, taxAmount);
	}

	//private helper method for total after tax
	private double getTotalTax(BSTNode<MenuItem> current, double taxAmount) { 
        return getTotalBeforeTax(current)*taxAmount;   

	}
	
	//get tip amount
	public double getTip(double tipAmount) {
		return getTip(root, tipAmount);
	}
	
	//helper get tip amount
	private double getTip(BSTNode<MenuItem> root, double tipAmount) {
		return getTotalBeforeTax(root)*tipAmount;
	}
	
	//toString
	public String toString() {
		double totalBefore = getTotalBeforeTax(root);
		double tax = getTotalTax(root, 0.08);
		double tip = getTip(root, 0.20);
		
		String output = "";
		
		output += restaurantName + "   Table " + tableNumber;
		output += "\n------------------------------------------------------";
		output += "\nItem\t\tPrice\t\tQty\t\tTotal";
		output += "\n------------------------------------------------------\n";
		output += toString(root);
		output += "\n------------------------------------------------------\n";
		output += "Total:\t" + f.format(totalBefore) + "\n";
		output += "Tax:\t" + f.format(tax) + "\n";
		output += "Tip:\t" + f.format(tip);
		output += "\n------------------------------------------------------\n";
		output += "Grand Total: $" + f.format((totalBefore+tax+tip));
	
		return output;
	}

	private String toString(BSTNode<MenuItem> current) {
		
		String leftString = "";
		String rightString = "";
		String string = "";
		
		if (current.getData() == null) {
			return "";
		}
		else {
			//Calculate left subtree  
            if(current.getLeft() != null)  
                leftString = toString(current.getLeft());  
              
            //Calculate right subtree  
            if(current.getRight() != null)  
                rightString = toString(current.getRight());  
              
            //Calculate the total
            string = (current.getData().getName() + "\t\t$"
            		+ f.format(current.getData().getPrice()) + "\t\t"
            		+ current.getData().getQuantity() + "\t\t$"
            		+ f.format(current.getData().getPrice()*current.getData().getQuantity())
            		+ "\n" + leftString + rightString);  
            return string; 
		}
	}

}
