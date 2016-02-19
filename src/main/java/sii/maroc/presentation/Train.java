package sii.maroc.presentation;

import java.util.List;

import sii.maroc.Train.TrainColonFormatter;
import sii.maroc.Train.TrainFactory;
import sii.maroc.Wagon.Wagon;

public class Train {

    private String Type;
    private Trainformatter formatter;
    private List<Wagon> wagons;
    private TrainFactory factory;

    public Train(String Type) {
	factory = TrainFactory.getInstance();
	formatter = TrainColonFormatter.getInstance();
	this.Type = Type;
	this.wagons = factory.createTrain(Type);
    }

    public void detachEnd() {
	final int LAST_WAGON = wagons.size() - 1;
	this.wagons.remove(LAST_WAGON);
    }

    public void detachHead() {
	final int FIRST_WAGON = 0;
	this.wagons.remove(FIRST_WAGON);
    }

    public boolean fill() {

	if (trainIsCargo()) {
	    return fillFirstCargo();
	}
	return false;

    }

    private Boolean trainIsCargo() {
	return Type.contains("C");
    }

    private boolean fillFirstCargo() {

	for (int i = 0; i < wagons.size(); i++) {
	    if (wagons.get(i).WagonIsCargo()) {
		wagons.get(i).fill();
		break;
	    }
	}
	return false;

    }

    public Object print() {

	final String trainFormat = formatter.format(this.wagons);
	return trainFormat;
    }
}
