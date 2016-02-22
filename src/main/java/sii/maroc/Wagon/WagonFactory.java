package sii.maroc.Wagon;

public class WagonFactory {

    private static WagonFactory INSTANCE = new WagonFactory();

    public WagonFactory() {
    }

    public static WagonFactory getInstance() {
	return INSTANCE;
    }

    public Wagon createWagon(String wagonType) {

	switch (wagonType) {
	case "H":

	    return new Wagon(WagonTypes.Head);
	case "P":

	    return new Wagon(WagonTypes.Passenger);
	case "C":

	    return new Wagon(WagonTypes.Cargo);
	case "R":

	    return new Wagon(WagonTypes.Restaurant);
	case "Head_End":

	    return new Wagon(WagonTypes.Head_End);
	default:
	    return new Wagon(WagonTypes.Undefined);
	}

    }

}
