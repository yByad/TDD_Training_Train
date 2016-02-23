package sii.maroc.presentation;

import sii.maroc.Wagon.Wagons;

public class Train {

    private String representation;
    private Wagons wagons;

    public Train(String Type) {
	this.representation = Type;
	this.wagons = new Wagons(representation);
    }

    public void detachEnd() {
	wagons.removeEnd();
    }

    public void detachHead() {
	wagons.removeHead();
    }

    public boolean fill() {
	if (trainIsCargo()) {
	    wagons.fillCargo();
	}
	return false;
    }

    public void attachEnd(String representation) {
	this.representation += representation;
	wagons.attachWagonToTheEnd(representation);
    }

    private Boolean trainIsCargo() {
	return representation.contains("C");
    }

    public Object print() {
	final TrainViewColon colonView = new TrainViewColon();
	wagons.print(colonView);
	return colonView.getView();
    }
}
