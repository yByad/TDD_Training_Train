package sii.maroc.presentation;

import sii.maroc.Wagon.Wagons;

class Train {

    private String representation;
    private Wagons wagons;

    Train(String Type) {
	this.representation = Type;
	this.wagons = new Wagons(representation);
    }

    void detachEnd() {
	wagons.removeEnd();
    }

    void detachHead() {
	wagons.removeHead();
    }

    boolean fill() {
	if (trainIsCargo()) {
	    wagons.fillCargo();
	}
	return false;
    }

    void attachEnd(String representation) {
	this.representation += representation;
	wagons.attachWagonToTheEnd(representation);
    }

    private Boolean trainIsCargo() {
	return representation.contains("C");
    }

    Object print() {
	final TrainView colonView = new TrainViewColon();
	wagons.print(colonView);
	return colonView.getView();
    }
}
