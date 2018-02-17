import Exceptions.NoItemException;
import Model.StoreItem;
import Warehouse.StoreItemWarehouse;
import org.junit.*;

import java.util.ArrayList;
import java.util.TreeMap;

public class StoreItemWarehouseTest {

    static StoreItem book01;
    static StoreItem food01;
    static StoreItem med01;
    static StoreItem tab01;
    static TreeMap<String, StoreItem> testStoreItems;
    static ArrayList<StoreItem> testSoldItems;

    @BeforeClass
    public static void setUp() throws Exception{
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

        StoreItemWarehouse.addStoreItem(book01, 3);
        StoreItemWarehouse.addStoreItem(food01, 3);
        StoreItemWarehouse.addStoreItem(med01, 3);
        StoreItemWarehouse.addStoreItem(tab01, 3);

        StoreItemWarehouse.sellAnItem(tab01.getName(), 1);
    }

    @Test
    public void getStoreItemsTest(){
        TreeMap expected = testStoreItems;

        TreeMap actual = StoreItemWarehouse.getStoreItems();

        Assert.assertEquals(expected, actual);
  }

    @Test
     public void getSoldItemTest(){
        tab01.setNumberSold(1);
        ArrayList expected = testSoldItems;

        ArrayList actual = StoreItemWarehouse.getSoldItems();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getSingleStoreItemTest() throws Exception{
         StoreItem expeced = food01;

         StoreItem actual = StoreItemWarehouse.getSingleStoreItem(food01.getName());

         Assert.assertEquals(expeced, actual);
    }

    @Test
    public void sellAnItemTest() throws Exception{
        int expected = 2;

        int actual = StoreItemWarehouse.getSingleStoreItem(tab01.getName()).getAvailableQty();

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = NoItemException.class)
    public void deleteStoreItemTest() throws Exception{
        StoreItemWarehouse.deleteStoreItem(med01.getName());

        StoreItem actual = StoreItemWarehouse.getSingleStoreItem(med01.getName());
    }

    @Test
    public void checkInventoryForItemsTest() throws Exception{
         StoreItem actual = StoreItemWarehouse.getSingleSoldItem(tab01.getName());

         Assert.assertEquals(tab01, actual);
    }

    @Test
    public void clearTotalSoldTest(){
        StoreItemWarehouse.clearSoldItemList();
        int expected = 0;

        int actual = StoreItemWarehouse.getSoldItems().size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void clearSoldItemList() throws Exception{
        StoreItemWarehouse.clearTotalSold();
        int expected = 0;

        int actual = StoreItemWarehouse.getSingleSoldItem(tab01.getName()).getNumberSold();

        Assert.assertEquals(expected, actual);
    }

    @After
    public void deleteSetUp(){
        StoreItemWarehouse.clearSoldItemList();
        StoreItemWarehouse.clearTotalSold();
    }
}
