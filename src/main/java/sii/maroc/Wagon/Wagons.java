package sii.maroc.Wagon;

import java.util.List;

import sii.maroc.presentation.TrainView;
import sii.maroc.presentation.WagonTypes;

public class Wagons {
    private List<Wagon> wagonsList;
    private TrainFactory factory;
    private String trainRepresentation;
    private String unformattedTrain;

    public Wagons(String representation) {
	this.trainRepresentation = representation;
	factory = TrainFactory.getInstance();
	this.wagonsList = factory.createTrain(representation);
    }

    public void removeHead() {
	if (hasHead()) {
	    final int FIRST_WAGON = 0;
	    this.wagonsList.remove(FIRST_WAGON);
	}
    }

    private boolean hasHead() {
	return trainRepresentation.contains("H");
    }

    public void removeEnd() {
	if (wagonsList.size() > 1) {
	    final int LAST_WAGON = wagonsList.size() - 1;
	    this.wagonsList.remove(LAST_WAGON);
	}
    }

    public void print(TrainView presentation) {
	unformattedTrain = "";
	for (int indexOfWagon = 0; indexOfWagon < wagonsList.size(); indexOfWagon++) {
	    final Wagon wagon = wagonsList.get(indexOfWagon);
	    final WagonTypes wagonType = wagon.getType();
	    unformattedTrain += presentation.getPresentationOf(wagonType);
	}
	presentation.setPresentation(unformattedTrain);
    }

    public boolean fillCargo() {
	Boolean theFillWorked = false;
	for (int i = 0; i < wagonsList.size(); i++) {
	    final Wagon wagonToFill = wagonsList.get(i);
	    theFillWorked = fillWagon(wagonToFill);
	    if (theFillWorked)
		break;
	}
	return theFillWorked;
    }

    private boolean fillWagon(final Wagon wagonToFill) {
	if (wagonToFill.canBeFilled()) {
	    return wagonToFill.fill();
	}
	return false;
    }

    public void attachWagonToTheEnd(String trainRepresentation) {
	final Wagon wagon = new WagonFactory().createWagon(trainRepresentation);
	wagonsList.add(wagon);
    }

}
