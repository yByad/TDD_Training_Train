package sii.maroc.presentation;

public enum WagonTypes {

    Passenger, Head, Head_Right, Cargo_Unfilled, Restaurant, Cargo_Filled, Undefined;

    private WagonTypes() {
    }

    public Boolean isOfType(WagonTypes type) {
	return this.equals(type);
    }

}
