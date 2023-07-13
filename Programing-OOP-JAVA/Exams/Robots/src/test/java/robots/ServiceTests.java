package robots;

import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceTests {



    @Test(expected = NullPointerException.class)
    public void testCreateExceptionWhenNullName(){

        new Service(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateExceptionWhenEmptyName(){

        new Service("       ", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateExceptionWhenNegativeCapacity(){

        new Service("valid", -10);
    }
    @Test
    public void testCreateExceptionWhitZeroCapacity(){

        new Service("valid", 0);
    }

    @Test
    public void testCreateExceptionWithValidNameAndPositiveCapacity(){

        new Service("valid", 10);
    }

    @Test
    public void testGetName(){
        Service valid = new Service("valid", 10);
        assertEquals("valid", valid.getName());
    }

    @Test
    public void testGetCapacity(){
        Service valid = new Service("valid", 10);
        assertEquals(10, valid.getCapacity());
    }
    @Test
    public void  testCetCountIsZeroOnEmptyExcavation(){
        Service valid = new Service("valid", 10);
        assertEquals(0, valid.getCount());
    }

    @Test
    public void testCannotAddRobotWithSameName(){
        Service valid = new Service("valid", 2);
        Robot robot = new Robot("name");
        valid.add(robot);
        valid.add(robot);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCannotAddRobotsWithFullCapacity(){
        Service valid = new Service("valid", 2);
        Robot robot1 = new Robot("name1");
        Robot  robot2 = new Robot("name2");
        Robot  robot3 = new Robot("name3");
        valid.add(robot1);
        valid.add(robot2);
        valid.add(robot3);
    }
    @Test
    public void testAddRobotIncreasesCount(){
        Service valid = new Service("valid", 10);
        Robot robot1 = new Robot("name1");
        Robot  robot2 = new Robot("name2");
        Robot  robot3 = new Robot("name3");
        valid.add(robot1);
        valid.add(robot2);
        valid.add(robot3);

        assertEquals(3, valid.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveArcheologistReturnsFalseForMissingName(){
        Service valid = new Service("valid", 1);

        valid.remove("name2");

    }

    @Test
    public void testRemoveArcheologistDecreasesCount(){
        Service valid = new Service("valid", 10);
        Robot robot1 = new Robot("name");
        Robot robot2 = new Robot("name1");
        Robot robot3 = new Robot("name2");
        valid.add(robot1);
        valid.add(robot2);
        valid.add(robot3);

       valid.remove(robot1.getName());


        assertEquals(2, valid.getCount());
    }

    @Test
    public void testStatistics(){
        Service house = new Service("ServiceRobot", 3);
        house.add(new Robot("Kitten"));
        house.add(new Robot("Kitten2"));
        house.add(new Robot("Kitten3"));

        String expected = "The robot Kitten, Kitten2, Kitten3 is in the service ServiceRobot!";

        assertEquals(expected, house.report());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRobotForSaleUnknownRobot(){
        Service service = new Service("ServiceRobot", 1);
        service.forSale("Robot");
    }
    @Test
    public void testRobotForSaleHungry(){
        Service service = new Service("ServiceRobot", 1);
        Robot robot = new Robot("robot");
        service.add(robot);
        service.forSale("robot");

        assertFalse(robot.isReadyForSale());
    }
}
