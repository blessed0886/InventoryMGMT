package Warehouse;

import Exceptions.ItemAlreadyExistsException;
import Exceptions.NoItemException;
import Model.StoreItem;
import java.util.ArrayList;
import java.util.TreeMap;

public class StoreItemWarehouse {

    private static TreeMap<String, StoreItem> storeItems = new TreeMap();

    private static ArrayList<StoreItem> soldItems = new ArrayList();

    private StoreItemWarehouse(){}

    public static TreeMap<String, StoreItem> getStoreItems() {
        return storeItems;
    }

    public static void addStoreItem(StoreItem storeItem, int quantity) throws Exception {
        if(storeItems.containsKey(storeItem.getName())) throw new ItemAlreadyExistsException();
        storeItem.setAvailableQty(quantity);
        storeItems.put(storeItem.getName(), storeItem);
    }

    public static ArrayList<StoreItem> getSoldItems() {
        return soldItems;
    }

    public static StoreItem getSingleStoreItem(String itemName) throws Exception{
        if(checkInventoryForItem(itemName))
        return storeItems.get(itemName);
        return null;
    }

    public static void sellAnItem(String itemName, int quantity) throws Exception{
        checkInventoryForItem(itemName);
        StoreItem item = storeItems.get(itemName);
        item.setAvailableQty(item.getAvailableQty() - quantity);
        item.setNumberSold(item.getNumberSold()+quantity);
        soldItems.add(item);
    }

    public static void deleteStoreItem(String itemName) throws Exception{
        if(checkInventoryForItem(itemName))
        storeItems.remove(itemName);
    }

    private static boolean checkInventoryForItem(String itemName) throws Exception{
        if(storeItems.containsKey(itemName)) return true;
        throw new NoItemException();
    }

    private static StoreItem checkSoldItems(String itemName) throws Exception{
        for(StoreItem item: soldItems){
            if(item.getName().equalsIgnoreCase(itemName)) return item;
        }
        throw new NoItemException();
    }
    public static StoreItem getSingleSoldItem(String itemName) throws Exception {
        return checkSoldItems(itemName);
    }

    public static void clearSoldItemList(){
        soldItems.clear();
    }

    public static void clearTotalSold(){
        for(String itemName: storeItems.keySet()){
            storeItems.get(itemName).setNumberSold(0);
        }
    }

    @Override
    public String toString() {
        return storeItems.values().stream().toString();
    }
}
