package sii.maroc.Wagon;

import java.util.List;

public class CargoFiller {

    private static CargoFiller INSTANCE = new CargoFiller();

    private CargoFiller() {
    }

    public static CargoFiller getInstance() {
	return INSTANCE;
    }

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
