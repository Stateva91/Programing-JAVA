package archeologicalExcavations;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExcavationTests {

    //test constructor
    @Test(expected = NullPointerException.class)
    public void testCreateExceptionWhenNullName(){

        new Excavation(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateExceptionWhenEmptyName(){

        new Excavation("       ", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateExceptionWhenNegativeCapacity(){

        new Excavation("valid", -10);
    }
    @Test
    public void testCreateExceptionWhitZeroCapacity(){

        new Excavation("valid", 0);
    }

    @Test
    public void testCreateExceptionWithValidNameAndPositiveCapacity(){

        new Excavation("valid", 10);
    }

    @Test
    public void testGetName(){
        Excavation valid = new Excavation("valid", 10);
        assertEquals("valid", valid.getName());
    }

    @Test
    public void testGetCapacity(){
        Excavation valid = new Excavation("valid", 10);
        assertEquals(10, valid.getCapacity());
    }

    @Test
    public void  testCetCountIsZeroOnEmptyExcavation(){
        Excavation valid = new Excavation("valid", 10);
        assertEquals(0, valid.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCannotAddArcheologistWithSameName(){
        Excavation valid = new Excavation("valid", 10);
        Archaeologist archaeologist = new Archaeologist("name", 10);
        valid.addArchaeologist(archaeologist);
        valid.addArchaeologist(archaeologist);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCannotAddArcheologistWithFullCapacity(){
        Excavation valid = new Excavation("valid", 2);
        Archaeologist archaeologist1 = new Archaeologist("name1", 10);
        Archaeologist archaeologist2 = new Archaeologist("name2", 10);
        Archaeologist archaeologist3 = new Archaeologist("name3", 10);
        valid.addArchaeologist(archaeologist1);
        valid.addArchaeologist(archaeologist2);
        valid.addArchaeologist(archaeologist3);
    }

    @Test
    public void testAddArcheologistIncreasesCount(){
        Excavation valid = new Excavation("valid", 10);
        Archaeologist archaeologist1 = new Archaeologist("name", 10);
        Archaeologist archaeologist2 = new Archaeologist("name1", 10);
        Archaeologist archaeologist3 = new Archaeologist("name2", 10);
        valid.addArchaeologist(archaeologist1);
        valid.addArchaeologist(archaeologist2);
        valid.addArchaeologist(archaeologist3);

        assertEquals(3, valid.getCount());
    }

    @Test
    public void testRemoveArcheologistReturnsFalseForMissingName(){
        Excavation valid = new Excavation("valid", 10);
        Archaeologist archaeologist1 = new Archaeologist("name1", 10);

        valid.addArchaeologist(archaeologist1);
       boolean result= valid.removeArchaeologist("name2");
        assertFalse(result);
        assertEquals(1, valid.getCount());
    }

    @Test
    public void testRemoveArcheologistDecreasesCount(){
        Excavation valid = new Excavation("valid", 10);
        Archaeologist archaeologist1 = new Archaeologist("name", 10);
        Archaeologist archaeologist2 = new Archaeologist("name1", 10);
        Archaeologist archaeologist3 = new Archaeologist("name2", 10);
        valid.addArchaeologist(archaeologist1);
        valid.addArchaeologist(archaeologist2);
        valid.addArchaeologist(archaeologist3);


        boolean result= valid.removeArchaeologist(archaeologist1.getName());

        assertTrue(result);
        assertEquals(2, valid.getCount());
    }
}

