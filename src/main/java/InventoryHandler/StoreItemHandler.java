package InventoryHandler;

import Warehouse.StoreItemWarehouse;
import Model.StoreItem;

public class StoreItemHandler {

    public void createItem(StoreItem storeItem, int quantity){
        try {
            StoreItemWarehouse.addStoreItem(storeItem, quantity);
        } catch(Exception exp){
            System.out.println(exp.getClass().getSimpleName());
        }
    }

    public void deleteItem(String itemName){
        try{
            StoreItemWarehouse.deleteStoreItem(itemName);
        } catch(Exception exp){
            System.out.println(exp.getClass().getSimpleName());
        }
    }

    public void updateBuy(String itemName, int quantity){
        try {
            int currentQty = StoreItemWarehouse.getSingleStoreItem(itemName).getAvailableQty();
            StoreItemWarehouse.getSingleStoreItem(itemName).setAvailableQty(quantity + currentQty);
        }catch(Exception exp){
            System.out.println(exp.getClass().getSimpleName());
        }
    }

    public void sellItem(String itemName, int quantity){
        try {
            StoreItemWarehouse.sellAnItem(itemName, quantity);
        } catch(Exception exp){
            System.out.println(exp.getClass().getSimpleName());
        }
    }

    public void printSellingReport(){
        try {
            double totalValue;
            double profit;
            System.out.println("Item Name" + "Bought At" + "Sold At" + "AvailableQty" + "Value");
            System.out.println("---------" + "---------" + "-------" + "------------" + "-----");
            for(StoreItem item: StoreItemWarehouse.getSoldItems()){
                System.out.println(item.getName() + " number sold: " + item.getNumberSold());
            }
        }catch(Exception exp){
            System.out.println(exp.getClass().getSimpleName());
        }
        System.out.println("\n");
    }

    public void printFullReport(){
        try {
            double totalValue;
            double profit;
            System.out.printf("Item Name" + "Bought At" + "Sold At" + "AvailableQty" + "Value");
            System.out.printf("---------" + "---------" + "-------" + "------------" + "-----");
            for(String itemName: StoreItemWarehouse.getStoreItems().keySet()){
                System.out.println(StoreItemWarehouse.getStoreItems().get(itemName).toString());
            }
        }catch(Exception exp){
            System.out.println(exp.getClass().getSimpleName());
        }
        System.out.println("\n");
    }
}
