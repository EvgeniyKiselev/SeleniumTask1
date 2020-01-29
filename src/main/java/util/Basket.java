/*
package util;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Basket {
    static public TreeMap<Integer,String> itemsWhitPrice;

    public String getMaxPrice(){
        return  itemsWhitPrice.lastEntry().toString();
    }

    public String toString(){
        return itemsWhitPrice.keySet().stream()
                .map(key -> key + " рублей - " + itemsWhitPrice.get(key))
                .collect(Collectors.joining("; ", "{", "}"));
    }
}
*/