package goldDigger.core;

import goldDigger.common.ConstantMessages;
import goldDigger.common.ExceptionMessages;
import goldDigger.models.discoverer.Anthropologist;
import goldDigger.models.discoverer.Archaeologist;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.discoverer.Geologist;
import goldDigger.models.operation.Operation;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.SpotRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller{
    private DiscovererRepository discovererRepository;
    private SpotRepository spotRepository;
    private Operation operation;
    private int inspectionsCount;

    public ControllerImpl() {
        this.discovererRepository=new DiscovererRepository();
        this.spotRepository=new SpotRepository();
        this.operation=new OperationImpl();
        this.inspectionsCount=0;
    }
    @Override
    public String addDiscoverer(String kind, String discovererName) {

        //Check kind
        //Throw  if invalid kind
        //Create discoverer
        //Store in repo
        //Result
        Discoverer discoverer=null; //null
        if(kind.equals("Anthropologist")){
            discoverer=new Anthropologist(discovererName);
        }else if(kind.equals("Archaeologist")){
            discoverer=new Archaeologist(discovererName);
        }else if(kind.equals("Geologist")){
            discoverer=new Geologist(discovererName);
        }else {
            throw new IllegalArgumentException(ExceptionMessages.DISCOVERER_INVALID_KIND);
        }
        discovererRepository.add(discoverer);
        return String.format(ConstantMessages.DISCOVERER_ADDED,kind, discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        Spot spot=new SpotImpl(spotName);

        List<String> items = Arrays.asList(exhibits);
        spot.getExhibits().addAll(items);
        this.spotRepository.add(spot);

        return String.format(ConstantMessages.SPOT_ADDED, spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        Discoverer discoverer = this.discovererRepository.byName(discovererName);
        if(discoverer==null){
            String msg =String.format(ExceptionMessages.DISCOVERER_DOES_NOT_EXIST, discovererName);
            throw new IllegalArgumentException(msg);
        }
        this.discovererRepository.remove(discoverer);
        return String.format(ConstantMessages.DISCOVERER_EXCLUDE, discovererName);

    }

    @Override
    public String inspectSpot(String spotName) {
        Spot spot=this.spotRepository.byName(spotName);

        if(spot== null){

        }
        Collection<Discoverer> collection = this.discovererRepository.getCollection();
        List<Discoverer> goingToMission=new ArrayList<>();
        List<Discoverer> excluded=new ArrayList<>();
        for(Discoverer discoverer: collection){
           if(discoverer.getEnergy()<=45){
               excluded.add(discoverer);
           }else{
               goingToMission.add(discoverer);
           }
        }
        if(goingToMission.isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }
        this.inspectionsCount++;
        this.operation.startOperation(spot, goingToMission);

        return String.format(ConstantMessages.INSPECT_SPOT, spotName, excluded.size());


    }

    @Override
    public String getStatistics() {
        String discoverers=this.discovererRepository.getCollection()
                .stream()
                .map(Discoverer::toString)
                .collect(Collectors.joining("\n"));


       return String.format(ConstantMessages.FINAL_SPOT_INSPECT, this.inspectionsCount)+ "\n"+
                ConstantMessages.FINAL_DISCOVERER_INFO + "\n"+
                discoverers;
    }
}
