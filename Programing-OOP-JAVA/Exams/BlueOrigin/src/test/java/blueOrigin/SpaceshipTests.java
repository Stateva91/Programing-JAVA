package blueOrigin;

import org.junit.Assert;
import org.junit.Test;

public class SpaceshipTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Spaceship

    @Test(expected = IllegalArgumentException.class)
    public  void testCreateHouseWithInvalidCapacity(){

       Spaceship spaceship = new Spaceship("House1", -4);
    }
    //1.2. nevalidno ime
    @Test(expected = NullPointerException.class)
    public void testCreateHouseWithInvalidNameNull(){

        new Spaceship(null, 10);
    }

//    @Test(expected = NullPointerException.class)
//    public  void testCreateHouseWithInvalidName(){
//        new Astronaut("", 4);
//    }
    //1.3 validni stoinosti
    @Test
    public void testCreateHouse(){
        Spaceship spaceship=new Spaceship("House1", 10);
        Assert.assertEquals("House1",spaceship.getName());
        Assert.assertEquals(10,spaceship.getCapacity());
    }

    //2.add Cat
    //2.1 uspeshno dobavqme kotka
    @Test
    public void testAddCat(){
        Spaceship spaceship=new Spaceship("House1", 10);
        Astronaut mike=new Astronaut("Mike", 20.1);
        Assert.assertEquals(0, spaceship.getCount());
       spaceship.add(mike);
        Assert.assertEquals(1, spaceship.getCount());

    }
    //2.2 dobavqme kotka v pusna kushta
    @Test (expected = IllegalArgumentException.class)
    public void testAddCatThrowFiledHouse(){
        Spaceship house=new Spaceship("House1", 1);
       Astronaut mike=new Astronaut("Mike", 20.1);
        house.add(mike);
        Astronaut betty=new Astronaut("Betty", 15.5);
        house.add(betty);
    }
    //3. remove Cat
    //3.1 uspeshno premahvana Cat
    @Test
    public void testRemoveCat(){
        Spaceship house=new Spaceship("House1", 10);
       Astronaut mike=new Astronaut("Mike",20.1);
        Astronaut betty=new Astronaut("Betty", 15.5);
        house.add(mike);
        house.add(betty);
        Assert.assertEquals(2, house.getCount());

        house.remove("Betty");
        Assert.assertEquals(1, house.getCount());
        house.remove("Mike");
        Assert.assertEquals(0, house.getCount());
    }
    //3.2 nqma takava kotka
    @Test
    public void testRemoveNonExceptionCat(){
        Spaceship house=new Spaceship("House1", 10);
        house.remove("Ivan");
    }
    //4 cat for sale
    //4.1 uspeshno prodadena kotka->gladna
//    @Test
//    public void testCarForSale(){
//        Spaceship house=new Spaceship("House1", 10);
//       Astronaut mike=new Astronaut("Mike",20.1);
//        house.add(mike);
//
//        Astronaut returnedCat = house.("Mike");
//        Assert.assertFalse(returnedCat.isHungry());
//    }
    //4.2 nqmame kotka s dadenoto ime
    @Test(expected = IllegalArgumentException.class)
    public void testAddNonExceptionCat(){
        Spaceship spaceship=new Spaceship("House1", 10);
        Astronaut mike=new Astronaut("Mike",20.1);
        Astronaut betty=new Astronaut("Betty", 15.5);
        spaceship.add(mike);
        spaceship.add(mike);
    }

}
