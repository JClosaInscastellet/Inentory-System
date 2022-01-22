package inventorySystem;

import java.util.Random;

/**
 * 
 * The Item class can be used to create Video game style
 * inventory items. <br> The class {@link Inventory} is used to manage 
 * items <br>
 * The items have:<br>
 * An ID, the id is used in the {@link Inventory} class to manage item quantity/stacking when adding items to an inventory using {@link Inventory#addItem(Item)} <br>
 * Duravility, an integer that's randomized when the item is created that can be 40-100, items with durability cannot be stacked<br>
 * Quantity, see {@link Inventory#addItem(Item)}<br>
 * A name <br>
 * A description <br>
 * Boolean tags for when the item is breakable/food, if the item is breakable it cannot be food, the {@link Inventory} class manages items diferently based on the isBreakable tag <br>
 * @author Judit <br>
 * @version 1.0.0 <br>
 */
public class Item {
	
	private int ID;
	
	private int durability = 100;
	
	private int quantity = 1;
	
	private String name;
	
	private String description;
	
	private boolean breakable;
	
	private boolean food;
	
	Random random = new Random();

	/**
	 * 
	 * @param name The name of the item
	 * @param description Description of the item
	 * @param breakable Is the item breakable?
	 * @param food Is the item food?
	 * @param ID ID of the item, unique!!!
	 */
	public Item(String name, String description,boolean breakable, boolean food,int ID){
		this.name = name;
		this.description = description;
		this.breakable = breakable;
		this.food = food;
		this.ID = ID;
		if(breakable == true) {
			this.food = false;
			this.durability = random.nextInt(60) + 40;
		}
		
	}
	
	/**
	 * Returns the item durability
	 * @return Item durability
	 */
	public int getDurability() {
		return durability;
	}

	/**
	 * Changes item durability
	 * @param durability The duravility you want to set
	 */
	public void setDurability(int durability) {
		this.durability = durability;
	}

	/**
	 * Returns the quantity of the item, see {@link Inventory#addItem(Item)}
	 * @return Quantity of the item, see {@link Inventory#addItem(Item)}
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Changes item quantity
	 * @param quantity The quantity you want to set, see {@link Inventory#addItem(Item)}
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Adds  items to a item satck, see {@link Inventory#addItem(Item)}
	 * @param quantity The quanity of the item you want to add
	 */
	public void addQuantity(int quantity) {
		this.quantity += quantity;
	}
	
	/**
	 * Returns the ID of the item
	 * @return ID of the item
	 */
	public int getID() {
		return ID;
	}
	
	/**
	 * Sets the id of the item 
	 * @param iD, The id you want
	 */
	public void setID(int iD) {
		this.ID = iD;
	}
	
	/**
	 * Returns the item name
	 * @return Name of the item
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Chages the name of the item
	 * @param name The name you want
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 *  Returns the item description
	 * @return The item description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the item description
	 * @param description The description you want
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns if the item is breakable
	 * @return If the object is breackable
	 */
	public boolean isBreakable() {
		return breakable;
	}

	/**
	 * Makes the object breabkble
	 * @param breakable
	 */
	public void setBreakable(boolean breakable) {
		this.breakable = breakable;
	}
 
	/**
	 * Returns if the item is food
	 * @return If the object is food
	 */
	public boolean isFood() {
		return food;
	}
	
	/**
	 * Makes the object food
	 * @param food
	 */
	public void setFood(boolean food) {
		this.food = food;
	}
	
	

}
