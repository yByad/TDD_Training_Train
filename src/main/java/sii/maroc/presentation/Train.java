package sii.maroc.presentation;

import java.util.List;

import sii.maroc.Train.TrainColonFormatter;
import sii.maroc.Train.TrainFactory;
import sii.maroc.Wagon.CargoFiller;
import sii.maroc.Wagon.Wagon;

public class Train {

    private String Type;
    private Trainformatter formatter;
    private List<Wagon> wagons;
    private TrainFactory factory;

    public Train(String Type) {
	factory = TrainFactory.getInstance();
	this.Type = Type;
	this.wagons = factory.createTrain(Type);
    }

    public void detachEnd() {
	if (wagons.size() > 1) {
	    final int LAST_WAGON = wagons.size() - 1;
	    this.wagons.remove(LAST_WAGON);
	}

    }

    public void detachHead() {
	if (wagons.size() > 1) {

	    final int FIRST_WAGON = 0;
	    this.wagons.remove(FIRST_WAGON);
	}
    }

    public boolean fill() {
	if (trainIsCargo()) {

	    final CargoFiller filler = new CargoFiller(wagons);
	    filler.fill();
	}
	return false;

    }

    private Boolean trainIsCargo() {

	return Type.contains("C");
    }

    public Object print() {
	formatter = TrainColonFormatter.getInstance();
	final String trainFormat = formatter.format(this.wagons);
	return trainFormat;
    }
}
