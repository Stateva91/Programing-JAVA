package magicGame.core;

import magicGame.common.ExceptionMessages;
import magicGame.common.OutputMessages;
import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.Wizard;
import magicGame.models.magics.BlackMagic;
import magicGame.models.magics.Magic;
import magicGame.models.magics.RedMagic;
import magicGame.models.region.Region;
import magicGame.models.region.RegionImpl;
import magicGame.repositories.interfaces.MagicRepositoryImpl;
import magicGame.repositories.interfaces.MagicianRepositoryImpl;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ControllerImpl  implements Controller{

    private MagicRepositoryImpl magics= new MagicRepositoryImpl();
    private MagicianRepositoryImpl magicians= new MagicianRepositoryImpl();
    private Region region=new RegionImpl();
    @Override
    public String addMagic(String type, String name, int bulletsCount) {
       Magic magic;
        switch (type){
            case "RedMagic":
                magic=new RedMagic(name, bulletsCount);
                break;
            case "BlackMagic":
                magic=new BlackMagic(name, bulletsCount);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGIC_TYPE);
        }
        magics.addMagic(magic);
        return String.format(OutputMessages.SUCCESSFULLY_ADDED_MAGIC, magic.getName());
    }

    @Override
    public String addMagician(String type, String username, int health, int protection, String magicName) {
         Magician magician;

        Magic magic=magics.findByName(magicName);
        if(magic==null){
            throw new NullPointerException(ExceptionMessages.MAGIC_CANNOT_BE_FOUND);
        }
        switch (type){
            case "Wizard":
                magician=new Wizard(username,health,protection, magic);
                break;
            case "BlackWidow":
                magician=new BlackWidow(username,health,protection, magic);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_TYPE);
        }
           magicians.addMagician(magician);

        return String.format(OutputMessages.SUCCESSFULLY_ADDED_MAGICIAN, magician.getUsername());
    }

    @Override
    public String startGame() {
        Collection<Magician> magiciansAlive=magicians.getData()
                .stream()
                .filter(Magician::isAlive)
                .collect(Collectors.toList());
        return region.start(magiciansAlive);
    }

    @Override
    public String report() {
        String.join(System.lineSeparator(), magicians.getData()
                .stream()
                .sorted(Comparator.comparing(Magician::getHealth).reversed()
                        .thenComparing(Magician::getUsername)
                        .thenComparing(m->m.getClass().getSimpleName()))
                .map(Object::toString)
                .collect(Collectors.toList()));
        return null;
    }
}
