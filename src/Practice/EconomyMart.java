package Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EconomyMart {
    private static class Item implements Comparable<Item>{
        String name;
        long price;
        public Item(String name, long price){
            this.name = name;
            this.price = price;
        }

        public int compareTo( Item secondItem){
            int diff = (int) (this.price - secondItem.price);
            if(diff != 0) return diff;
            return this.name.compareTo(secondItem.name);
        }
    }

    public static List<String> getItems(List<List<String>> entries) {
        // Write your code here
        List<Item> items = new ArrayList<>();
        List<String> returnValues = new ArrayList<>();
        int noOfViewing = 0;
        for(List<String> entry: entries){
            String command = entry.get(0);
            switch(command){
                case "INSERT":
                    String itemName = entry.get(1);
                    long itemPrice = Long.parseLong(entry.get(2));
                    items.add(new Item(itemName, itemPrice));
                    break;
                case "VIEW":
                    Collections.sort(items);
                    returnValues.add(items.get(noOfViewing++).name);
            }

        }
        return returnValues;
    }


}
