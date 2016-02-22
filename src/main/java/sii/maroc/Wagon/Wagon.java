package sii.maroc.Wagon;

public class Wagon {

    private WagonTypes Type;

    Wagon(WagonTypes type) {
	this.Type = type;
    }

    public String retrieveWagonFormat() {
	final String wagonFormat = Type.value();
	return wagonFormat;
    }

    Boolean WagonIsCargo() {
	return this.Type == WagonTypes.Cargo;
    }

    void fill() {
	this.Type = WagonTypes.Cargo_Full;
    }

}
