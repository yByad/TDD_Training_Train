package sii.maroc.presentation;

import sii.maroc.Train.TrainColonFormatter;
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
	wagons.addEnd(representation);
    }

    private Boolean trainIsCargo() {
	return representation.contains("C");
    }

    public Object print() {
	final TrainColonFormatter formatter = TrainColonFormatter.getInstance();
	final String trainFormat = formatter.format(wagons);
	return trainFormat;
    }
}
