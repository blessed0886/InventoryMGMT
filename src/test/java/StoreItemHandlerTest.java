import Exceptions.NoItemException;
import InventoryHandler.StoreItemHandler;
import Model.StoreItem;
import Warehouse.StoreItemWarehouse;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.TreeMap;

public class StoreItemHandlerTest {

    static StoreItem book01;
    static StoreItem food01;
    static StoreItem med01;
    static StoreItem tab01;
    static TreeMap<String, StoreItem> testStoreItems;
    static ArrayList<StoreItem> testSoldItems;
    static StoreItemHandler storeItemHandler;
    static ByteArrayOutputStream outContent;

    @BeforeClass
    public static void setUp() throws Exception{
        outContent = new ByteArrayOutputStream();
        storeItemHandler = new StoreItemHandler();
        testStoreItems = new TreeMap();
        testSoldItems = new ArrayList();
        book01 = new StoreItem("Book01", 10.50, 13.79);
        food01 = new StoreItem("Food01", 1.47, 3.98);
        med01 = new StoreItem("Med01", 30.63, 34.29);
        tab01 = new StoreItem("Tab01", 57.00, 84.98);

        testStoreItems.put(book01.getName(), book01);
        testStoreItems.put(food01.getName(), food01);
        testStoreItems.put(med01.getName(), med01);
        testStoreItems.put(tab01.getName(), tab01);

        testSoldItems.add(tab01);

        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void createItemTest() throws Exception{
        storeItemHandler.createItem(book01, 3);

        StoreItem expected = StoreItemWarehouse.getSingleStoreItem(book01.getName());

        Assert.assertEquals(book01, expected);
    }

    @Test(expected = NoItemException.class)
    public void deleteItemTest() throws Exception{
        storeItemHandler.createItem(med01, 5);
        storeItemHandler.deleteItem(med01.getName());

        StoreItemWarehouse.getSingleStoreItem(med01.getName());
    }

    @Test
    public void updateBuyTest()throws Exception{
        storeItemHandler.createItem(tab01, 25);
        storeItemHandler.updateBuy(tab01.getName(), 75);
        int expected = 100;

        int actual = StoreItemWarehouse.getSingleStoreItem(tab01.getName()).getAvailableQty();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sellAnItemTest()throws Exception{
        storeItemHandler.createItem(food01, 30);
        storeItemHandler.sellItem(food01.getName(), 10);
        int soldExpected = 10;
        int availableExpected = 20;

        int soldActual = StoreItemWarehouse.getSingleSoldItem(food01.getName()).getNumberSold();
        int availableActual = StoreItemWarehouse.getSingleStoreItem(food01.getName()).getAvailableQty();

        Assert.assertEquals(soldExpected, soldActual);
        Assert.assertEquals(availableExpected, availableActual);
    }

    @Test
    public void printSellReportTest(){
        storeItemHandler.createItem(food01, 3);
        storeItemHandler.sellItem(food01.getName(), 1);
        String expected = "Item NameBought AtSold AtAvailableQtyValue------------------------------------------Food01 1.47 3.98 2\n";

        storeItemHandler.printSellingReport();

        Assert.assertEquals(expected, outContent.toString());
    }

    @Test
    public void printFullReportTest(){
        storeItemHandler.createItem(food01, 3);
        storeItemHandler.createItem(med01, 43);
        storeItemHandler.createItem(tab01, 413);
        storeItemHandler.createItem(book01, 12345667);
        String expected = "Item NameBought AtSold AtAvailableQtyValue------------------------------------------Book01 10.5 13.79 12345667\n" +
                "Food01 1.47 3.98 3\n" +
                "Med01 30.63 34.29 43\n" +
                "Tab01 57.0 84.98 413\n";

        storeItemHandler.printFullReport();

        Assert.assertEquals(expected, outContent.toString());
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
    }
}
