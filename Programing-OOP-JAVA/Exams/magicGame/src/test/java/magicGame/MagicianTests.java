package magicGame;

import org.junit.Assert;
import org.junit.Test;

public class MagicianTests {
    //TODO


    @Test
    public void createMagicianWithValidName (){
        Magician magician=new Magician("Magic", 10);
        Assert.assertEquals("Magic", magician.getUsername());
        Assert.assertEquals(10, magician.getHealth());
    }

    @Test (expected = IllegalArgumentException.class)
    public void createMagicianWithInvalidHealth(){
        Magician magician=new Magician("Magic", -10);
    }
    @Test(expected = NullPointerException.class)
    public void createMagicianWithInValidNameIsNull(){
        Magician magician=new Magician(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void createMagicianWithInValidNameIsWhitespace(){
        Magician magician=new Magician("    ", 10);
    }
    @Test
    public void addMagicSuccessfully(){
        Magic magic=new Magic("m", 10);
        Magician magician=new Magician("Magic", 10);
        magician.addMagic(magic);
        Assert.assertEquals("m", magician.getMagic(magic.getName()).getName());
    }

    @Test(expected = NullPointerException.class)
    public void addMagicIsNull(){

        Magician magician=new Magician("Magic", 10);
        magician.addMagic(null);

    }
    @Test
    public void removeMagic(){
        Magic magic=new Magic("m", 10);
        Magician magician=new Magician("Magic", 10);
        magician.addMagic(magic);
        boolean removeMagic= magician.removeMagic(magic);
        Assert.assertTrue(removeMagic);
    }
    @Test(expected = Exception.class)
    public void getMagicsShouldReturnUnmodifiableCollection(){
        Magic magic=new Magic("m", 10);
        Magician magician=new Magician("Magic", 10);
        magician.getMagics().add(magic);
    }

    @Test(expected = IllegalStateException.class)
    public void takeDamageShouldThrowWhenHealthIsLessThenZero(){
        Magician magician=new Magician("Magic", 0);
        magician.takeDamage(10);
    }
    @Test
    public void testTakeDamageShouldDecreaseHealth() {
        Magician magician = new Magician("valid", 10);
        magician.takeDamage(5);
        int actualDamage = magician.getHealth();
        Assert.assertEquals(5, actualDamage);
    }

    @Test
    public void testTakeDamageShouldSetHealthToZero() {
        Magician magician = new Magician("valid", 10);
        magician.takeDamage(15);
        int actualDamage = magician.getHealth();
        Assert.assertEquals(0, actualDamage);
    }

}
