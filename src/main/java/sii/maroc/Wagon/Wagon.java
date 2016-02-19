package sii.maroc.Wagon;

public class Wagon {

    private WagonTypes Type;

    public Wagon(String WagonType) {
	this.Type = WagonTypes.valueOf(WagonType);
    }

    public String retrieveWagonFormat() {
	final String wagonFormat = Type.value();
	return wagonFormat;
    }

    public Boolean WagonIsCargo() {
	return this.Type == WagonTypes.C;
    }

    public void fill() {
	this.Type = WagonTypes.C_F;
    }

}
