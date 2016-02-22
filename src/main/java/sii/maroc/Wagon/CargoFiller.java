package sii.maroc.Wagon;

import java.util.List;

public class CargoFiller {

    public boolean fill(final List<Wagon> wagons) {

	for (int i = 0; i < wagons.size(); i++) {
	    if (wagons.get(i).WagonIsCargo()) {
		wagons.get(i).fill();
		break;
	    }
	}
	return false;

    }

}
