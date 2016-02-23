package sii.maroc.Wagon;

import java.util.List;

import sii.maroc.Train.TrainFactory;

public class Wagons {
    private List<Wagon> wagonsList;
    private TrainFactory factory;
    private String representation;

    public Wagons(String representation) {
	this.representation = representation;
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
	return representation.contains("H");
    }

    public void removeEnd() {
	if (wagonsList.size() > 1) {
	    final int LAST_WAGON = wagonsList.size() - 1;
	    this.wagonsList.remove(LAST_WAGON);
	}
    }

    public boolean fillCargo() {
	Boolean didTheFillWork = false;
	for (int i = 0; i < wagonsList.size(); i++) {
	    final Wagon wagonToFill = wagonsList.get(i);
	    didTheFillWork = fillWagon(wagonToFill);
	    if (didTheFillWork)
		break;
	}
	return didTheFillWork;
    }

    private boolean fillWagon(final Wagon wagonToFill) {
	if (wagonToFill.canBeFilled()) {
	    return wagonToFill.fill();
	}
	return false;
    }

    public String getWagonsPresentation() {
	String resultPresentation = "";
	if (HasNoRightHead()) {
	    resultPresentation = createPresentationWithoutRightHead();
	} else {
	    resultPresentation = createPresentationWithRightHead();
	}
	return resultPresentation;
    }

    private String createPresentationWithRightHead() {
	String unformattedTrain = "";
	wagonsList.remove(wagonsList.size() - 1);
	final Wagon rightHead = new Wagon(WagonTypes.Head_Right);
	wagonsList.add(rightHead);
	unformattedTrain = createWagonsPresentation();
	return unformattedTrain;
    }

    private String createPresentationWithoutRightHead() {
	String unformattedTrain = "";
	unformattedTrain = createWagonsPresentation();
	return unformattedTrain;
    }

    private String createWagonsPresentation() {
	String unformattedTrain = "";
	for (int indexOfWagon = 0; indexOfWagon < wagonsList.size(); indexOfWagon++) {
	    unformattedTrain += wagonsList.get(indexOfWagon).retrieveWagonFormat();
	}
	return unformattedTrain;
    }

    private boolean HasNoRightHead() {
	final int LAST_WAGON_INDEX = wagonsList.size() - 1;
	Boolean result = true;
	final Wagon lastWagon = wagonsList.get(LAST_WAGON_INDEX);
	if (lastWagon.isOfType(WagonTypes.Head)) {
	    result = false;
	}
	return result;
    }

    public void addEnd(String representation) {
	final Wagon wagon = new WagonFactory().createWagon(representation);
	wagonsList.add(wagon);
    }

}
