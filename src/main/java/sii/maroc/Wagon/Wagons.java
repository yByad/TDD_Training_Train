package sii.maroc.Wagon;

import java.util.List;

import sii.maroc.Types.WagonTypes;
import sii.maroc.presentation.TrainView;

public class Wagons {
    private List<Wagon> wagonsList;
    private TrainFactory factory;

    public Wagons(String representation) {
	factory = new TrainFactory();
	this.wagonsList = factory.createTrain(representation);
    }

    public void removeHead() {
	if (hasHead()) {
	    final int FIRST_WAGON = 0;
	    this.wagonsList.remove(FIRST_WAGON);
	}
    }

    private boolean hasHead() {
	for (int indexOfWagon = 0; indexOfWagon < wagonsList.size(); indexOfWagon++) {
	    final Wagon wagon = wagonsList.get(indexOfWagon);
	    final WagonTypes wagonType = wagon.getType();
	    return wagonType.isOfType(WagonTypes.Head);
	}
	return false;
    }

    public void removeEnd() {
	if (wagonsList.size() > 1) {
	    final int LAST_WAGON = wagonsList.size() - 1;
	    this.wagonsList.remove(LAST_WAGON);
	}
    }

    public void print(TrainView presentation) {
	for (int indexOfWagon = 0; indexOfWagon < wagonsList.size(); indexOfWagon++) {
	    final Wagon wagon = wagonsList.get(indexOfWagon);
	    final WagonTypes wagonType = wagon.getType();
	    presentation.getPresentationOf(wagonType);
	}
    }

    public boolean fillCargo() {
	for (int i = 0; i < wagonsList.size(); i++) {
	    final Wagon wagonToFill = wagonsList.get(i);
	    if (wagonToFill.canBeFilled()) {
		return wagonToFill.fill();
	    }
	}
	return false;
    }

    public void attachWagonToTheEnd(String trainRepresentation) {
	final Wagon wagon = new WagonFactory().createWagon(trainRepresentation);
	wagonsList.add(wagon);
    }

}
