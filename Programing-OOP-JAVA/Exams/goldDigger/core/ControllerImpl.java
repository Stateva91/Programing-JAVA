package goldDigger.core;

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

import java.util.*;
import java.util.stream.Collectors;

import static goldDigger.common.ConstantMessages.*;
import static goldDigger.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private DiscovererRepository discovererRepository;
    private SpotRepository spotRepository;
    private long countOfExcludedDiscovers;
    private int inspectedSpotCount;


    public ControllerImpl() {
        this.discovererRepository = new DiscovererRepository();
        this.spotRepository = new SpotRepository();
        this.inspectedSpotCount = 0;
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        Discoverer discoverer = null;
        if (kind.equals("Anthropologist")) {
            discoverer = new Anthropologist(discovererName);

        } else if (kind.equals("Archaeologist")) {
            discoverer = new Archaeologist(discovererName);

        } else if (kind.equals("Geologist")) {
            discoverer = new Geologist(discovererName);

        } else {
            throw new IllegalArgumentException(DISCOVERER_INVALID_KIND);
        }
        this.discovererRepository.add(discoverer);


        return String.format(DISCOVERER_ADDED, kind, discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        Spot spot = new SpotImpl(spotName);

        for (String exhibit : exhibits) {
            spot.getExhibits().add(exhibit);
        }
        spotRepository.add(spot);

        return String.format(SPOT_ADDED, spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        Discoverer discoverer = discovererRepository.byName(discovererName);
        if (discoverer == null) {

            throw new IllegalArgumentException(String.format(DISCOVERER_DOES_NOT_EXIST, discovererName));
        } else {
            discovererRepository.remove(discoverer);
        }
        return String.format(DISCOVERER_EXCLUDE, discovererName);
    }

    @Override
    public String inspectSpot(String spotName) {
        List<Discoverer> discoverers = discovererRepository.getCollection().stream()
                .filter(discoverer -> discoverer.getEnergy() > 45).collect(Collectors.toList());
        if (discoverers.isEmpty()) {
            throw new IllegalArgumentException(SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }

        Spot spot = spotRepository.byName(spotName);
        Operation operation = new OperationImpl();
        inspectedSpotCount++;

        operation.startOperation(spot, discoverers);


        countOfExcludedDiscovers = discoverers.stream().filter(discoverer -> discoverer.getEnergy() == 0).count();


        return String.format(INSPECT_SPOT, spotName, countOfExcludedDiscovers);
    }

    @Override
    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format(FINAL_SPOT_INSPECT, inspectedSpotCount)).append(System.lineSeparator());
        builder.append(FINAL_DISCOVERER_INFO).append(System.lineSeparator());
        discovererRepository.getCollection().forEach(d -> {
            builder.append(d.toString());
        });
        return builder.toString().trim();
    }
}

