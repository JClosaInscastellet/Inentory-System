package inventorySystem;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
public class ShowInventory extends JFrame {
	InvPanel panel;
	public ShowInventory(ArrayList<Item> a) {
		
		panel = new InvPanel(a);
		setSize(610,300);
		setVisible(true);
		add(panel);
		
	}

	
}

class InvPanel extends JPanel{
	ArrayList<Rectangle2D.Double> showRects = new ArrayList<Rectangle2D.Double>();
	ArrayList<String> names = new ArrayList<String>();
	ArrayList<Item> items = new ArrayList<Item>();
	private int i = 0,y=0;
	public InvPanel(ArrayList<Item> a) {
		this.items = a;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
		for(Rectangle2D r : drawStuff(items)) {
			g2D.draw(r);
		}
		i = 15;
		y = 10;
		for(String s : drawNames(names,items)) {
			g2D.drawString(s, i, y+20);
			i += 120;
			if(i+105 >= 610) {
				i = 15;
				y+=50;
			}
		}
		
	}
	public ArrayList<Rectangle2D.Double> drawStuff(ArrayList<Item> a) {
		showRects.removeAll(showRects);
		int i = 0,y=0;
		for(Item item : items) {
			showRects.add(new Rectangle2D.Double(i,y,120,50));
			i += 120;
			if(i+120 >= 610) {
				i = 0;
				y+=50;
			}
		}
		return showRects;
		
	}
	
	public ArrayList<String> drawNames(ArrayList<String> names,ArrayList<Item> a) {
		names.removeAll(names);
		int i = 0,y=0;
		for(Item item : items) {
			if(item.isBreakable()) { names.add(item.getName()+" | " +item.getDurability()+"%"); }
			else {names.add(item.getName()+"| Q:"+item.getQuantity());} 
		}
		return names;
		
	}
	
	
}