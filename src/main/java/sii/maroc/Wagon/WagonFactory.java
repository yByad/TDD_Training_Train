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

	    return new Wagon("Head");
	case "P":

	    return new Wagon("Passenger");
	case "C":

	    return new Wagon("Cargo");
	case "R":

	    return new Wagon("Restaurant");
	case "Head_End":

	    return new Wagon("Head_End");
	default:
	    return new Wagon("Undefined");
	}

    }

}
