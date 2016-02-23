package sii.maroc.Wagon;

import sii.maroc.Types.WagonTypes;

class WagonFactory {

    private static WagonFactory INSTANCE = new WagonFactory();

    WagonFactory() {
    }

    static WagonFactory getInstance() {
	return INSTANCE;
    }

    Wagon createWagon(String wagonType) {
	switch (wagonType) {
	case "H":
	    return new Wagon(WagonTypes.Head);
	case "P":
	    return new Wagon(WagonTypes.Passenger);
	case "C":
	    return new Wagon(WagonTypes.Cargo_Unfilled);
	case "R":
	    return new Wagon(WagonTypes.Restaurant);
	case "E":
	    return new Wagon(WagonTypes.Head_Right);
	default:
	    return new Wagon(WagonTypes.Undefined);
	}

    }

}
