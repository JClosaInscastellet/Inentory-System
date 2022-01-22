package inventorySystem;

import java.util.ArrayList;
 
/**
 * The Inventory Class is used to manage items created with the class {@link Item} <br>
 * It can do:
 * <br>Storing items
 * <br>Adding items
 * <br>Listing stored items 
 * @author Judit
 * @version 1.0.0
 *
 */
public class Inventory {


	private ArrayList<Item> inventory = new ArrayList<Item>();	


	/**
	 *  Returns the entire inventory in the format <br> index + name + quantity or durability (depending of item)
	 * @return The entire inventory in the format <br> index + name + quantity or durability (depending of item)
	 */
	public String returnInventory() {
		String result="";
		for(Item item : inventory) {
			if(!item.isBreakable()) {
				result += inventory.indexOf(item) + " | " + item.getName()+"(" + item.getQuantity() + ")  \n";
			}else { 
				result += inventory.indexOf(item) + " | " + item.getName()+"(" + item.getDurability() + ") \n";
			}
		}
		return result;
	}

	/**
	 * Returns the entire inventory in ths format <br> index + name + description + newline + ID + Is it tool? + Is it food?
	 * @return The entire inventory in ths format <br> index + name + description + newline + ID + Is it tool? + Is it food?
	 */
	public String returnAdvanced() {
		String result="";
		for(Item item : inventory) {
			result += "______\nIndex: "+inventory.indexOf(item) + " | Name: " + item.getName()+" | "
					+ "Description: " + item.getDescription() + " |\nID:"+ item.getID() +
					" | Tool: "+item.isBreakable()+" | Food: "+item.isFood()+"\n"; 
		}
		return result;
	}
	
	/**
	 * Returns a single item object from the inventory
	 * @param index The index of the item
	 * @return Item
	 */
	public Item returnSingle(int index) {
		Item item;
		item = inventory.get(index);
		
		return item;
		
	}

	/**
	 * Adds items to the inventory
	 * <br>
	 * If the item is breakable it gets added directly to the inventory with a new index
	 * <br>
	 * If the item is not breakable and we aleady have at least one in the inventory, the quantity variable of the item gets up by "1" <br>
	 * If the item is not  breakable and we don't have-it in the inventory already, it gets added directly to the inventory with a new index
	 * <br> The item ID is used to check wheter we have it in the inventory or not
	 * @param item Item to add
	 */
	public void addItem(Item item) {
		boolean foundIt=false;
		int index = 0;
		if(item.isBreakable()) {
			inventory.add(new Item(item.getName(),item.getDescription(),item.isBreakable(),item.isFood(),item.getID()));
		}else {
			for (int i = 0; i < inventory.size(); i++) {
				if(inventory.get(i).getID() == item.getID()) {
					foundIt=true;
					index = i;
				}
			}
			if(foundIt) {
				inventory.get(index).addQuantity(1);
			}else {
				inventory.add(new Item(item.getName(),item.getDescription(),item.isBreakable(),item.isFood(),item.getID()));
			}

		}
	}

}