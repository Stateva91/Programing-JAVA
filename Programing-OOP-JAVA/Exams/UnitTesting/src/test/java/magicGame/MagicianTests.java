package magicGame;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MagicianTests {
    //TODO
    @Test
    public void testConstructor() {
        Magician m = new Magician("user", 42);
   assertEquals("username", m.getUsername());
   assertEquals("42", m.getHealth());
    }
    @Test
    public void testConstructorNullUsernameThrows() {
        Magician m = new Magician("null", 42);
        assertEquals("username", m.getUsername());
        assertEquals("42", m.getHealth());


    }
        @Test
        public void testAddMagic(){
            throw new IllegalStateException();
        }
        @Test
        public void testGetHealth(){
            throw new IllegalStateException();
        }
        @Test
        public void testGetMagic(){
            throw new IllegalStateException();
        }
        @Test
        public void testGetMagics(){
            throw new IllegalStateException();
        }
        @Test
        public void testGetUsername(){
            throw new IllegalStateException();
        }
        @Test
        public void testRemoveMagic(){
            throw new IllegalStateException();
        }
        @Test
        public void testTakeDamage(){
            throw new IllegalStateException();
        }

    }

