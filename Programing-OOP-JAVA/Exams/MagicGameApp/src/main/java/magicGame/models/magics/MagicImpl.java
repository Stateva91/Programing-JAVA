package magicGame.models.magics;

import magicGame.common.ExceptionMessages;

public abstract class MagicImpl implements Magic{
    private String name;
    private int bulletsCount;

    public MagicImpl( String name, int bulletsCount) {
        if(name==null || name.trim().isEmpty()){
            throw  new NullPointerException(ExceptionMessages.INVALID_MAGIC_NAME);
        }
        this.name = name;
        if(bulletsCount<0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGIC_BULLETS_COUNT);
        }
        this.bulletsCount = bulletsCount;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getBulletsCount() {
        return bulletsCount;
    }
    protected  int doFire(int bullets){
        if(this.getBulletsCount()<1){
            return 0;
        }
        this.bulletsCount-=bullets;
        return bullets;
    }
}
