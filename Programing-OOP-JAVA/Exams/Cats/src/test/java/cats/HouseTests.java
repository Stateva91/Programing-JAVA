package cats;

import org.junit.Assert;
import org.junit.Test;

public class HouseTests {

    //1. suzdavane na kushta
    //1.1 nevalidno capacity
    @Test(expected = IllegalArgumentException.class)
    public  void testCreateHouseWithInvalidCapacity(){
        House house = new House("House1", -4);
    }
    //1.2. nevalidno ime
    @Test(expected = NullPointerException.class)
    public  void testCreateHouseWithInvalidNameNull(){
        new House(null, 4);
    }

    @Test(expected = NullPointerException.class)
    public  void testCreateHouseWithInvalidName(){
        new House("", 4);
    }
    //1.3 validni stoinosti
   @Test
    public void testCreateHouse(){
        House house=new House("House1", 10);
       Assert.assertEquals("House1",house.getName());
       Assert.assertEquals(10,house.getCapacity());
   }

   //2.add Cat
    //2.1 uspeshno dobavqme kotka
    @Test
    public void testAddCat(){
        House house=new House("House1", 10);
        Cat mike=new Cat("Mike");
        Assert.assertEquals(0, house.getCount());
        house.addCat(mike);
        Assert.assertEquals(1, house.getCount());

    }
    //2.2 dobavqme kotka v pusna kushta
    @Test (expected = IllegalArgumentException.class)
    public void testAddCatThrowFiledHouse(){
        House house=new House("House1", 1);
        Cat mike=new Cat("Mike");
        house.addCat(mike);
        Cat betty=new Cat("Betty");
        house.addCat(betty);
    }
    //3. remove Cat
    //3.1 uspeshno premahvana Cat
    @Test
    public void testRemoveCat(){
        House house=new House("House1", 10);
        Cat mike=new Cat("Mike");
        Cat betty=new Cat("Betty");
        house.addCat(mike);
        house.addCat(betty);
        Assert.assertEquals(2, house.getCount());

        house.removeCat("Betty");
        Assert.assertEquals(1, house.getCount());
        house.removeCat("Mike");
        Assert.assertEquals(0, house.getCount());
    }
    //3.2 nqma takava kotka
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonExceptionCat(){
        House house=new House("House1", 10);
        house.removeCat("Ivan");
    }
   //4 cat for sale
    //4.1 uspeshno prodadena kotka->gladna
    @Test
    public void testCarForSale(){
        House house=new House("House1", 10);
        Cat mike=new Cat("Mike");
        house.addCat(mike);

        Cat returnedCat = house.catForSale("Mike");
        Assert.assertFalse(returnedCat.isHungry());
    }
    //4.2 nqmame kotka s dadenoto ime
    @Test(expected = IllegalArgumentException.class)
    public void testSaleNonExceptionCat(){
        House house=new House("House1", 10);
        house.catForSale("Ivan");
    }
      @Test
    public void testStatistics(){
          House house=new House("House1", 10);
          Cat mike=new Cat("Mike");
          Cat betty=new Cat("Betty");
          Cat john=new Cat("John");
          house.addCat(mike);
          house.addCat(betty);
          house.addCat(john);

          Assert.assertEquals("Tha cat Mike, Betty, John is in the house House1!", house.statistics());
      }
}
