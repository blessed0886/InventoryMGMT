import InventoryHandler.StoreItemHandler;
import Model.StoreItem;

public class UserInterface {

    private String userStringInput;
    private Integer userIntInput;
    private StoreItemHandler storeItemHandler = new StoreItemHandler();

    public void start(){

        do {
            System.out.println("\n\n\n" +
                    "What action would you like to perform?\n" +
                    "Please choose from the below menu.\n\n" +
                    "  ___                    _         _ _             _  _                            _   ___     _                  _ _ _           ___     _        \n" +
                    " / \\ \\   __ _ _ ___ __ _| |_ ___  (_) |_ ___ _ __ | \\| |__ _ _ __  ___   __ ___ __| |_| _ \\_ _(_)__ ___   ___ ___| | (_)_ _  __ _| _ \\_ _(_)__ ___ \n" +
                    " | || | / _| '_/ -_) _` |  _/ -_) | |  _/ -_) '  \\| .` / _` | '  \\/ -_) / _/ _ (_-<  _|  _/ '_| / _/ -_) (_-</ -_) | | | ' \\/ _` |  _/ '_| / _/ -_)\n" +
                    " |_|| | \\__|_| \\___\\__,_|\\__\\___| |_|\\__\\___|_|_|_|_|\\_\\__,_|_|_|_\\___| \\__\\___/__/\\__|_| |_| |_\\__\\___| /__/\\___|_|_|_|_||_\\__, |_| |_| |_\\__\\___|\n" +
                    "  _/_/_       _     _     _         _ _             _  _                                                                    |___/                  \n" +
                    " |_  ) \\   __| |___| |___| |_ ___  (_) |_ ___ _ __ | \\| |__ _ _ __  ___                                                                            \n" +
                    "  / / | | / _` / -_) / -_)  _/ -_) | |  _/ -_) '  \\| .` / _` | '  \\/ -_)                                                                           \n" +
                    " /___|| | \\__,_\\___|_\\___|\\__\\___| |_|\\__\\___|_|_|_|_|\\_\\__,_|_|_|_\\___|                                                                           \n" +
                    "  ___/_/                  _      _       ___             _ _             _  _                                     _   _ _                          \n" +
                    " |__ /\\ \\   _  _ _ __  __| |__ _| |_ ___| _ )_  _ _  _  (_) |_ ___ _ __ | \\| |__ _ _ __  ___   __ _ _  _ __ _ _ _| |_(_) |_ _  _                   \n" +
                    "  |_ \\ | | | || | '_ \\/ _` / _` |  _/ -_) _ \\ || | || | | |  _/ -_) '  \\| .` / _` | '  \\/ -_) / _` | || / _` | ' \\  _| |  _| || |                  \n" +
                    " |___/ | |  \\_,_| .__/\\__,_\\__,_|\\__\\___|___/\\_,_|\\_, | |_|\\__\\___|_|_|_|_|\\_\\__,_|_|_|_\\___| \\__, |\\_,_\\__,_|_||_\\__|_|\\__|\\_, |                  \n" +
                    "  _ __/_/       |_|      _      _       ___      _|__/ _ _             _  _                      |_|            _   _ _     |__/                   \n" +
                    " | | \\ \\   _  _ _ __  __| |__ _| |_ ___/ __| ___| | | (_) |_ ___ _ __ | \\| |__ _ _ __  ___   __ _ _  _ __ _ _ _| |_(_) |_ _  _                     \n" +
                    " |_  _| | | || | '_ \\/ _` / _` |  _/ -_)__ \\/ -_) | | | |  _/ -_) '  \\| .` / _` | '  \\/ -_) / _` | || / _` | ' \\  _| |  _| || |                    \n" +
                    "   |_|| |  \\_,_| .__/\\__,_\\__,_|\\__\\___|___/\\___|_|_| |_|\\__\\___|_|_|_|_|\\_\\__,_|_|_|_\\___| \\__, |\\_,_\\__,_|_||_\\__|_|\\__|\\_, |                    \n" +
                    "  ___/_/       |_|  _     _      __      _ _   ___                   _                         |_|                        |__/                     \n" +
                    " | __\\ \\   _ __ _ _(_)_ _| |_   / _|_  _| | | | _ \\___ _ __  ___ _ _| |_                                                                           \n" +
                    " |__ \\| | | '_ \\ '_| | ' \\  _| |  _| || | | | |   / -_) '_ \\/ _ \\ '_|  _|                                                                          \n" +
                    " |___/| | | .__/_| |_|_||_\\__| |_|  \\_,_|_|_| |_|_\\___| .__/\\___/_|  \\__|                                                                          \n" +
                    "   __/_/  |_|       _     _             _    _   ___  |_|              _                                                                           \n" +
                    "  / /\\ \\   _ __ _ _(_)_ _| |_   ___ ___| |__| | | _ \\___ _ __  ___ _ _| |_                                                                         \n" +
                    " / _ \\| | | '_ \\ '_| | ' \\  _| (_-</ _ \\ / _` | |   / -_) '_ \\/ _ \\ '_|  _|                                                                        \n" +
                    " \\___/| | | .__/_| |_|_||_\\__| /__/\\___/_\\__,_| |_|_\\___| .__/\\___/_|  \\__|                                                                        \n" +
                    "     /_/  |_|                                           |_|                                                                                        ");

            userIntInput = Console.getUserInputInteger("Please enter a corresponding number.");

            switch (userIntInput) {
                case 1:
                    createItem();
                    break;
                case 2:
                    deleteItem();
                    break;
                case 3:
                    updateBuyItem();
                    break;
                case 4:
                    updateSellItem();
                    break;
                case 5:
                    storeItemHandler.printFullReport();
                    break;
                case 6:
                    storeItemHandler.printSellingReport();
            }

            System.out.println("Would you like to perform another action?");
            do {
                userStringInput = Console.getUserInputString("Please enter yes or no.");
            }while(!(userStringInput.equalsIgnoreCase("yes") || userStringInput.equalsIgnoreCase("no")));

        } while (userStringInput.equalsIgnoreCase("yes"));

    }

    private void updateSellItem() {
        String itemName = Console.getUserInputString("Please enter the items name.");
        Integer quantity = Console.getUserInputInteger("Please enter the number sold");
        storeItemHandler.sellItem(itemName, quantity);
    }

    private void updateBuyItem() {
        String itemName = Console.getUserInputString("Please enter the items name");
        Integer quantity = Console.getUserInputInteger("Please enter the number you of " + itemName +
                "s that you purchased.");
        storeItemHandler.updateBuy(itemName, quantity);    }

    private void deleteItem() {
        String itemName = Console.getUserInputString("Please enter the name of the item that you would like to delete");
        storeItemHandler.deleteItem(itemName);
    }

    private void createItem(){
        String name = Console.getUserInputString("Please enter the items name.");
        Double boughtAt = Console.getUserInputDouble("Please enter the price you bought them at.");
        Double sellAt = Console.getUserInputDouble("Please enter the selling price.");
        StoreItem storeItem = new StoreItem(name, boughtAt, sellAt);
        Integer quantity = Console.getUserInputInteger("Please enter the quantity of this item.");
        storeItemHandler.createItem(storeItem, quantity);
    }

}
