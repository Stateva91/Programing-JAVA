package magicGame.models.magicians;

import magicGame.common.ExceptionMessages;
import magicGame.models.magics.Magic;

public abstract class MagicianImpl implements Magician{
   private String username;
    private int health;
    private  int protection;
    private boolean isAlive;
    private  Magic magic;

    public MagicianImpl(String username, int health, int protection, Magic magic) {
        if(username ==null || username.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.INVALID_MAGIC_NAME);
        }
        this.username = username;
        if(health<0){
           throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_HEALTH);
        }
        this.health = health;
        updatesAlive();
        if(protection<0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_PROTECTION);
        }
        this.protection = protection;
        if(magic==null){
            throw new NullPointerException(ExceptionMessages.INVALID_MAGIC);
        }
        this.magic = magic;
    }

    private void updatesAlive() {
        this.isAlive=this.health>0;
    }

    @Override
    public void takeDamage(int points) {
        if(points>protection){
            int damageTaken=points-protection;
            health=Math.max(health-damageTaken,0);// ako health e - chislo shte varne 0
            protection=0;
            updatesAlive();
        }else{
            this.protection-=points;
        }
      //  throw new IllegalStateException();

    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getProtection() {
        return protection;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public Magic getMagic() {
        return magic;
    }
    public String toString(){
        return getClass().getSimpleName()+": " +getUsername() + System.lineSeparator()+
                " Health: " + getHealth() + System.lineSeparator()+
                " Protection: "+getProtection() + System.lineSeparator()+
                " Magic: " + getMagic().getName();
    }
}
