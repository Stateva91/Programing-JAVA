package magicGame.models.region;

import magicGame.common.OutputMessages;
import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.Wizard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RegionImpl implements Region{
    @Override
    public String start(Collection<Magician> magicians) {

        List<Magician> wizards=new ArrayList<>();
        List<Magician> blackWidows= new ArrayList<>();

        for (Magician magician: magicians) {
            if(magician instanceof Wizard){
                wizards.add(magician);
            } else if (magician instanceof BlackWidow){
                blackWidows.add(magician);
            }else {
                throw new IllegalStateException("Unexpected magician type" + magician.getClass().getSimpleName());
            }
        }
        while (!wizards.isEmpty() && !blackWidows.isEmpty()){
            Magician wizard=wizards.get(0);
            Magician blackWidow=blackWidows.get(0);

            blackWidow.takeDamage(wizard.getMagic().fire());
            if(blackWidow.isAlive()){
                wizard.takeDamage(blackWidow.getMagic().fire());
                if(!wizard.isAlive()){
                    wizards.remove(0);
                }
            }else {
                blackWidows.remove(0);
            }
        }
        if(wizards.isEmpty()){
            return "Wizards win!";
        }
        return "Black widows win!";
    }
}
