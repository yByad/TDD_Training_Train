package sii.maroc.Wagon;

import java.util.List;

public class CargoFiller {

    final List<Wagon> wagons;

    public CargoFiller(final List<Wagon> wagons) {
	this.wagons = wagons;
    }

    public boolean fill() {

	for (int i = 0; i < wagons.size(); i++) {
	    if (wagons.get(i).WagonIsCargo()) {
		wagons.get(i).fill();
		break;
	    }
	}
	return false;

    }

}
