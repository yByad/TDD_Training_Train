package sii.maroc.presentation;

import sii.maroc.Wagon.Wagons;

class Train {

    private Wagons wagons;
    private TrainView view;

    Train(String Type) {
	this.wagons = new Wagons(Type);
    }

    void detachEnd() {
	wagons.removeEnd();
    }

    void detachHead() {
	wagons.removeHead();
    }

    boolean fill() {
	return wagons.fillCargo();
    }

    void attachEnd(String representation) {
	wagons.attachWagonToTheEnd(representation);
    }

    Object print() {
	view = new TrainViewColon();
	wagons.print(view);
	return view.getView();
    }
}
