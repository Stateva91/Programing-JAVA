package goldDigger.models.operation;

import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.spot.Spot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class OperationImpl implements Operation {

    @Override
    public void startOperation(Spot spot, Collection<Discoverer> discoverers) {



        for (Discoverer discoverer : discoverers) {
            while (discoverer.canDig() && !spot.getExhibits().isEmpty()) {
                discoverer.dig();
                String currentExhibit = spot.getExhibits().iterator().next();
                discoverer.getMuseum().getExhibits().add(currentExhibit);
                spot.getExhibits().remove(currentExhibit);


            }


        }


    }

}

