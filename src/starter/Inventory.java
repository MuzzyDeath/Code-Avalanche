package starter;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

import acm.graphics.GLabel;

import java.util.List;

/**
 *  @author Pranav Jammalamadaka
 */


public class Inventory {

	private static HashMap<Integer, Item> backpack;
	private static Item[] itemList;

	public void openBackpack() {
		
	}
	
	public void itemDetails(Item i) {
		i.printItemDetails();
	}

	public static void main(String[] args) {
		backpack = new HashMap<Integer, Item>();
		itemList = new Item[50];
		Item.generateItemList(itemList);
		backpack.put(0, itemList[2]);
		backpack.get(0).printItemDetails();
		Item.printItemList();
	}

}

