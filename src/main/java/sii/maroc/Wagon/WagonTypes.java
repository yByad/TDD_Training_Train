package sii.maroc.Wagon;

public enum WagonTypes {

    Passenger("|OOOO|"), Head("<HHHH::"), Head_End("::HHHH>"), Cargo("|____|"), Restaurant("|hThT|"), Cargo_Full(
	    "|^^^^|"), Undefined("|%%%%|");

    private String wagon;

    private WagonTypes(final String wagon) {
	this.wagon = wagon;
    }

    public String value() {
	return this.wagon;
    }

}
